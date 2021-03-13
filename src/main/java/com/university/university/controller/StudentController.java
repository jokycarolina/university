package com.university.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.university.university.model.Student;
import com.university.university.model.Subject;
import com.university.university.service.IProfessorService;
import com.university.university.service.IScheduleService;
import com.university.university.service.IStudentService;
import com.university.university.service.ISubjectService;

@Controller
@RequestMapping(value = "/student")
public class StudentController {

	@Autowired
	private ISubjectService serviceSubject;

	@Autowired
	private IStudentService serviceStudent;

	@Autowired
	private IScheduleService serviceSchedule;

	@Autowired
	private IProfessorService serviceProf;

	@ModelAttribute
	public void setGeneric(Model model) {
		model.addAttribute("subjects", serviceSubject.findAll());
		model.addAttribute("schedules", serviceSchedule.searchAll());
		model.addAttribute("professors", serviceProf.findAll());
	}

	@GetMapping("/{id}")
	public String showProfile(@PathVariable("id") int idStudent, Model model) {

		Student student = serviceStudent.findById(idStudent);
		System.out.println("envio " + student.getSubjectsOfStudent());

		model.addAttribute("student", student);
		model.addAttribute("subjectStudent", student.getSubjectsOfStudent());
		return "student/studentProfile";
	}

	@GetMapping("/inscription/{idStudent}/{id}")
	public String incriptionSubject(@PathVariable("id") int idSubject, Model model,
			@PathVariable("idStudent") int idStudent) {
		Student student = serviceStudent.findById(idStudent);
		Subject subject = serviceSubject.findById(idSubject);
		model.addAttribute("subject", subject);
		model.addAttribute("student", student);
		return "student/inscriptions";
	}

	@PostMapping("/saveSubject/{idStudent}/{id}")
	public String saveSubject(RedirectAttributes attributes, Model model, @PathVariable("id") int idSubject,
			@PathVariable("idStudent") int idStudent) {

		Student student = serviceStudent.findById(idStudent);

		serviceStudent.saveSubject(idStudent, idSubject);
		model.addAttribute("student", student);
		model.addAttribute("subjectStudent", student.getSubjectsOfStudent());
		attributes.addFlashAttribute("msg", "Inscripcion de materia exitosa");
		String id = student.getId().toString();
		return "redirect:/student/" + id;
	}

	@GetMapping("/deleteSubject/{idStudent}/{idSubject}")
	public String deleteSubject(@PathVariable("idSubject") int idSubject, @PathVariable("idStudent") int idStudent,
			RedirectAttributes attributes) {

		serviceStudent.deleteSubject(idSubject);
		attributes.addFlashAttribute("msg", "Se eliminó la materia con éxito");
		Student student = serviceStudent.findById(idStudent);
		String id = student.getId().toString();
		return "redirect:/student/" + id;
	}

}
