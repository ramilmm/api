package com.example.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Todo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String title;
	@Column
	private Boolean isFinished;
	@Column
	private Date createdAt;

	public Todo() {}

	public Todo(String title, Boolean isFinished, Date createdAt) {
		this.title = title;
		this.isFinished = isFinished;
		this.createdAt = createdAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Boolean getFinished() {
		return isFinished;
	}

	public void setFinished(Boolean finished) {
		isFinished = finished;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Todo{" +
				"id='" + id + '\'' +
				", title='" + title + '\'' +
				", isFinished=" + isFinished +
				", createdAt=" + createdAt +
				'}';
	}
	
}
