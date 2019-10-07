package com.cskaoyan.mall.wx.controller;

import com.cskaoyan.mall.admin.bean.CskaoyanMallUser;
import com.cskaoyan.mall.admin.bean.CskaoyanMallUserExample;
import com.cskaoyan.mall.admin.config.CustomToken;
import com.cskaoyan.mall.admin.mapper.CskaoyanMallUserMapper;
import com.cskaoyan.mall.admin.vo.BaseResponseVo;
import com.cskaoyan.mall.wx.config.UserTokenManager;
import com.cskaoyan.mall.wx.service.CskaoyanMallUserService;
import com.cskaoyan.mall.wx.util.UserInfo;
import com.cskaoyan.mall.wx.util.UserToken;
import com.cskaoyan.mall.wx.vo.BaseRespVo;
import com.cskaoyan.mall.wx.vo.LoginVo;
import com.cskaoyan.mall.wx.vo.WxReqVo;
import com.cskaoyan.mall.wx.vo.homeIndex.UserOrderVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/wx")
public class WxAuthController {

	@Autowired
	CskaoyanMallUserService userService;

	Subject subject;

	@RequestMapping("/auth/login")
	public Object login(@RequestBody@Valid LoginVo loginVo, HttpServletRequest request) {

		String username = loginVo.getUsername();
		String password = loginVo.getPassword();
		CustomToken token = new CustomToken(username, password, "wx");
		//设置携带了用户信息的token
		subject = SecurityUtils.getSubject();
		try {
			//进入到reaml域中进行认证
			subject.login(token);
		} catch (AuthenticationException e) {
			return BaseResponseVo.fail("登录失败",500);
		}
		Serializable id = subject.getSession().getId();
		System.out.println(id);
		//*******************************
		// userInfo
		UserInfo userInfo = new UserInfo();
		userInfo.setNickName(username);
		//userInfo.setAvatarUrl(user.getAvatar());

		// token
//		UserToken userToken = UserTokenManager.generateToken(userId);
		LocalDateTime update = LocalDateTime.now();
		LocalDateTime expire = update.plusDays(1);

		Map<Object, Object> result = new HashMap<Object, Object>();
		result.put("token", id);
		result.put("tokenExpire", expire.toString());
		result.put("userInfo", userInfo);
		return BaseRespVo.ok(result);
	}

	@GetMapping("user/index")
	public Object list() {
		Serializable id = subject.getSession().getId();
		System.out.println(id);
		String principal = (String) subject.getPrincipal();
		Integer userId = userService.queryUserIdByUserName(principal);
//		//通过请求头获得userId，进而可以获得一切关于user的信息
		//**************************
		if (userId == null) {
			return BaseRespVo.fail();
		}

		Map<Object, Object> data = new HashMap<Object, Object>();
		//***********************************
		//根据userId查询订单信息
		UserOrderVo orderVo = userService.selectOrderMsg(userId);
		data.put("order", orderVo);
		//***********************************

		return BaseRespVo.ok(data);
	}

	@RequestMapping("auth/logout")
	public BaseRespVo logout(HttpServletRequest request){
		subject.logout();
		BaseRespVo baseRespVo = new BaseRespVo();
		baseRespVo.setErrmsg("成功");
		baseRespVo.setErrno(0);
		return baseRespVo;
	}

	@RequestMapping("auth/login_by_weixin")
	public BaseRespVo loginByWx(@RequestBody WxReqVo wxReqVo){
		String code1 = wxReqVo.getCode();
		UserInfo userInfo = wxReqVo.getUserInfo();
		System.out.println(userInfo);
		//***********还没做***************
		return BaseRespVo.fail();
	}



	@RequestMapping("auth/reset")
	public BaseRespVo reset(){
		return BaseRespVo.fail();
	}


	@RequestMapping("auth/bindPhone")
	public BaseRespVo bindPhone(){
		return BaseRespVo.fail();
	}
}
