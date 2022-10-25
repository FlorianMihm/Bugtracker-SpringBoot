package com.website.bugtracker.model;

public class Bug {

	private int id;
	private String name;
	private String description;
	private Priority priority;
	private int developerid;
	
	public Bug() {
	}

	public Bug(int id, String name, String description, Priority priority, int developer) {

		this.id = id;
		this.name = name;
		this.description = description;
		this.priority = priority;
		this.developerid = developer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}
	
	public int getDeveloperId() {
		return developerid;
	}

	public void setDeveloperId(int developer) {
		this.developerid = developer;
	}

	@Override
	public String toString() {
		return "Bug [id=" + id + ", name=" + name + ", description=" + description + ", priority=" + priority
				+ ", developerid=" + developerid + "]";
	}
}