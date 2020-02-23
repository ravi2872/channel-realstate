package com.channel.realestate.dto;

import java.sql.Timestamp;
import java.time.LocalDate;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

public class Common {
	
	@JsonDeserialize(using = LocalDateDeserializer.class)  
	@JsonSerialize(using = LocalDateSerializer.class)  
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@Column(name = "creation_time")
	private LocalDate creationTime;
	
	@Column(name = "createdby")
	private String createdBy;
	
	@JsonDeserialize(using = LocalDateDeserializer.class)  
	@JsonSerialize(using = LocalDateSerializer.class)  
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@Column(name = "updation_time")
	private LocalDate updationTime;
	
	@Column(name = "updatedby")
	private String updatedBy;

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDate getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(LocalDate creationTime) {
		this.creationTime = creationTime;
	}

	public LocalDate getUpdationTime() {
		return updationTime;
	}

	public void setUpdationTime(LocalDate updationTime) {
		this.updationTime = updationTime;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
}
