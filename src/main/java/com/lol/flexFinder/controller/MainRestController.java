package com.lol.flexFinder.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.lol.flexFinder.entity.PlayerSearch;
import com.lol.flexFinder.entity.SearchRole;
import com.lol.flexFinder.repository.IPlayerSearchRepository;

@RestController
public class MainRestController {

	@Autowired
	private IPlayerSearchRepository searchRepository;
	
	@GetMapping("/greeting")
	public ModelAndView greeting(@RequestParam(name="name", required=false, defaultValue="World") String name) {
		ModelAndView mav = new ModelAndView("greeting");
        mav.addObject("name", name);
        return mav;
	}
	
	@GetMapping("/")
	public ModelAndView home(){
		ModelAndView mav = new ModelAndView("home");
		mav.addObject("playerSearches", searchRepository.findAll());
		mav.addObject("rolesSelect", SearchRole.getValuesForUI());
		return mav;
	}
	
	@PostMapping("/create-player-search")
	public void createPlayerSearch(@RequestBody PlayerSearch playerSearch) {
		playerSearch.setCreatedDate(new Date());
		searchRepository.save(playerSearch);
	}
	
	@GetMapping("/get-player-search")
	public List<PlayerSearch> getAllPlayerSearches(){
		return searchRepository.findAll();
	}
}
