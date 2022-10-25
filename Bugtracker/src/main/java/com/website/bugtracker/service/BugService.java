package com.website.bugtracker.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.website.bugtracker.model.Bug;
import com.website.bugtracker.model.Priority;

@Service
public class BugService {

	private List<Bug> buglist = new ArrayList<>();
	
	public BugService() {
		
		buglist.add(new Bug(0, "Testbug", "This is a bug", Priority.CRITICAL, 0));
		buglist.add(new Bug(1, "Wow", "Here is something", Priority.COSMETIC, 0));
	}
	
	public List<Bug> getAllBugs() {
		
		return buglist;
	}
	
	public void addBug(Bug bug) {
		
		buglist.add(bug);
	}
}