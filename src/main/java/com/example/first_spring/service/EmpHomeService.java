package com.example.first_spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.first_spring.mapper.EmpMapper;
import com.example.first_spring.vo.EmpVO;

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
	public EmpVO getEmpnoAllData(int empno) {
			return EmpMapper.getEmpnoAllData(empno);
	}
	//insert
	//rollbackfor: 이전 commit으로 돌아감
	//Exception : 모든에러를 잡아준다.
	@Transactional(rollbackFor = {Exception.class})
	public int setEmp(EmpVO vo) {
		int rows = EmpMapper.insertEmp(vo);//몇행 insert 되었는지 리턴
		return rows;
	}
	//delet
	@Transactional(rollbackFor = {Exception.class})
	public int getEmpRemoveCount(int empNo) {
		int rows = EmpMapper.deleteEmp(empNo);//몇행 delet 되었는지 리턴
		return rows;
	}
	
	@Transactional(rollbackFor = {Exception.class})
	public int getEmpUpdateCount(EmpVO vo) {
		int rows = EmpMapper.updateEmp(vo);//몇행 update 되었는지 리턴
		return rows;
	}
	@Transactional(rollbackFor = Exception.class)
	public List<EmpVO> getEmp(String job,int sal){
		
		if(job.equals("SALESMAN")) {
			return null;
		}
		
		List<EmpVO> list = EmpMapper.selectEmpWhereJobAndSal(job, sal);
		int comm = 500; //커미션
		int rows = 0;
		
		for(int i=0; i<list.size(); i++) {
			int empComm = list.get(i).getComm();
			int sum = empComm + comm;
			list.get(i).setComm(sum);
			EmpVO vo = list.get(i);	
			rows += EmpMapper.updateEmp(vo);
		}
		
		if(rows > 0) {
			return EmpMapper.selectEmpWhereJobAndSal(job, sal);
		}
		
		return null;
	}

	
}
