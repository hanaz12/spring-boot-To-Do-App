package com.global.hr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.global.hr.model.Task;
import com.global.hr.model.TaskStatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface taskRepository extends JpaRepository <Task,Integer> {

    @Query("SELECT t FROM Task t ORDER BY FIELD(t.status, 'not', 'completed')")
    List<Task> findAllSorted();
}
