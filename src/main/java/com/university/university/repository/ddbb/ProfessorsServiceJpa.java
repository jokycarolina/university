package com.university.university.repository.ddbb;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.university.university.model.Professor;
import com.university.university.repository.ProfessorsRepository;
import com.university.university.service.IProfessorService;



@Service
@Primary
public class ProfessorsServiceJpa implements IProfessorService {
	
	@Autowired
	private ProfessorsRepository repoProf;

	@Override
	public List<Professor> findAll() {
		return repoProf.findAll();
	}

	@Override
	public Professor findById(Integer idProfessor) {
		
		Optional <Professor> prof = repoProf.findById(idProfessor);
		 if(prof.isPresent()) {
			 return prof.get();
		 }
		return null;
	}

	@Override
	public void saveProfessor(Professor prof) {
		repoProf.save(prof);
	}

	@Override
	public void deleteProfessor(Integer idProf) {
		repoProf.deleteById(idProf);
	}

}
