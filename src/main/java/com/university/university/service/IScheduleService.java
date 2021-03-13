package com.university.university.service;

import java.util.List;

import com.university.university.model.Schedule;



public interface IScheduleService {

List<Schedule> searchAll();

Schedule searchById(Integer idSchedule);

}
