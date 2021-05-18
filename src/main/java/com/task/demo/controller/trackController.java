package com.task.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.task.demo.InfoBean.utmInfo;


//Tracking of the UTM parameters 
@RestController

public class trackController {

	@RequestMapping("/track")
	public ModelAndView trackUrl(utmInfo info,HttpSession session) {
		System.out.println("inside tracking");
		System.out.println(info);
		
		//You can save or manipulate here with the data 
		session.setAttribute("UTM", info);
		
		return new ModelAndView("redirect:/success");
	}
	@RequestMapping("/success")
	public String Show(HttpSession session) {
		
		utmInfo obj=(utmInfo)session.getAttribute("UTM");
		return obj.toString();
	}
}
