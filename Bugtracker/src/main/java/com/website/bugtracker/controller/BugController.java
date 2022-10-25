package com.website.bugtracker.controller;

import java.util.stream.Collectors;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.website.bugtracker.model.Bug;
import com.website.bugtracker.model.Developer;
import com.website.bugtracker.model.Priority;
import com.website.bugtracker.service.BugService;
import com.website.bugtracker.service.DeveloperService;

@Controller
@RequestMapping("/bugs")
public class BugController {
	
	@Autowired
	private final BugService bugservice;
	private final DeveloperService developerService;
	private final String path = "/bugpages/";
	
	private static int counter = 2;
	
	public BugController(BugService bugservice, DeveloperService developerservice) {
		
		this.bugservice = bugservice;
		this.developerService = developerservice;
	}
	
	@GetMapping
	public String bugoverview(Model model, @RequestParam(required = false, defaultValue = "1") int page) {
		
		int showEntries = 5;
		model.addAttribute("title", "Bug overviews");
		model.addAttribute("bugList", bugservice.getAllBugs().stream().skip(showEntries*(page-1)).limit(showEntries).collect(Collectors.toList()));
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", (int) Math.abs(bugservice.getAllBugs().stream().count() / 5)+1);
		return path + "bugindex";
	}
	
	@GetMapping("/details/{id}")
	public String BugDetails(Model model, @PathVariable int id) {
		
		Bug bug = bugservice.getAllBugs().get(id);
		Developer dev = developerService.getAllDevelopers().get(bug.getDeveloperId());
		model.addAttribute("bug", bug);
		model.addAttribute("developer", dev);
		return path + "bugdetails";
		
	}
	
	@GetMapping("/add")
	public String addBug(Model model) {
		
		model.addAttribute("title", "Add a bug");
		model.addAttribute("priorities", Priority.values());
		model.addAttribute("developerlist", developerService.getAllDevelopers());
		return path + "bugform";
	}
	
	@PostMapping("/add")
	public String addBug(@ModelAttribute Bug bug) {
		
		bug.setId(counter++);
		bugservice.addBug(bug);
		System.out.println(bug);
		return "success";
	}
}