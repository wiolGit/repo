package com.example.projecta.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.BatchSize;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class AktywnyPracownik implements Serializable {

	

    @Id
 //   @GeneratedValue (strategy = GenerationType.IDENTITY)
   // @Column(name="pracownik_id")
    private int pracownik_id;
    @Column(length=50)
    private Double salary;
   
  //  @Temporal(value = TemporalType.DATE)
    @Transient
    private String name;
    
    @Basic
    private java.sql.Date dataZatrudnienia;

    
    
    @OneToOne
    @MapsId
    @JsonIgnore
    @JoinColumn(name="pracownik_id")
    private Pracownik pracownik;
	   
	  	public AktywnyPracownik( ) {}
	  	
		
		public Double getSalary() {
			return salary;
		}

		public void setSalary(Double salary) {
			this.salary = salary;
		}

		public Pracownik getPracownik() {
			return pracownik;
		}

		public void setPracownik(Pracownik pracownik) {
			this.pracownik = pracownik;
		}

		public java.util.Date getDataZatrudnienia() {
			return dataZatrudnienia;
		}

		public void setDataZatrudnienia(java.sql.Date dataZatrudnienia) {
			this.dataZatrudnienia = dataZatrudnienia;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public AktywnyPracownik(int pracownik_id, Double salary, String name, Date dataZatrudnienia, Pracownik pracownik) {
			super();
			this.pracownik_id = pracownik_id;
			this.salary = salary;
			this.name = name;
			this.dataZatrudnienia = dataZatrudnienia;
			this.pracownik = pracownik;
		}

		public AktywnyPracownik(int pracownik_id, Double salary, Date dataZatrudnienia) {
			super();
			this.pracownik_id = pracownik_id;
			this.salary = salary;
			this.dataZatrudnienia = dataZatrudnienia;
		}

		public AktywnyPracownik(int pracownik_id, Double salary, String name, Date dataZatrudnienia) {
			super();
			this.pracownik_id = pracownik_id;
			this.salary = salary;
			this.name = name;
			this.dataZatrudnienia = dataZatrudnienia;
		}


		public int getPracownik_id() {
			return pracownik_id;
		}


		public void setPracownik_id(int pracownik_id) {
			this.pracownik_id = pracownik_id;
		}

	
	
	    
	    
	    
}
