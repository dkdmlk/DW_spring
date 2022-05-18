package com.example.first_spring.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.first_spring.service.EmpHomeService;
import com.example.first_spring.vo.EmpVO;
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
	public EmpVO getEmpnoAllData(@PathVariable("empno") int empno) {
		return empHomeService.getEmpnoAllData(empno);
	}
	//emp테이블에 insert
	//@PostMapping: 중요한 정보를 보내거나, 데이터를 보낼 때 post 사용
	//대표적인 ex)회원가입
	//@RequestBody가 파라미터로 넘어오는 VO클래스를 대신 new 해줌
	@CrossOrigin(origins = {"*"})
	@PostMapping("/emp")
	public int callEepSet(@RequestBody EmpVO empVo) {
		return empHomeService.setEmp(empVo);
	}
	
	//@DeleteMapping: 자원 삭제할 때 사용
	@CrossOrigin(origins = {"*"})
	@DeleteMapping("/emp/empno/{empno}")
	public int callEmpRemove(@PathVariable("empno") int empno) {
		return empHomeService.getEmpRemoveCount(empno);
	}
	
	//update
	@PatchMapping("/emp")
	public int callEmpUpdate(@RequestBody EmpVO empVo) {
		return empHomeService.getEmpUpdateCount(empVo);
	}
	/*
	 특정직업과 특정급여이상을 받는 사람들의 comm 수정 
	 */
	@GetMapping("/emp/job/{jobName}/sal/{sal}")
	public List<EmpVO> callEmp(@PathVariable("jobName") String jobName, 
			@PathVariable("sal") int sal) {
	
		return empHomeService.getEmp(jobName, sal);
	}
	
	//쿼리스트링으로 getMapping
	//tier?region=kr&name=inseok (추가로 검색할떄 & 사용)
	//검색할 때 많이 사용
	@GetMapping("/tier")
	public String calltier(@RequestParam("region") String region,@RequestParam("name") String name) {
		return region + ", " + name;
	}
	//board?page=1&pageSize=10&writer=강인석
	//게시판의 페이지 행렬의수 작성자
	@GetMapping("/board")
	public int callBoard(@RequestParam("page")int page,
	@RequestParam("pageSize")int pageSize,@RequestParam("writer") String writer) {
		System.out.println("현재 페이지는 : "+page);
		System.out.println("한 페이지에 보여주는 row 수는 : "+pageSize);
		System.out.println("작성자는 : "+ writer);
		return 0;
	}
	
	// 문제1. A로시작하는 사람수 구하기 /emp/name?search=A
//	@GetMapping("/emp/name")
//	public List<EmpVO> callNameA(@RequestParam("search") String search){
//		return empHomeService.getFirstNameA(search);
//	}
	
	/*첫번재 이름이 A인사람 찾기
	 emp/name?search=A*/
	@GetMapping("/emp/name")
	public List<EmpVO> callEmpEname(@RequestParam("search") String search){
		return empHomeService.getEmpEname(search);
	}
	
//	@GetMapping("/emp/dept/deptno/{deptno}/sal/{sal}")
//	public List<EmpVO> callDeptSalA(@PathVariable("deptno") int deptno,@PathVariable("sal")int sal){
//		return empHomeService.getDeptSalA(deptno, sal);
//	}
	
	
	//사원사수여부
	@GetMapping("/emp/mgr/{isMgr}")
	public List<EmpVO> callEmpIsMgrList(@PathVariable("isMgr") String isMgr){
		return empHomeService.getEmpIsMgrList(isMgr);
	}
	/*문제 1. 사원번호가 7902번인 사원
	job을 SALESMAN, Sal을 3500으로 수정*/
	@CrossOrigin(origins = {"*"})
	@PatchMapping("/emp/{empno}")
	public int callEmpSalJobUpdate(@PathVariable("empno")int empno, @RequestBody EmpVO empvo) {
		return empHomeService.getUpdateSalJob(empno, empvo);
	}
	/*문제2. 사원번호가 7844번인 사원의 
		comm이 0이거나 null이면 기존 급여에서 500을 추가 (수정)하시오
		comm 이 있다며 0을 리턴*/
	@PatchMapping("/emp/empno/{empno}")
	public int callEmpCommUpdate(@PathVariable("empno")int empno) {
		return empHomeService.getEmpUpdateSalCount(empno);
	}
	/*Map 으로 empList받기*/
	@GetMapping("/emp/map/list")
	public List<Map<String, Object>> callEmpMapList(){
		return empHomeService.getEmpMapList();
	}
	/*연봉이 가장 높은 사람 조회(로직)*/
	@GetMapping("/emp/map/Maxsal")
	public Map<String, Object> callMapMaxSal(){
		return empHomeService.getMapMaxSal();
	}
	/*연봉이 가장 높은 사람 조회(쿼리)*/
	@GetMapping("/emp/map/sal/Maxsal")
	public Map<String, Object> callMapMaxSal2(){
		return empHomeService.getMapMaxSal2();
	}
	/*상사번호가 7698인 사원의 이름, 사원번호, 상사번호, 상사명을 출력*/
	@GetMapping("/emp/map/mgr/{bossMgr}")
	public List<Map<String, Object>> callBossMgr(@PathVariable("bossMgr")int mgr){
		return empHomeService.getbossMgr(mgr);
	}
	//모두조회 ajax
	@CrossOrigin(origins = {"*"})
	@GetMapping("/emp/all")
	public List<EmpVO> callEmpAll(){
		return empHomeService.getEmpAll();
	}
	
	@CrossOrigin(origins = {"*"})
	@PatchMapping("/spi/v1/emp/{empno}")
	public int callApi(@PathVariable("empno")int empno, @RequestBody EmpVO empvo) {
		return empHomeService.getApi(empno, empvo);
	}
}







