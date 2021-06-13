package com.example.projecta.model;

import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
public class Pracownik implements Serializable {

	  @Id
	    @GeneratedValue (strategy = GenerationType.IDENTITY)
	    private int id;
	    @Column(length=50)
	  //  @Size(min=3, max=50, message="Nazwa musi zawierac min 3 znaki , max 50 znakow") 
	    private String name;
	    
	    @OneToMany(mappedBy="pracownik", fetch=FetchType.LAZY)
	    @JsonIgnore
	    //@BatchSize()
	    private List<Zespol> zespoly;

	    @OneToOne(mappedBy="pracownik", cascade = CascadeType.PERSIST)
	    @PrimaryKeyJoinColumn
	    private AktywnyPracownik aktywnypracownik;

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

	public List<Zespol> getZespoly() {
		return zespoly;
	}

	public void setZespoly(List<Zespol> zespoly) {
		this.zespoly = zespoly;
	}

	public AktywnyPracownik getAktywnypracownik() {
		return aktywnypracownik;
	}

	public void setAktywnypracownik(AktywnyPracownik aktywnypracownik) {
		this.aktywnypracownik = aktywnypracownik;
	}

	public Pracownik(int id, String name, List<Zespol> zespoly, AktywnyPracownik aktywnypracownik) {
		super();
		this.id = id;
		this.name = name;
		this.zespoly = zespoly;
		this.aktywnypracownik = aktywnypracownik;
	}
    
    
  	public Pracownik( ) {}

    
	
}
