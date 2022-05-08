package com.example.first_spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.first_spring.mapper.EmpMapper;
import com.example.first_spring.vo.EmpVO;
import com.example.first_spring.vo.JoinVo;

@Service
public class EmpHomeService {
	@Autowired
	private EmpMapper EmpMapper;
	//문제0
	public List<EmpVO> getSalName(int sal) {
		return EmpMapper.getSalName(sal);
	}
	//문제1
	public List<EmpVO> getNullMgr(){
		return EmpMapper.getNullMgr();
	}
	//문제2
	public List<EmpVO> getHideDate(int hiredate){
		return EmpMapper.getHideDate(hiredate);
	}
	//문제3
	public EmpVO getHideDatasal(int hiredate){
		return EmpMapper.getHideDatasal(hiredate);
	}
	//문제 4. MANAGER를 파라미터로 받고 job이 MANAGER 중 입사날짜가 가장 빠른 사원의 이름, 입사날짜, 급여 조회 
	public EmpVO getJobMANAGER(String job) {
		return EmpMapper.getJobMANAGER(job);
	}
		//(join 문제)*문제 5. 사원번호 7782를 파라미터로 받고 해당 사원의 모든 정보(부서번호, 부서이름, 부서위치 포함) 조회
	public JoinVo getEmpnoAllData(int empno) {
			return EmpMapper.getEmpnoAllData(empno);
	}
}
