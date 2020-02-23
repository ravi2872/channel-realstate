package com.channel.realestate.dto;

public class RadioShowDto {
	private String category;
	private byte[] file;

	public RadioShowDto(String category, byte[] file) {
		this.category = category;
		this.file = file;
	}
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

}
