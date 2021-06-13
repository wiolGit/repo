package com.example.projecta.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Zespol {


	  @Id
	    @GeneratedValue (strategy = GenerationType.IDENTITY)
	    private int id;

      @Column(length=50)
	    private String name;
	    
      
      
       @ManyToOne
      @MapsId
      @JoinColumn(name="id", nullable=false)
      private Pracownik pracownik;

		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public Pracownik getPracownik() {
			return pracownik;
		}


		public void setPracownik(Pracownik pracownik) {
			this.pracownik = pracownik;
		}
        
   
        
}
