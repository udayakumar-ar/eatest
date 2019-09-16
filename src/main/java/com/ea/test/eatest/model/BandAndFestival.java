package com.ea.test.eatest.model;

import java.util.List;

public class BandAndFestival implements Comparable<BandAndFestival>{

	private String bandName;
	private List<String> festivalNameList;
	public String getBandName() {
		return bandName;
	}
	public void setBandName(String bandName) {
		this.bandName = bandName;
	}
	public List<String> getFestivalNameList() {
		return festivalNameList;
	}
	public void setFestivalNameList(List<String> festivalNameList) {
		this.festivalNameList = festivalNameList;
	}
	@Override
	public String toString() {
		return "BandAndFestival [bandName=" + bandName + ", festivalNameList=" + festivalNameList + "]";
	}
	
	@Override
	public int compareTo(BandAndFestival bandAndFestival){
		return this.bandName.compareTo(bandAndFestival.bandName); 
	}  
}
