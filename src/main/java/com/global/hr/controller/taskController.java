package com.global.hr.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.global.hr.model.Task;
import com.global.hr.service.taskService;

@Controller
@RequestMapping("task")
public class taskController {
	
	private taskService taskservice;
	
	
	public taskController(taskService taskservice) {
		super();
		this.taskservice = taskservice;
	}


	@GetMapping("/list")
	public String showAll(Model model) {
		List <Task> tasks=taskservice.getAllTasks();
		for (Task task : tasks) {
	        System.out.println("Task ID: " + task.getId() + ", Status: " + task.getStatus());
	    }
       Task task=new Task();
		model.addAttribute("task", task);
		model.addAttribute("tasks", tasks);
		return "tasks";
	}
	
	@GetMapping("/toggle/{id}")
	public String toggle(@PathVariable("id") int id) { 
		 System.out.println("Toggling task ID: " + id);
		taskservice.updateTaskStatus(id);
		return "redirect:/task/list";
	}
	
	@PostMapping("/save")
	public String add(@ModelAttribute ("task") Task task) {
		taskservice.createTask(task);
		return "redirect:/task/list";
		
	}
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id) {

		taskservice.deleteTask(id);
		return "redirect:/task/list";
	}

}
