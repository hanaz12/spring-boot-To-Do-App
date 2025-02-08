package com.global.hr.service;

import java.util.List;

import org.springframework.ui.Model;

import com.global.hr.model.Task;
import com.global.hr.model.TaskStatus;
public interface taskService {
	
	    List<Task> getAllTasks();
	    void  createTask(Task task);
	    Task updateTaskStatus(int id);
	    void deleteTask(int id);
	   
	

}
