package com.hl.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.hl.pojo.Student;

@Controller
public class StudentController {
	static List<Student> list=new ArrayList<Student>();
	static{
		Student s1=new Student(1,"ÕÅÈı","ÄĞ","ºÈ¾Æ,³éÑÌ");
		Student s2=new Student(2,"ÕÅËÄ","Å®","ºÈ¾Æ,³éÑÌ");
		Student s3=new Student(3,"ÕÅÎâ","Å®","ºÈ¾Æ,³éÑÌ");
		Student s4=new Student(4,"ÕÅÁ÷","ÄĞ","ºÈ¾Æ,³éÑÌ");
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);
		System.out.println("=========");
	}
	@RequestMapping("/list")
	public String list(Model m){
		m.addAttribute("list",list);
		return "stu_list";
	}
	@RequestMapping("/add")
	@ResponseBody
	public String add(Student stu){
		Student s=new Student(stu.getSid(),stu.getSname(),stu.getSex(),stu.getHobby());
		list.add(s);
		return "ok";
	}
	//É¾³ı
	@RequestMapping("/remove")
	public String remove(int sid){
		Iterator<Student> it = list.iterator();
		while(it.hasNext()){
			if(it.next().getSid()==sid){
				it.remove();
			}
		}
		return "redirect:list";
	}
	@RequestMapping(value="/sel",produces="application/json;charset=utf-8")
	@ResponseBody
	public String sel(int sid){
		Student student = list.get(sid-1);
		String string = JSON.toJSONString(student);
		return string;
	}
	@RequestMapping("/update")
	public String update(Student stu){
		Iterator<Student> it = list.iterator();
		while(it.hasNext()){
			if(it.next().getSid()==stu.getSid()){
				it.remove();
			}
	}
		Student s1=new Student(stu.getSid(),stu.getSname(),stu.getSex(),stu.getHobby());
		list.add(s1);
		return "redirect:list";
}
}
