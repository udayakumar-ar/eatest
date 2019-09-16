package com.ea.test.eatest.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.ea.test.eatest.model.Band;
import com.ea.test.eatest.model.BandAndFestival;
import com.ea.test.eatest.model.MusicFestival;

@Service
public class BandService {
	RestTemplate restTemplate = new RestTemplate();
	
	public Map<String,List<BandAndFestival>> getFestivalDetail() {
		try {
			ResponseEntity<List<MusicFestival>> musicFestivalEntity = restTemplate.exchange(
					"http://eacodingtest.digital.energyaustralia.com.au/api/v1/festivals",
					HttpMethod.GET,
					null,
					new ParameterizedTypeReference<List<MusicFestival>>(){});
			
			
			Map<String,List<BandAndFestival>> bandAndFestivalMap = new TreeMap<>();
			List<BandAndFestival> bandAndFestivalList = null;
			BandAndFestival bandAndFestivalObj = null;
			List<String> festivalNameList = null;
			
			
			for(MusicFestival musicFestival : musicFestivalEntity.getBody()) {
				for(Band band : musicFestival.getBands()) {
					
					if(band.getRecordLabel()!=null && !band.getRecordLabel().isEmpty()) {
						if(bandAndFestivalMap.get(band.getRecordLabel()) == null) {
							bandAndFestivalList = new ArrayList<>();
							bandAndFestivalObj = new BandAndFestival();
							bandAndFestivalObj.setBandName(band.getName());
							if(musicFestival.getName()!=null) {
								festivalNameList = new ArrayList<>();
								festivalNameList.add(musicFestival.getName());
								bandAndFestivalObj.setFestivalNameList(festivalNameList);
							}
							bandAndFestivalList.add(bandAndFestivalObj);
							bandAndFestivalMap.put(band.getRecordLabel(),bandAndFestivalList);
						}else {
							bandAndFestivalList = bandAndFestivalMap.get(band.getRecordLabel());
							bandAndFestivalObj = new BandAndFestival();
							bandAndFestivalObj.setBandName(band.getName());
							if(musicFestival.getName()!=null) {
								if(bandAndFestivalObj.getFestivalNameList() != null) {
									festivalNameList = bandAndFestivalObj.getFestivalNameList();
									festivalNameList.add(musicFestival.getName());
									Collections.sort(festivalNameList);
									bandAndFestivalObj.setFestivalNameList(festivalNameList);
								}else {
									festivalNameList = new ArrayList<>();
									festivalNameList.add(musicFestival.getName());
									bandAndFestivalObj.setFestivalNameList(festivalNameList);
								}							
							}
							bandAndFestivalList.add(bandAndFestivalObj);
							Collections.sort(bandAndFestivalList);
						}
					}
				}
				System.out.println("Retrieved music festival "+musicFestival);
			}
			return bandAndFestivalMap;
		}catch(RestClientException e) {
			e.printStackTrace();
		}
		return null;
	}
}
