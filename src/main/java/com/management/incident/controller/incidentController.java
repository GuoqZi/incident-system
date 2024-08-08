package com.management.incident.controller;

import com.management.incident.model.dto.IncidentAddDto;
import com.management.incident.model.dto.IncidentUpdateDto;
import com.management.incident.model.entities.Incident;
import com.management.incident.repository.IncidentRepository;
import com.management.incident.util.StringValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

@RestController
public class incidentController {

	@Autowired
	private IncidentRepository incidentRepository;

	@GetMapping("/incidents")
	public Page<Incident> getIncidents(
			@RequestParam(required = false) String page, 
			@RequestParam(required = false) String title,
			@RequestParam(required = false) String desc ) {
		Integer pageNumber = StringValidationUtils.stringToPageNumber(page);
		if (title != null) title =  title.replace(" ", "%");
		if (desc != null) desc =  desc.replace(" ", "%");

		Page<Incident> result = incidentRepository.find(title, desc, PageRequest.of(pageNumber, 20));
		return result;
	}

	@GetMapping("/incidents/{id}")
	public Incident getMovieById(@PathVariable(required = true) Integer id, Model model) {
		Incident incident = incidentRepository.findById(id).orElse(null);

		if (incident == null)
			throw new IllegalArgumentException("Incident Id not found.");

		model.addAttribute("incident", incident);

		return incident;
	}
	
	@PostMapping(value="/incident",consumes = {"application/json"})
	public Incident addIncident(@RequestBody @Valid IncidentAddDto dto) {
		return incidentRepository.save(dto.getEntity());
	}
	
	@PutMapping(value="/incident", consumes = {"application/json"})
	public ResponseEntity<?> updateIncident(@RequestBody @Valid IncidentUpdateDto dto) {
		Incident incident = incidentRepository.findById(dto.getId()).orElse(null);
		
		if (incident == null){
//			throw new IllegalArgumentException("Incident Id not found.");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}


		dto.updateEntity(incident);
		incidentRepository.save(incident);

		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/incident/{id}")
	public ResponseEntity<?> deleteIncident(@PathVariable(required = true) Integer id) {
		Incident incident = incidentRepository.findById(id).orElse(null);
		
		if (incident == null) {
//			throw new IllegalArgumentException("Incident Id not found.");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		incidentRepository.delete(incident);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
