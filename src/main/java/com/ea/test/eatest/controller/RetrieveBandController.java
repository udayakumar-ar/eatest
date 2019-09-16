package com.ea.test.eatest.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ea.test.eatest.model.BandAndFestival;
import com.ea.test.eatest.service.BandService;

@Controller
public class RetrieveBandController {

	@Autowired private BandService bandService;
	
	@RequestMapping("/listMusicFestival")
	public ModelAndView getMusicFestivalDetail() {
		Map<String,List<BandAndFestival>> bandAndFestivalMap =  bandService.getFestivalDetail();
		
		ModelAndView mv = new ModelAndView();
		if(bandAndFestivalMap != null) {
			mv.addObject("bandAndFestivalMap",bandAndFestivalMap);
	        mv.setViewName("bandByManagement");
		}else {
			mv.setViewName("errorPage");
		}		
        return mv;
	}
}
