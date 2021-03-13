package com.university.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.university.university.model.Professor;
import com.university.university.model.Subject;
import com.university.university.service.IProfessorService;
import com.university.university.service.IScheduleService;
import com.university.university.service.IStudentService;
import com.university.university.service.ISubjectService;

@Controller
@RequestMapping(value = "/professor")
public class ProfessorController {

	
	@Autowired
	private ISubjectService detailSubject;
	
	@Autowired
	private IStudentService studentService;
	
	@Autowired
	private IScheduleService scheduleService;
	
	@Autowired
	private IProfessorService professorService;
	@ModelAttribute
	public void setGeneric(Model model) {
		model.addAttribute("subjects", detailSubject.findAll());
		model.addAttribute("students", studentService.findAll());
		model.addAttribute("schedules",scheduleService.searchAll());
		model.addAttribute("professors",professorService.findAll());
	}
	
	@GetMapping("/createProfessor")
	public String createProfessor(Professor professor,Model model) {
		return "professor/formProfessor";
	}
	
	
	@PostMapping("/save")
	public String save(Professor professor, BindingResult result, RedirectAttributes attributes) {

		if (result.hasErrors()) {

			for (ObjectError error : result.getAllErrors()) {
				System.out.println("Ocurrio un error:" + error.getDefaultMessage());
			}
			return "professor/formProfessor";
		}		
		System.out.println(professor);
		professorService.saveProfessor(professor);
		attributes.addFlashAttribute("msg", "Se guardó el profesor con éxito");
		return "redirect:/admin/";}
}
