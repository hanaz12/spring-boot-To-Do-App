package com.global.hr.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // تحديد Auto-Increment
	private int id;

	@Column(nullable = false, unique = true)
	private String title;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TaskStatus status = TaskStatus.not;
	

	public Task() {
		super();
	}

	public Task(String title) {
		this.title = title;
	}

	public Task(String title, TaskStatus status) {
		super();
		this.title = title;
		this.status = status;
	}

	public Task(int id, String title, TaskStatus status) {
		super();
		this.id = id;
		this.title = title;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public TaskStatus getStatus() {
		return status;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}

}
