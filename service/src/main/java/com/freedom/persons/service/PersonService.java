package com.freedom.persons.service;

import java.util.List;

import com.freedom.persons.commons.PersonDTO;

public interface PersonService {
	public List<PersonDTO> listPersons();
	public PersonDTO getPersonById(int id);
	public PersonDTO getPersonByContact(long contact);
	public PersonDTO getPersonByIdAndName(int id, String firstName);
	public void removePerson(int id);
	public PersonDTO loginuser(String username,String password);
	public List<PersonDTO> getPersonByName(String firstName);
	public PersonDTO getByName(String firstName);
	public PersonDTO updatePersons(PersonDTO p);
	public PersonDTO addPerson(PersonDTO p);
	public List<PersonDTO> listPersonsWithoutAdmin(int id);
}

