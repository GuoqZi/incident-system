package com.management.incident.model.dto;

import com.management.incident.model.entities.Incident;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

//@Entity
public class IncidentUpdateDto {

	@NotNull
    private Integer id;

	private String title;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private String description;

	@JsonIgnore
	public Incident updateEntity(Incident incident) {
		
		if (getTitle() != null) {
			incident.setTitle(getTitle());
		}
		if (getDescription() != null) {
			incident.setDescription(getDescription());
		}
		
		return incident;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
