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
		
		EmpVO empvo = EmpMapper.selectDept();//empno가 null 인 detpno insert
		int deptno = empvo.getDeptno();
		vo.setDeptno(deptno);
		int rows = EmpMapper.insertEmp(vo);//몇행 insert 되었는지 리턴
		
		return rows;
	}
	//delete
	@Transactional(rollbackFor = {Exception.class})
	public int getEmpRemoveCount(int empNo) {
		List<EmpVO> list = EmpMapper.selectSalDelet();
		int count = 0;
		for(int i=0;i<list.size();++i) {
			int empno = list.get(i).getEmpno();
			if(empNo == empno) {
				int rows = EmpMapper.deleteEmp(empNo);//몇행 delete 되었는지 리턴
				return rows;
			}
		}
		return 0;
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
	
//	public List<EmpVO> getFirstNameA(String search){
//		List<EmpVO> list = EmpMapper.selectFisrtNameA(search);
//		int count=0;
//		for(int i=0;i<list.size();++i) {
//			if(list.get(i).getEname().substring(0,1).equals(search)) {
//				++count;
//			}
//		}
//		return list;
//	}
	
	public List<EmpVO> getEmpEname(String search){
		List<EmpVO> list = EmpMapper.selectEmpEname(search);
		int count=0;
		for(int i=0;i<list.size();++i) {
			if(list.get(i).getEname().substring(0,1).equals(search)) {
				++count;
			}
		}
		System.out.println("이름이 A인 사람 수는! : " +count+"명");
		return list;
	}
//	public List<EmpVO> getDeptSalA(int deptno,int sal){
//		List<EmpVO> list = EmpMapper.selectDeptSalA(deptno, sal);
//		List<EmpVO> list2 = new ArrayList<EmpVO>();
//		for(int i=0; i<list.size();++i) {
//			int comm = list.get(i).getComm();
//			if(comm < 100 || comm == 0) {
//				list2.add(list.get(i));
//				return list2;
//			}
//		}
//		return EmpMapper.selectDeptSalA(deptno, sal);
//	}
	
	public List<EmpVO> getEmpIsMgrList(String isMgr){
		return EmpMapper.selectEmpMgr(isMgr);
	}
	
	public int getUpdateSalJob(int empno, EmpVO vo) {
		vo.setEmpno(empno);
		return EmpMapper.updateJobSal(vo);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public int getEmpUpdateSalCount(int empno) {
		EmpVO vo = EmpMapper.selectEmpCommSal(empno);
		int comm = vo.getComm();
		if(comm == 0) {
			int bouns = 500;
			int sal = vo.getSal();
			vo.setSal(sal + bouns);
			//Update 로직 추가
			return EmpMapper.updateEmpsal(vo);
		}
		return 0;
	}
}
