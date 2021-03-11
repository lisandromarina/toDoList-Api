package com.toDoList.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.toDoList.model.Folder;

@Repository
public interface FolderDAO extends JpaRepository<Folder, Integer>{
	
	@Modifying
	@Transactional
	@Query("DELETE from Folder f WHERE f.id = :idFolder")
	void deleteById(Long idFolder);

	@Query ("SELECT f FROM Folder f")
	public List<Folder> findAllFolders();
	
	@Query ("SELECT f FROM Folder f WHERE id = :id")
	public Folder findOneFolder(Long id);
	
	@Modifying
	@Transactional
	@Query ("UPDATE Folder SET name= :newName WHERE id = :idFolder ")
	void updateOneFolder(Long idFolder, String newName);
}
