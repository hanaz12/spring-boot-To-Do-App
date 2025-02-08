package com.global.hr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.global.hr.model.Task;
import com.global.hr.model.TaskStatus;
import com.global.hr.repository.taskRepository;

@Service
public class taskServiceImpl implements taskService {
	
	private taskRepository taskrepository;

	@Autowired
	public taskServiceImpl(taskRepository taskrepository) {
		super();
		this.taskrepository = taskrepository;
	}

	@Override
	public List<Task> getAllTasks() {

//		List <Task> tasks=taskrepository.findAll();
		List <Task> tasks=taskrepository.findAllSorted();
		return tasks;
	}

	@Override
	public void  createTask(Task task) {
		taskrepository.save(task);
	}

	@Override
    public Task updateTaskStatus(int id) {
        Optional <Task> result = taskrepository.findById(id);
        Task task=null;
        if (result.isPresent()) {
        	task=result.get();
        	if (task.getStatus()==TaskStatus.completed) {
        		System.out.println("ana completed");
        		task.setStatus(TaskStatus.not);
        	}
        	else {
        		System.out.println("ana m4 completed");
        		task.setStatus(TaskStatus.completed);
        	}
        	
        	taskrepository.save(task);
        }
        return task;
    }


	@Override
	public void deleteTask(int id) {
		taskrepository.deleteById(id);
		
	}

}
