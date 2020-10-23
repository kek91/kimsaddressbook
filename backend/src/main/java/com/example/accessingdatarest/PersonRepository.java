package com.otrum.kimsaddressbook;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

	// List<Person> findByName(@Param("name") String name);
	// List<Person> findByAge(@Param("age") int age);
	// List<Person> findByLastName(@Param("name") String name);
	// List<Person> searchByName(@Param("name") String name);

}
