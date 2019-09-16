package com.ea.test.eatest.model;

import java.util.List;

public class MusicFestival {
	private String name;
	private List<Band> bands;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Band> getBands() {
		return bands;
	}
	public void setBands(List<Band> bands) {
		this.bands = bands;
	}
	@Override
	public String toString() {
		return "MusicFestival [name=" + name + ", bands=" + bands + "]";
	}		
}
