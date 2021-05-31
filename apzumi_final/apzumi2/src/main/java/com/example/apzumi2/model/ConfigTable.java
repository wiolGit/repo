package com.example.apzumi2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Value;

@Entity
public class ConfigTable {
	
	    @Id

	    @GeneratedValue (strategy = GenerationType.IDENTITY)
	    private int id;
	   // @Value("0")
	    private int last_c;
	    
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getLast_c() {
			return last_c;
		}
		public void setLast_c(int last_c) {
			this.last_c = last_c;
		}



}
