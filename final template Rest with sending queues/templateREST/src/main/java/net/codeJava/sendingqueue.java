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
	private String receiver;
	
	
	private String status;
	
	
	public sendingqueue() {
		super();
		// TODO Auto-generated constructor stub
	}
	public sendingqueue(String content, String method, Integer id, String receiver, String status) {
		super();
		this.content = content;
		this.method = method;
		this.id = id;
		this.receiver = receiver;
		this.status = status;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
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
	
	

}
