package com.cskaoyan.mall.wx.controller;

import com.cskaoyan.mall.admin.config.CustomToken;

import com.cskaoyan.mall.admin.bean.CskaoyanMallUser;
import com.cskaoyan.mall.admin.mapper.CskaoyanMallUserMapper;
import com.cskaoyan.mall.admin.vo.BaseResponseVo;
import com.cskaoyan.mall.wx.service.SmsService;
import com.cskaoyan.mall.wx.service.WxUserService;
import com.cskaoyan.mall.wx.util.UserInfo;
import com.cskaoyan.mall.wx.vo.*;
import com.cskaoyan.mall.wx.vo.homeIndex.UserOrderVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/wx")
public class WxAuthController {

    @Autowired
    CskaoyanMallUserMapper userMapper;

	@Autowired
	WxUserService userService;

	@Autowired
	SmsService smsService;


	@PostMapping("auth/regCaptcha")
	public BaseRespVo sendValidateCode(@RequestBody Map map){
		BaseRespVo baseRespVo = new BaseRespVo();
		String code = (int)((Math.random()*9+1)*100000)+"";
		String mobile = (String) map.get("mobile");
		//验证码功能暂不开启，需要的可以将注释取消
		boolean flag = smsService.sendMessage(mobile,code);
//		boolean flag = true;
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

		CskaoyanMallUser user = userService.selectByUsernameAndPassword(username,password);
		//此处不实现过期时间设置，
		if (user==null){
			BaseRespVo fail = BaseRespVo.fail(500, "账号或密码错误！");
			return fail;
		}
		//设置携带了用户信息的token
		CustomToken token = new CustomToken(username, password, "wx");
		Subject subject = SecurityUtils.getSubject();
		try {
			//进入到reaml域中进行认证
			subject.login(token);
		} catch (AuthenticationException e) {
			return BaseResponseVo.fail("登录失败",500);
		}
		Serializable id = subject.getSession().getId();
		// userInfo
		UserInfo userInfo = new UserInfo();
		userInfo.setNickName(user.getNickname());
		userInfo.setAvatarUrl(user.getAvatar());
		LocalDateTime update = LocalDateTime.now();
		LocalDateTime expire = update.plusDays(7);

		Map<Object, Object> result = new HashMap<Object, Object>();
		result.put("token", id);
		result.put("tokenExpire", expire.toString());
		result.put("userInfo", userInfo);
		return BaseRespVo.ok(result);
	}


	@GetMapping("user/index")
	public BaseRespVo list(HttpServletRequest request) {
		Subject subject = SecurityUtils.getSubject();
		String principal = (String) subject.getPrincipal();
		Integer userId = userService.queryUserIdByUserName(principal);
		if (userId == null) {
			return BaseRespVo.fail();
		}
		Map<Object, Object> data = new HashMap<Object, Object>();
		UserOrderVo orderVo = userService.selectOrderMsg(userId);
		data.put("order", orderVo);
		return BaseRespVo.ok(data);
	}

	@RequestMapping("auth/logout")
	public BaseRespVo logout(HttpServletRequest request){
		Subject subject = SecurityUtils.getSubject();
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
	public BaseRespVo reset(@RequestBody ResetpwVo resetpwVo){
		Session session = SecurityUtils.getSubject().getSession();
		String codeFromSession = (String) session.getAttribute("code");
		String code = resetpwVo.getCode();
		String mobile = resetpwVo.getMobile();
		String password = resetpwVo.getPassword();
//		假设验证码成功
   		 if (!code.equals(codeFromSession)){
			 return BaseRespVo.fail(703,"验证码错误！");
        }else {
   		 	 userService.updatePwByMobile(mobile,password);
			 return BaseRespVo.ok(null);
		}
	}


	@RequestMapping("auth/bindPhone")
	public BaseRespVo bindPhone() {
		return BaseRespVo.fail();
	}

	@RequestMapping("auth/register")
	public BaseRespVo register(@RequestBody Map map){
		Session session = SecurityUtils.getSubject().getSession();
		String codeFromSession = (String) session.getAttribute("code");
		String code = (String) map.get("code");
		String mobile = (String) map.get("mobile");
		String password = (String) map.get("password");
		String username = (String) map.get("username");
		//wxCode为设置，不知道什么作用
		boolean flag = userService.registerUser(mobile,username,password);
		BaseRespVo baseRespVo = new BaseRespVo();
		//假设验证码成功
   		 if (!code.equals(codeFromSession)){
         baseRespVo.setErrmsg("验证码错误！");
         baseRespVo.setErrno(701);
        }else
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
