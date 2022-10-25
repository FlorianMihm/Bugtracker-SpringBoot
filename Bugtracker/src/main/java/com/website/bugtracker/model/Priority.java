package com.website.bugtracker.model;

public enum Priority {

	COSMETIC(1), MINOR(2), MODERATE(3), MAJOR(4), CRITICAL(5);
	
	private final int priority;
	
	private Priority(int priority) {
		
		this.priority = priority;
	}
	
	public int getPriority() {
		
		return this.priority;
	}
	
	public String toString() {
		
		return this.name();
	}
}