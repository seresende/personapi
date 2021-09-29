package com.dio.personapi.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String firstName;
	
	@Column(nullable = false)
	private String lastName;
	
	//unique = true >- cpf unico
	@Column(nullable = false, unique = true)
	private String cpf;
	
	private LocalDate birthDate;
	//relaciomento 1 pessoa para vários telefones
	//Cascade-> quando realizar uma opração no Person já realiza no Phone
	@OneToMany(fetch = FetchType.LAZY, cascade =  {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
	private List<Phone> phones;

}
