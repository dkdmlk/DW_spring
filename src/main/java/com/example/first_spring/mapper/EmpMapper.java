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
	/*
	 특정이상의 급여받는 사람 지우기
	 */
	public List<EmpVO> selectSalDelet();
	/*첫번재 이름이 A인사람 찾기*/
	public List<EmpVO> selectFisrtNameA(String search);
	/*첫번재 이름이 A인사람 찾기*/
	public List<EmpVO> selectEmpEname(String search);
	/*
	 특정직업과 특정급여이상을 받는 사람들의 comm 수정 
	 */
	public List<EmpVO> selectDeptSalA(@Param("deptno") int deptno,
			@Param("sal") int sal);
	public List<EmpVO> selectEmpMgr(@Param("isMgr") String isMgr);
	/*문제 1. 사원번호가 7902번인 사원
	job을 SALESMAN, Sal을 3500으로 수정*/
	public int  updateJobSal(EmpVO empVO);
	/*문제2. 사원번호가 7844번인 사원의 
	comm이 0이거나 null이면 기존 급여에서 500을 추가 (수정)하시오
	comm 이 있다며 0을 리턴
	step1. comm이 null인사람찾기
	*/
	public EmpVO selectEmpCommSal(@Param("empno")int empno);
	/*문제2. 사원번호가 7844번인 사원의 
	comm이 0이거나 null이면 기존 급여에서 500을 추가 (수정)하시오
	comm 이 있다며 0을 리턴
	step2. 기존 급여에서 500을 추가 (수정)하시오 comm 이 있다며 0을 리턴
	*/
	public int updateEmpsal(EmpVO vo);
	/*Map 으로 empList받기*/
	public List<Map<String, Object>> selectEmpMapList();
	/*연봉이 가장 높은 사람 조회(로직)*/
	public Map<String, Object> selectMapMaxsal();
	/*연봉이 가장 높은 사람 조회(쿼리)*/
	public Map<String, Object> selectMapMaxsal2();
	/*상사번호가 7698인 사원의 이름, 사원번호, 상사번호, 상사명을 출력*/
	public List<Map<String, Object>> selectbossMgr(int mgr);
	//모두조회
	public List<EmpVO> selectempAll();
	
	public int updateApi(EmpVO empvo);
}
