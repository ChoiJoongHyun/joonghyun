package net.slipp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Question {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(length=20, nullable=false)
	private String writer;
	
	@Column(nullable=false)
	private String title;
	
	private String contents;

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	@Override
	public String toString() {
		return "Question [writer=" + writer + ", title=" + title + ", contents=" + contents + "]";
	}	
}
