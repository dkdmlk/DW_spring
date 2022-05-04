package com.example.first_spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.first_spring.service.MainService;
import com.example.first_spring.vo.UserVO;

//@Controller: url을 요청받는 곳
@RestController
public class MainController {
	@Autowired //Spring이 해당 객체(클레스)를 관리해줌.IoC(Inversion of Control)
	MainService service;
	
	@GetMapping("/index")
	public String call() { // index라는 주소를 요청하면 call()메소드를 실행~
		String word = "강인석 Hello World!";
		return word;
	}
	
	@GetMapping("/sum")
	public int callSum() {
		int x = 10;
		int y = 100;
		return x+y;
	}
	
	@GetMapping("/user")
	public UserVO callUser() {
		UserVO vo = new UserVO("홍길동",20,"대전");
		return vo;
	}
	
	@GetMapping("/userList")
	public List<UserVO> callUserList(){
		List<UserVO> list = new ArrayList<UserVO>();
		list = service.getUserList();
		return list;
	}
}







