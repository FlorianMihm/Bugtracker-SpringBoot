package com.website.bugtracker.controller;

import java.util.List;
import java.util.stream.Collector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.website.bugtracker.model.Developer;
import com.website.bugtracker.service.BugService;
import com.website.bugtracker.service.DeveloperService;

@Controller
@RequestMapping("/developer")
public class DeveloperController {

	@Autowired
	private final DeveloperService developerservice;
	private final BugService bugservice;
	private final String path = "/developerpages/";
	
	public DeveloperController(DeveloperService developerservice, BugService bugservice) {
		
		this.developerservice = developerservice;
		this.bugservice = bugservice;
	}
	
	@GetMapping
	public String developeroverview(Model model) {
		
		model.addAttribute("title", "Developer overview");
		model.addAttribute("developerList", getAllDevelopers());
		return path + "devindex";
	}
	
	@GetMapping("/details/{devid}")
	public String DeveloperDetails(Model model, @PathVariable int devid) {
		
		Developer dev = getAllDevelopers().get(devid);
		int totalBugs = (int) bugservice.getAllBugs().stream().filter(d -> d.getDeveloperId() == devid).count();
		model.addAttribute("title", "Developer Details");
		model.addAttribute("developer", dev);
		model.addAttribute("totalbugs", totalBugs);
		return path + "devdetails";
	}
	
	public List<Developer> getAllDevelopers() {
		
		return developerservice.getAllDevelopers();
	}
}