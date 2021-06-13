package com.example.apzumi2.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;



import javax.persistence.Id;

@Entity
public class PostContentModel   {

	

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable=false, nullable=false, unique=true)
    private int id;
    private int userId;

    private String title;
    private String body;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
    
    

    
}
