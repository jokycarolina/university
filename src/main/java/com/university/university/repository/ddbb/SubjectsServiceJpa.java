package com.university.university.repository.ddbb;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.university.university.model.Subject;
import com.university.university.repository.SubjectsRepository;
import com.university.university.service.ISubjectService;



@Service
@Primary
public class SubjectsServiceJpa implements ISubjectService {

	@Autowired
	private SubjectsRepository repoSubject;
	
	@Override
	public Subject findById(Integer idSubject) {
		
     Optional <Subject> subject = repoSubject.findById(idSubject);
     if(subject.isPresent()) {
    	 return subject.get();
     }
		return null;
	}

	@Override
	public List<Subject> findAll() {
		
		return repoSubject.findAll();
	}

	@Override
	public void save(Subject subject) {
		repoSubject.save(subject);
	}

	@Override
	public void delete(Integer idsubject) {
		repoSubject.deleteById(idsubject);
	}

}
