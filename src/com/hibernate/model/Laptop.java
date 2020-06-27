package com.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="laptop_table")
public class Laptop {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long lapId;
	private String name;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sId")
	private Student student;
	
	public Laptop(String name) {
		super();
		this.name = name;
	}

	public Laptop() {
		super();
	}

	public long getLapId() {
		return lapId;
	}

	public void setLapId(long lapId) {
		this.lapId = lapId;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public long getlapId() {
		return lapId;
	}

	public void setlapId(long lapId) {
		this.lapId = lapId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Laptop [lapId=" + lapId + ", name=" + name + "]";
	}
	
	
}
