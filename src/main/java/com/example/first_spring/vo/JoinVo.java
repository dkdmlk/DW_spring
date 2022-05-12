package com.example.first_spring.vo;

import lombok.Data;

@Data
public class JoinVo {
	private int empno;
	private String ename;
	private String job;
	private String hiredate;
	private int mgr;
	private int sal;
	private int comm;
	private int deptno;
	private String dname;
	private String loc;
}
