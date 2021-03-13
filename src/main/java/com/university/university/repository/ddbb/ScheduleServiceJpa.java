package com.university.university.repository.ddbb;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.university.university.model.Schedule;
import com.university.university.repository.SchedulesRepository;
import com.university.university.service.IScheduleService;



@Service
@Primary
public class ScheduleServiceJpa implements IScheduleService {
	
	@Autowired
	private SchedulesRepository repoSchedule;

	@Override
	public List<Schedule> searchAll() {
		
		return repoSchedule.findAll();
	}

	@Override
	public Schedule searchById(Integer idSchedule) {
		
		Optional <Schedule> schedule = repoSchedule.findById(idSchedule);
		
		if(schedule.isPresent()) {
			return schedule.get();
		}
		return null;
	}

}
