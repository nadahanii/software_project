package net.codeJava;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class dequeueing  {
	
	Integer id;
	String content;
	String method;
	String status;
	String receiver;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public dequeueing(Integer id, String content, String method, String status, String receiver) {
		super();
		this.id = id;
		this.content = content;
		this.method = method;
		this.status = status;
		this.receiver = receiver;
	}
	public dequeueing() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
}
