package com.cskaoyan.mall.wx.controller;


import com.cskaoyan.mall.admin.bean.CskaoyanMallUser;
import com.cskaoyan.mall.admin.mapper.CskaoyanMallUserMapper;
import com.cskaoyan.mall.wx.config.UserTokenManager;
import com.cskaoyan.mall.wx.service.CskaoyanMallUserService;
import com.cskaoyan.mall.wx.service.SmsService;
import com.cskaoyan.mall.wx.util.UserInfo;
import com.cskaoyan.mall.wx.util.UserToken;
import com.cskaoyan.mall.wx.vo.AvatorData;
import com.cskaoyan.mall.wx.vo.BaseRespVo;
import com.cskaoyan.mall.wx.vo.LoginVo;
import com.cskaoyan.mall.wx.vo.homeIndex.UserOrderVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/wx")
public class WxAuthController {

	@Autowired
	CskaoyanMallUserMapper userMapper;

	@Autowired
	CskaoyanMallUserService userService;

	@Autowired
	SmsService smsService;

	@PostMapping("auth/regCaptcha")
	public BaseRespVo sendValidateCode(@RequestBody Map map){
		BaseRespVo baseRespVo = new BaseRespVo();
		String code = (int)((Math.random()*9+1)*100000)+"";
		String mobile = (String) map.get("mobile");
		//验证码功能暂不开启，需要的可以将注释取消
//		boolean flag = smsService.sendMessage(mobile,code);
		boolean flag = true;
		if(flag){
			//发送成功或失败
			Session session = SecurityUtils.getSubject().getSession();
			//将验证码放入session中注册时一起传入
			session.setAttribute("code",code);
			Serializable sessionId = session.getId();
			System.out.println(sessionId);
			baseRespVo.setData(sessionId);
			baseRespVo.setErrmsg("获取验证码成功");
			baseRespVo.setErrno(0);
		}else{
			baseRespVo.setErrmsg("获取验证码失败,请重新获取");
			baseRespVo.setErrno(701);
		}
		return baseRespVo;
	}

	@RequestMapping("/auth/login")
	public Object login(@RequestBody LoginVo loginVo, HttpServletRequest request) {
		String username = loginVo.getUsername();
		String password = loginVo.getPassword();
		CskaoyanMallUser user = userMapper.selectByUsernameAndPassword(username,password);
		//此处不实现过期时间设置，
		Date tokenExpire = user.getUpdateTime();
		if (user==null){
			BaseRespVo fail = BaseRespVo.fail(500, "账号或密码错误！");
			return fail;
		}
		UserInfo userInfo = new UserInfo();
		userInfo.setNickName(user.getNickname());
		userInfo.setAvatarUrl(user.getAvatar());
		// token
		Serializable sessionId = SecurityUtils.getSubject().getSession().getId();
		System.out.println(sessionId);
		Map<Object, Object> result = new HashMap<Object, Object>();
		result.put("token", sessionId);
		result.put("tokenExpire", tokenExpire);
		result.put("userInfo", userInfo);
		return BaseRespVo.ok(result);
	}

	@GetMapping("user/index")
	public Object list(HttpServletRequest request) {

		Subject subject = SecurityUtils.getSubject();
		String principal = (String) subject.getPrincipal();
		Serializable id = subject.getSession().getId();
		System.out.println(id);
//		if (username == null) {
//			return BaseRespVo.fail();
//		}
		Map<Object, Object> data = new HashMap<Object, Object>();
		//***********************************
		//根据userId查询订单信息
//		UserOrderVo orderVo = userService.selectOrderMsg(userna);
//		data.put("order", orderVo);
		//***********************************

		return BaseRespVo.ok(data);
	}

	@RequestMapping("auth/logout")
	public BaseRespVo logout(HttpServletRequest request){
		String tokenKey = request.getHeader("X-cskaoyanmall-Admin-Token");
		Integer userId = UserTokenManager.getUserId(tokenKey);
		UserTokenManager.removeToken(userId);
		BaseRespVo baseRespVo = new BaseRespVo();
		baseRespVo.setErrmsg("成功");
		baseRespVo.setErrno(0);
		return baseRespVo;
	}

	@RequestMapping("auth/register")
	public BaseRespVo register(@RequestBody Map map){
		Session session = SecurityUtils.getSubject().getSession();
//		System.out.println(session.getId());
		String codeFromSession = (String) session.getAttribute("code");
		String code = (String) map.get("code");
		String mobile = (String) map.get("mobile");
		String password = (String) map.get("password");
		String username = (String) map.get("username");
		//wxCode为设置，不知道什么作用
		boolean flag = userService.registerUser(mobile,username,password);
		BaseRespVo baseRespVo = new BaseRespVo();
//假设验证码成功
	/*	if (!code.equals(codeFromSession)){
			baseRespVo.setErrmsg("验证码错误！");
			baseRespVo.setErrno(701);
        }else */
        	if(!flag){
			baseRespVo.setErrmsg("注册失败");
			baseRespVo.setErrno(101);
		}else{
			AvatorData avatorData = new AvatorData();
			LoginVo loginVo = new LoginVo();
			//携带userInfo才可以转跳至首页
			avatorData.setAvatar("");
			avatorData.setNickname(username);
			loginVo.setUserInfo(avatorData);
			baseRespVo.setData(loginVo);
			baseRespVo.setErrmsg("注册成功");
			baseRespVo.setErrno(0);
		}
		return baseRespVo;
	}
}
