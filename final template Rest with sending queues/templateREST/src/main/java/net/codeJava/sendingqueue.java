package net.codeJava;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class sendingqueue {
	private String content;
	private String method;
	private Integer id;
	public String getcontent() {
		return content;
	}
	public void setcontent(String content) {
		this.content = content;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public sendingqueue(String sentContent, String method, Integer id) {
		super();
		this.content = sentContent;
		this.method = method;
		this.id = id;
	}
	public sendingqueue() {
		
	}
	

}
