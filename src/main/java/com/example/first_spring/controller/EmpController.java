package com.example.first_spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.first_spring.service.EmpService;
import com.example.first_spring.vo.EmpVO;
@RestController
public class EmpController {
	@Autowired
	EmpService EmpService;
	
	@GetMapping("/emp")
	public List<EmpVO> callEmpList(){
		return EmpService.getAllempList();
	}
	@GetMapping("/emp/1")
	public EmpVO callEmpVO(){
		return EmpService.getEmp();
	}

}







