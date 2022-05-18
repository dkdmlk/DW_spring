package com.example.first_spring.vo;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class EmpVO extends DeptVO{
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date hiredate;
	private int sal;
	private int comm;

}
