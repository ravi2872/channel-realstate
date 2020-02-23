package com.channel.realestate.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tags")
public class Tag {
	@Id
	@GeneratedValue
	private Integer pkey;

	@Column(name = "type")
	private String type;
	@Column(name = "tag")
	private String tag;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

}
