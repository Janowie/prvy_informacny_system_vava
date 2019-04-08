package entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Jednoducha entity POJO class-a oanotovana cez JPA anotacie pre ORM mapping 
 * @author Jaroslav Jakubik
 */
@Entity
public class Todo {

	@Id
	@GeneratedValue
	private Long id;
	private String text;
	private Date notificationDate;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public Date getNotificationDate() {
		return notificationDate;
	}
	
	public void setNotificationDate(Date notificationDate) {
		this.notificationDate = notificationDate;
	}
}
