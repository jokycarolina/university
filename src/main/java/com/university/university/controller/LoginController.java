package com.university.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.university.university.model.Admin;
import com.university.university.model.Student;
import com.university.university.model.User;
import com.university.university.service.IProfessorService;
import com.university.university.service.IScheduleService;
import com.university.university.service.IStudentService;
import com.university.university.service.ISubjectService;

@Controller
public class LoginController {
	@Autowired
	private ISubjectService serviceSubject;
	
	@Autowired
	private IStudentService serviceStudent; 
	
	@Autowired
	private IScheduleService serviceSchedule;
	
	
	@Autowired
	private IProfessorService serviceProf; 
	
	
	@GetMapping("/login")
	public String showLogin(User user,Student student){

		return "login";
	}
	
	@RequestMapping(value = "/login/{id}", method = RequestMethod.POST)
	public String profile(@PathVariable("id") int idStudent) {
		if (idStudent == 1) {
			return "/student/profile/{id}";
		} 
		return "redirect:/student/";		
	}


}
