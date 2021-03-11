package com.toDoList.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toDoList.dao.TaskDAO;
import com.toDoList.model.Task;

@CrossOrigin(origins = "*", allowedHeaders="*")
@RestController
@RequestMapping("/task")
public class TaskRest {
	
	@Autowired
	private TaskDAO taskDAO;
		
	@PostMapping("/saveTask/")
	public void saveTask(@RequestBody Task task) {
		taskDAO.save(task);
	}
	
	@PutMapping("/edit/{id}")
	public void updateTask(@RequestBody Task task, @PathVariable("id") Long id) {
		taskDAO.updateOneTask(id, task.getName());
	}
	
//	@PutMapping("/updateCheckTask/{id}/{value}")
//	public void updateChackTask(@PathVariable("id") Long id, @PathVariable("value") Integer value) {
//		taskDAO.updateCheckTask(id, value);
//	}
	
	@GetMapping("/getTaskByFolder/{id}")
	public List<Task> getTaskByFolder(@PathVariable("id") Long id){
		return taskDAO.findByFolderId(id);
	}
	
	@DeleteMapping("/deleteTask/{id}")
	public void deleteTaskByFolder(@PathVariable("id") Long id) {
		taskDAO.deleteTaskByFolder(id);
	}
	
	@DeleteMapping("/deleteOneTask/{id}")
	public void deleteOneTask(@PathVariable("id") Long id) {
		taskDAO.deleteOneTask(id);
	}
}
