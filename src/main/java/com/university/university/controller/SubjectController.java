package com.university.university.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.university.university.model.Professor;
import com.university.university.model.Schedule;
import com.university.university.model.Student;
import com.university.university.model.Subject;
import com.university.university.repository.ddbb.ProfessorsServiceJpa;
import com.university.university.service.IProfessorService;
import com.university.university.service.IScheduleService;
import com.university.university.service.IStudentService;
import com.university.university.service.ISubjectService;




@Controller
@RequestMapping(value = "/subject")
public class SubjectController {
	
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
	
	
	@GetMapping("/{id}")
	public String showDetailsSubject(@PathVariable("id") int idSubject,Model model) {
		
		
        Subject subject = detailSubject.findById(idSubject);
		
		model.addAttribute("subject",subject);
		return "detailsSubject";
	}
	
	@PostMapping("/save")
	public String save(Subject subject, BindingResult result, RedirectAttributes attributes) {

		if (result.hasErrors()) {

			for (ObjectError error : result.getAllErrors()) {
				System.out.println("Ocurrio un error:" + error.getDefaultMessage());
			}
			return "subject/formSubject";
		}		
		attributes.addFlashAttribute("msg", "Se guardó la materia con éxito");
		return "redirect:/admin/";
		}

	@GetMapping("/create")
	public String createSubject(Subject subject,Model model) {

	return "subject/formSubject";	
	}
	

}


