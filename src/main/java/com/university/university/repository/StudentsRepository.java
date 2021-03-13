package com.university.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.university.university.model.Student;
import com.university.university.model.Subject;



public interface StudentsRepository extends JpaRepository<Student, Integer> {
	
	@Transactional
	@Modifying
	@Query(value="INSERT INTO subject_student (subjectsOfStudent_id,student_id)"
			+ "VALUES (:subjectsOfStudent_id,:student_id)",
			nativeQuery = true )
	void saveSubject (@Param("student_id") int idStudent,@Param("subjectsOfStudent_id") int idSubject);

	@Transactional
	@Modifying
	@Query(value="DELETE FROM subject_student WHERE subjectsOfStudent_id =?",
			nativeQuery = true )
	void deleteSubject (@Param("subjectsOfStudent_id") int idSubject);


}
