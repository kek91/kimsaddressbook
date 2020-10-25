package com.otrum.kimsaddressbook;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

// @CrossOrigin(origins = "*", allowedHeaders = "*")
@RepositoryRestResource(collectionResourceRel = "people", path = "people")
@CrossOrigin(origins = "http://localhost:8081")
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

	// List<Person> findByLastName(@Param("name") String name);
	
}
