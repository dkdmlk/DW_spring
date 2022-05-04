package com.example.first_spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.first_spring.service.MainService;
import com.example.first_spring.vo.UserVO;

@RestController
public class ActorController {
	@Autowired
	MainService service;
	
	@GetMapping("/actor/list")
	public List<UserVO> callUserList(HttpServletRequest request){
		String ip = request.getHeader("X-forwarded-For");
		if(ip ==null) {
			ip = request.getRemoteAddr();
		} 
		System.out.println("IP=====> "+ip);
		return service.getUserList();
	}
	@GetMapping("/actor/age")
	public int callUserAgeMax(){
		return service.getUserAgeMax();
	}
	@GetMapping("/actor")
	public UserVO callGetUser() {
		return service.getUser();
	}
	@GetMapping("/actor/count")
	public int callgetUserCount() {
		return service.getUserCount();
	}

}
