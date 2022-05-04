package com.example.first_spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.first_spring.vo.UserVO;

@Service
public class MainService {
	//문제 1. 나이가 60 이하인 배우만 리턴하시오.
    public List<UserVO> getUserList(){
		List<UserVO> list = new ArrayList<UserVO>();
		list.add(new UserVO("이병헌",51,"서울"));
        list.add(new UserVO("조승우",42,"서울"));
        list.add(new UserVO("이경영",61,"서울"));
        list.add(new UserVO("배성우",49,"서울"));
        list.add(new UserVO("백윤식",75,"서울"));
        List<UserVO> list2 = new ArrayList<UserVO>();
        for(UserVO i : list) {
        	if(i.getAge() <= 60) {
        		list2.add(new UserVO(i.getName(), i.getAge(), i.getAdd()));
        	}
        }
        return list2;
        /* 다른방법
         for(int i=0;i<list.size();++i){
         	if(i.getAge() > 60){
         		list.remove(i);
         		--i;
         	}
         }
         return list;
         */
	}
    //문제 2. 나이가 가장많은 배우의 나이를 리턴하시오.
    public int getUserAgeMax(){
		List<UserVO> list = new ArrayList<UserVO>();
		list.add(new UserVO("이병헌",51,"서울"));
        list.add(new UserVO("조승우",42,"서울"));
        list.add(new UserVO("이경영",61,"서울"));
        list.add(new UserVO("배성우",49,"서울"));
        list.add(new UserVO("백윤식",75,"서울"));
        int age = 0;
        for(UserVO i : list) {
        	if(i.getAge() > age) {
        		age = i.getAge();
        	}
        }
		return age;
	}
    //문제 3. list에 배우이름 배성우가 있다면 리턴하시오.
    public UserVO getUser(){
		List<UserVO> list = new ArrayList<UserVO>();
		list.add(new UserVO("이병헌",51,"서울"));
        list.add(new UserVO("조승우",42,"서울"));
        list.add(new UserVO("이경영",61,"서울"));
        list.add(new UserVO("배성우",49,"서울"));
        list.add(new UserVO("백윤식",75,"서울"));
        for(UserVO i : list) {
        	if(i.getName().equals("배성우")) {
        		return i;
        	}
        }
		return null;
	}
    //문제 4. list에 성이 이씨인 배우가 몇명인지 리턴하시오.
    public int getUserCount(){
		List<UserVO> list = new ArrayList<UserVO>();
		list.add(new UserVO("이병헌",51,"서울"));
        list.add(new UserVO("조승우",42,"서울"));
        list.add(new UserVO("이경영",61,"서울"));
        list.add(new UserVO("배성우",49,"서울"));
        list.add(new UserVO("백윤식",75,"서울"));
        int count = 0;
        for(UserVO i : list) {
        	String[] name = i.getName().split("");
        	for(int j=0; j<name.length;++j) {
        		if(j==0 &&name[j].equals("이")) {
        			++count;
        		}
        	}
        }
        return count;
        /*다른방법
         for(UserVO i: list){
         	String name = i.getName().subString(0,1);
         	if(name.equals("이")){
         		++count;
         	}
         } 
         */
	}
}

















