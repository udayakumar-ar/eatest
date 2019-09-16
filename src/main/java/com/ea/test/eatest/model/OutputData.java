package com.ea.test.eatest.model;

import java.util.List;

public class OutputData {

	private String managementName;
	private List<BandAndFestival> bandAndFestivalList;
	public String getManagementName() {
		return managementName;
	}
	public void setManagementName(String managementName) {
		this.managementName = managementName;
	}
	public List<BandAndFestival> getBandAndFestivalList() {
		return bandAndFestivalList;
	}
	public void setBandAndFestivalList(List<BandAndFestival> bandAndFestivalList) {
		this.bandAndFestivalList = bandAndFestivalList;
	}
	@Override
	public String toString() {
		return "OutputData [managementName=" + managementName + ", bandAndFestivalList=" + bandAndFestivalList + "]";
	}
}
