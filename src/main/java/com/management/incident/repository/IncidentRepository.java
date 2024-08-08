package com.management.incident.repository;

import com.management.incident.model.entities.Incident;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import org.springframework.cache.annotation.Cacheable;

public interface IncidentRepository extends PagingAndSortingRepository<Incident, Integer>{


	@Cacheable(value ="user", key = "#pageable")
	@Query(value = "SELECT incident "
			+ "FROM Incident incident "
			+ "WHERE (:title is null or incident.title like %:title%) "
			+ " AND (:description is null or incident.title like %:description%) "
			+ "ORDER BY incident.title asc ",
			countQuery = "SELECT count(incident) "
					+ "FROM Incident incident "
					+ "WHERE (:title is null or incident.title like %:title%) "
					+ " and  (:description is null or incident.description like %:description%) ")
	public Page<Incident> find(@Param("title") String title,
							   @Param("description") String description,
							   Pageable pageable);
}
