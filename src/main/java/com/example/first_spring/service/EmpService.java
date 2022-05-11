package com.example.first_spring.service;

import java.sql.Date;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
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
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyy-mm-dd" , Locale.KOREA);
		String empDate = "1987-00-00";
		String empdate = "1987-12-31";
		String empDate1 = "1981-00-00";
		String empdate1 = "1981-12-31";
		Date d1 = null;
		Date d2 = null;
		Date d3 = null;
		Date d4 = null;
		try {
			d1 = (Date) formatter.parse(empDate);
			d2 = (Date) formatter.parse(empdate);
			d3 = (Date) formatter.parse(empDate1);
			d4 = (Date) formatter.parse(empdate1);
		} catch (Exception e) {
			// TODO: handle exception
		}
		long d1time = d1.getTime() / (1000*60*60*24);
		long d2time = d2.getTime() / (1000*60*60*24);
		long d3time = d3.getTime() / (1000*60*60*24);
		long d4time = d4.getTime() / (1000*60*60*24);
		int count = 0;
		for(int i=0;i<list.size();++i) {
			Date fast = list.get(i).getHiredate();
			long userDateTime = fast.getTime()/(1000*60*60*24);
			if(d1time <= userDateTime && d2time >= userDateTime) {
				++count;
			}
			if(count <= 3) {
				if(d3time <= userDateTime && d4time >= userDateTime) {
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
		List<EmpVO> list = mainMapper.getEmpList();

		for(int i=0;i<list.size();++i) {
			Date fast = list.get(i).getHiredate();
			long userDateTime = fast.getTime()/(1000*60*60*24);
			long max = 0;
				for(int j=0;j<list.size();++i) {
					if(max < userDateTime) {
						max = userDateTime;
					}
				}
				if(max > userDateTime) {
					max = userDateTime;
				}
				if(userDateTime == list.get(i).getHiredate().getTime()/(1000*60*60*24)) {
					return list.get(i);
				}
		}
		
		return null;
	}

}





