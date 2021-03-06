package com.cos.blog.controller.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.dto.ResponseDto;
import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.service.UserService;

@RestController
public class UserApiController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> save(@RequestBody User user) {//username, password, email
		System.out.println("UserApiController : save호출됨");
		//실제로 DB에 INSERt를하고 아래에서 Return이 되면 되요.
		userService.회원가입(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);//자바오브젝트를 JSON으로 변환해서 리턴(Jackson)
	}
}
