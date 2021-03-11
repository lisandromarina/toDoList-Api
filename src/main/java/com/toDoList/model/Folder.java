package com.toDoList.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name="folder")
@Entity
public class Folder {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long id;
		
		@Column(name="folder_name")
		private String name;
		
		@OneToMany(mappedBy="folder")
		private List<Task> tasks;
		
		
		public Folder(String name) {
			this.name = name;
			this.tasks = new ArrayList<Task>();
		}
		
		public Folder() {
			
		}


		//getters and setters
		public List<Task> getTasks() {
			return tasks;
		}
		
		public void setId(long id) {
			this.id = id;
		}

		public void setTasks(List<Task> tasks) {
			this.tasks = tasks;
		}
		
		public long getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		
}
