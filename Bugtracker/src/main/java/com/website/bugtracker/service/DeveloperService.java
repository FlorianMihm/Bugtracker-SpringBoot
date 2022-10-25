package com.website.bugtracker.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.website.bugtracker.model.Developer;

@Service
public class DeveloperService {
	
	private List<Developer> developerlist = new ArrayList<>();
	
	public DeveloperService() {
		
		developerlist.add(new Developer(0, "Florian", "Mihm"));
		developerlist.add(new Developer(1, "Kim", "Muster"));
		developerlist.add(new Developer(2, "Tom", "Test"));
	}

	public List<Developer> getAllDevelopers() {
		
		return developerlist;
	}
}