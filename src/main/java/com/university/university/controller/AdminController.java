package com.university.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.university.university.model.Professor;
import com.university.university.model.Schedule;
import com.university.university.model.Subject;
import com.university.university.service.IProfessorService;
import com.university.university.service.IScheduleService;
import com.university.university.service.IStudentService;
import com.university.university.service.ISubjectService;
import com.university.university.service.IUserService;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

	@Autowired
	private IStudentService serviceStudent;

	@Autowired
	private IScheduleService serviceSchedule;

	@Autowired
	private IProfessorService serviceProf;
	
	@Autowired
	private ISubjectService serviceSubject;

	@ModelAttribute
	public void setGeneric(Model model) {
		model.addAttribute("students", serviceStudent.findAll());
		model.addAttribute("schedules", serviceSchedule.searchAll());
		model.addAttribute("professors", serviceProf.findAll());
		model.addAttribute("subjects", serviceSubject.findAll());
	}

	@GetMapping("/")
	public String showIndex() {
		System.out.println("entro");
		return "admin/indexAdmin";
	}

	@GetMapping("/update/{id}")
	public String updateSubject(@PathVariable("id") int idSubject, Model model, Schedule schedule) {

		Subject subject =serviceSubject.findById(idSubject);
		model.addAttribute("subject", subject);
		model.addAttribute("schedule", schedule);
		

		return "subject/formSubject";
	}

	@GetMapping("/delete/{id}")
	public String deleteSubject(@PathVariable("id") int idSubject, Model model, RedirectAttributes attributes) {

		serviceSubject.delete(idSubject);
		attributes.addFlashAttribute("msg", "La materia fue eliminada con éxito");

		return "redirect:/admin/";
	}

	@GetMapping("/deleteProfessor/{id}")
	public String deleteProfessor(@PathVariable("id") int idProfessor, Model model, RedirectAttributes attributes) {

		serviceProf.deleteProfessor(idProfessor);

		attributes.addFlashAttribute("msg", "El profesor fue eliminado/a con éxito");

		return "redirect:/admin/";
	}

	@GetMapping("/updateProfessor/{id}")
	public String professorUpdate(@PathVariable("id") int idProfessor, Model model, Professor professor) {

		Professor prof = serviceProf.findById(idProfessor);
		model.addAttribute("professor", prof);

		return "professor/formProfessor";
	}

}