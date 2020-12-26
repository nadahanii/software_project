package net.codeJava;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class template {
	/*public enum languageEnum {
		Arabic, English;

	}*/

	private Integer id;
	private String subject;
	private String content;
	private String language;
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	//private languageEnum language;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	/*public languageEnum getLanguage() {
		return language;
	}*/

	/*public void setLanguage(languageEnum language) {
		this.language = language;
	}*/

	public template(Integer id, String subject, String content,String language)//, languageEnum language) 
	{
		super();
		this.id = id;
		this.subject = subject;
		this.content = content;
		this.language=language;
		//this.language = language;
	}

	public template() {

		// TODO Auto-generated constructor stub
	}

}
