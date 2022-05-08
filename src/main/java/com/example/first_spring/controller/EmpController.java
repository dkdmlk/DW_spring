package com.example.first_spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.first_spring.service.EmpHomeService;
import com.example.first_spring.vo.EmpVO;
import com.example.first_spring.vo.JoinVo;
@RestController
public class EmpController {
	@Autowired
	EmpHomeService empHomeService;
	
	//문제 0. 급여 1500을 파라미터로 받고 부서가 10, 30에 속하는 사원 중 급여가 1500을 넘는 사원의 이름 및 급여 조회.
	@GetMapping("/emp/sal/{sal}")
	public List<EmpVO> callsal(@PathVariable("sal") int sal){
		return empHomeService.getSalName(sal);
	}
	//문제 1. emp에서 사수가 없는 사원 조회
	@GetMapping("/emp/mgr")
	public List<EmpVO> callNullMgr(){
		return empHomeService.getNullMgr();
	}
	//문제 2. 1987년도를 파리미터로 받고 해당 년도에 입사한 사원 조회 
	@GetMapping("/emp/hiredate/year/{year}")
	public List<EmpVO> getHideDate(@PathVariable("year") int hiredate){
		return empHomeService.getHideDate(hiredate);
	}
	//문제 3. 12월를 파라미터로 받고 해당 월에 입사한 사원 중 급여가 가장 많은 사원 조회
	@GetMapping("/emp/hiredate/month/{month}")
	public EmpVO getHideDatasal(@PathVariable("month") int hiredate){
		return empHomeService.getHideDatasal(hiredate);
	}
	//문제 4. MANAGER를 파라미터로 받고 job이 MANAGER 중 입사날짜가 가장 빠른 사원의 이름, 입사날짜, 급여 조회 
	@GetMapping("/emp/job/{jobName}")
	public EmpVO getJobMANAGER(@PathVariable("jobName") String job) {
		return empHomeService.getJobMANAGER(job);
	}
	//(join 문제)*문제 5. 사원번호 7782를 파라미터로 받고 해당 사원의 모든 정보(부서번호, 부서이름, 부서위치 포함) 조회
	@GetMapping("/emp/empno/{empno}")
	public JoinVo getEmpnoAllData(@PathVariable("empno") int empno) {
		return empHomeService.getEmpnoAllData(empno);
}
	
}







