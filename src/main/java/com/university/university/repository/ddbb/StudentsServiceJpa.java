package com.university.university.repository.ddbb;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.university.university.model.Student;
import com.university.university.model.Subject;
import com.university.university.repository.StudentsRepository;
import com.university.university.repository.SubjectsRepository;
import com.university.university.service.IStudentService;


@Service
@Primary
public class StudentsServiceJpa implements IStudentService {

	@Autowired
	private StudentsRepository repoStudent;
	
	@Autowired
	private SubjectsRepository repoSubject;
	
	@Override
	public List<Student> findAll() {
		
		return repoStudent.findAll() ;
	}

	@Override
	public Student findById(Integer id) {
		
		Optional <Student> student = repoStudent.findById(id);
		if(student.isPresent()) {
			return student.get();
		}
		return null;
	}

	@Override
	public void saveSubject(int idStudent,int idSubject) {

		repoStudent.saveSubject(idStudent, idSubject);
	}

	@Override
	public void deleteSubject(int idSubject) {
		repoStudent.deleteSubject(idSubject);
	}
	

}