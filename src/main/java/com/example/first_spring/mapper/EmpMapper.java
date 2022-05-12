package com.example.first_spring.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.first_spring.vo.EmpVO;

@Mapper
public interface EmpMapper {
	
	//문제 0. 급여 1500을 파라미터로 받고 부서가 10, 30에 속하는 사원 중 급여가 1500을 넘는 사원의 이름 및 급여 조회.
	public List<EmpVO> getSalName(int sal);
	//문제 1. emp에서 사수가 없는 사원 조회
	public List<EmpVO> getNullMgr();
	//문제 2. 1987년도를 파리미터로 받고 해당 년도에 입사한 사원 조회 
	public List<EmpVO> getHideDate(int hiredate);
	//문제 3. 12월를 파라미터로 받고 해당 월에 입사한 사원 중 급여가 가장 많은 사원 조회
	public EmpVO getHideDatasal(int hiredate);
	//문제 4. MANAGER를 파라미터로 받고 job이 MANAGER 중 입사날짜가 가장 빠른 사원의 이름, 입사날짜, 급여 조회 
	public EmpVO getJobMANAGER(String job);
	//(join 문제)*문제 5. 사원번호 7782를 파라미터로 받고 해당 사원의 모든 정보(부서번호, 부서이름, 부서위치 포함) 조회
	public EmpVO getEmpnoAllData(int empno);
	
	//insert : 한 행 에 insert하기에 파라미터값 empVO 리턴타입 int
	public int insertEmp(EmpVO empVO);
	//delete 데이터 삭제 PK로 삭제 하기떄문에 PK인 empno를 파라미터값으로 받고 int 로 리턴
	public int deleteEmp(int empno); 
	//update 한 행 에 update를 하기에 파라미터값 empVO 리턴타입 int
	public int updateEmp(EmpVO empVO);
	//mybatis에 2개 이상 파라미터를 넘길 때는 @Param이용해서 이름 지정!
	public List<EmpVO> selectEmpWhereJobAndSal(
			@Param("job") String job,
			@Param("sal") int sal);
	public EmpVO selectDept();
	
	public List<EmpVO> selectSalDelet();
	
	public List<EmpVO> selectFisrtNameA(String search);
	
	public List<EmpVO> selectEmpEname(String search);
	
	public List<EmpVO> selectDeptSalA(@Param("deptno") int deptno,
			@Param("sal") int sal);
	public List<EmpVO> selectEmpMgr(@Param("isMgr") String isMgr);
	
	public int  updateJobSal(EmpVO empVO);
		
	public EmpVO selectEmpCommSal(@Param("empno")int empno);
	
	public int updateEmpsal(EmpVO vo);
	
	public List<Map<String, Object>> selectEmpMapList();
	
	public Map<String, Object> selectMapMaxsal();
}
