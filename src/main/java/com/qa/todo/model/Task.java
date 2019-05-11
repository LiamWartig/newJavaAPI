package com.qa.todo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Task {

	@Id
	private Long tId;
	private String statement;
	private Long uId;
	
	public Task () {
		
	}
	
	public Task(Long tId, String statement, Long uId) {
		this.tId = tId;
		this.statement = statement;
		this.uId=uId;
	}

	public Long gettId() {
		return tId;
	}

	public void settId(Long tId) {
		this.tId = tId;
	}

	public String getStatement() {
		return statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}
	
	public Long getuId() {
		return uId;
	}

	public void setuId(Long uId) {
		this.uId = uId;
	}

	
}
