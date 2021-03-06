package com.dio.personapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.personapi.dto.response.MessageResponseDTO;
import com.dio.personapi.entity.Person;
import com.dio.personapi.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	public MessageResponseDTO createPerson(Person person) {

		Person savedPerson = personRepository.save(person);
		return MessageResponseDTO.builder().message("Created person with ID " + savedPerson.getId()).build();
	}

}
