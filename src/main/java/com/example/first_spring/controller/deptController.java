package com.example.first_spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.first_spring.service.DeptService;
import com.example.first_spring.vo.DeptVO;

@RestController
public class deptController {
	@Autowired
	DeptService deptservice;
	
	@GetMapping("/dept")
	public List<DeptVO> callDeptList(){
		return deptservice.getAllDeptList();
	}
	
}
