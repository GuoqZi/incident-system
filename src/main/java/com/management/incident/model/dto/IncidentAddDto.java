package com.management.incident.model.dto;

import com.management.incident.model.entities.Incident;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;

//@Entity
public class IncidentAddDto {
	private Long id;

	private String title;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private String description;

	@JsonIgnore
	public Incident getEntity() {
		Incident incident = new Incident();
		
		incident.setTitle(getTitle());
		incident.setDescription(getDescription());

		return incident;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
