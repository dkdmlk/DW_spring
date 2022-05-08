package com.example.first_spring.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import com.example.first_spring.mapper.MainMapper;
import com.example.first_spring.vo.EmpVO;

@Service
public class EmpService {
	@Autowired
	private MainMapper mainMapper;
	
	
	public List<EmpVO> getAllempList(){
		return mainMapper.getEmpList();
	}
	public EmpVO getEmp() {
		return mainMapper.getEmp();
	}
	//문제 2. 1987년에 입사한 사원 수가 3명 이하면 1981년에 입사한 사원으로 조회하시오.
	public List<EmpVO> getEmpName() {
		List<EmpVO> list = mainMapper.getEmpList();
		List<EmpVO> list2 = new ArrayList<EmpVO>();
		int count = 0;
		for(int i=0;i<list.size();++i) {
			if(list.get(i).getHiredate().equals("1987")) {
				++count;
			}
			if(count <3) {
				if(list.get(i).getHiredate().equals("1981")){
					list2.add(list.get(i));
				}
			}
		}
		return list2;
	}
	//문제 3. 급여가 가장 높은 사원 조회
	public EmpVO getMaxSal() {
		List<EmpVO> list = mainMapper.getEmpList();
		int max = 0;
		for(int i=0;i<list.size();++i) {
			if(max < list.get(i).getSal()) {
				max = list.get(i).getSal();
			}
			if(max == list.get(i).getSal()) {
				return list.get(i);
			}
		}
		return null;
	}
	//문제 4. 입사날짜 빠른 사원 조회 (쿼리 2개필요 OR 쿼리하나로 해결 가능)
	public EmpVO getFastHideDate() {
		return mainMapper.getEmp();
	}
}





