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

import com.toDoList.dao.FolderDAO;
import com.toDoList.dao.TaskDAO;
import com.toDoList.model.Folder;

//si quiero consumir un servicio desde js debo poner cross origin
@CrossOrigin(origins = "*", allowedHeaders="*")
@RestController
@RequestMapping("/folder")
public class FolderRest {
	
	@Autowired
	private FolderDAO folderDAO;
	
	@Autowired
	private TaskDAO taskDAO;
		
	@PostMapping("/save")
	
	public void saveFolder(@RequestBody Folder folder) {
		
		folderDAO.save(folder);
	}
	
	@PutMapping("/edit/{id}")
	public void updateFolder(@RequestBody Folder folder, @PathVariable("id") Long id) {
		folderDAO.updateOneFolder(id, folder.getName());
	}
	
	@GetMapping("/getAllFolders")
	public List<Folder> getFolders(){
		return folderDAO.findAllFolders();
	}
	
	@DeleteMapping("/deleteFolder/{id}")
	public void deleteFolder(@PathVariable("id") Long id) {
		taskDAO.deleteTaskByFolder(id);
		folderDAO.deleteById(id);
	}
}
