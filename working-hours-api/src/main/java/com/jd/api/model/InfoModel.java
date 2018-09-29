package com.jd.api.model;

import java.io.Serializable;

public class InfoModel implements Serializable {
	private int id;
	private String requirement;
	private Integer parent;
	private Integer priority;
	private String dockProd;
	private String dockR_D;
	private String workingHours;
	private String start;
	private String end;
	private String comment;
	private String from;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRequirement() {
		return requirement;
	}

	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}

	public Integer getParent() {
		return parent;
	}

	public void setParent(Integer parent) {
		this.parent = parent;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public String getDockProd() {
		return dockProd;
	}

	public void setDockProd(String dockProd) {
		this.dockProd = dockProd;
	}

	public String getDockR_D() {
		return dockR_D;
	}

	public void setDockR_D(String dockR_D) {
		this.dockR_D = dockR_D;
	}

	public String getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(String workingHours) {
		this.workingHours = workingHours;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

}
