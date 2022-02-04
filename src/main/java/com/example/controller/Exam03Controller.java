package com.example.controller;

import java.text.NumberFormat;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam03")
public class Exam03Controller {

	@Autowired
	private ServletContext application;
	
	@RequestMapping("")
	public String index() {
		return "exam03";
		
	}
	
	@RequestMapping("/result")
	public String result(Integer num1,Integer num2,Integer num3) {
		Integer outTax = num1 + num2 + num3;
		NumberFormat comFormat = NumberFormat.getNumberInstance();
		
		application.setAttribute("outTax", comFormat.format(outTax));
		
		Integer inTax = (int) ((num1 + num2 + num3)*1.1);
		application.setAttribute("inTax", comFormat.format(inTax));
		
		return "exam03-result";
	}
	
	}

