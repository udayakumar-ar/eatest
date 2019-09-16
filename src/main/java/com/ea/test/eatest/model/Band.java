package com.ea.test.eatest.model;

public class Band {

	private String name;
	private String recordLabel;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRecordLabel() {
		return recordLabel;
	}
	public void setRecordLabel(String recordLabel) {
		this.recordLabel = recordLabel;
	}
	@Override
	public String toString() {
		return "Band [name=" + name + ", recordLabel=" + recordLabel + "]";
	}
}
