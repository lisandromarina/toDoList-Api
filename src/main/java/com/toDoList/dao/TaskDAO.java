package com.toDoList.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.toDoList.model.Task;

@Repository
public interface TaskDAO extends JpaRepository<Task, Long>{
	
	@Transactional
	@Modifying
	@Query ("DELETE FROM Task t WHERE t.folder.id = :idFolder ")
	void deleteTaskByFolder(Long idFolder);
	
	@Transactional
	@Modifying
	@Query ("DELETE FROM Task t WHERE t.id = :idTask ")
	void deleteOneTask(Long idTask);
	
	@Query ("SELECT t FROM Task t WHERE t.folder.id = :idFolder ")
	public List<Task> findByFolderId(Long idFolder);
	
	@Modifying
	@Transactional
	@Query ("UPDATE Task SET name = :newName WHERE id = :idTask ")
	void updateOneTask(Long idTask, String newName);

//	@Modifying
//	@Transactional
//	@Query ("UPDATE Task t SET check = value WHERE t.id = :idTask ")
//	void updateCheckTask(Long idTask, Integer value);
	
}
