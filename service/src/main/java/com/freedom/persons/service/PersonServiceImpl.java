package com.freedom.persons.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.freedom.persons.commons.PersonDTO;
import com.freedom.persons.dao.Person;
import com.freedom.persons.dao.PersonDAO;

@Service
public class PersonServiceImpl implements PersonService {

	private PersonDAO personDAO;

	public void setPersonDAO(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}

	@Transactional
	public List<PersonDTO> listPersons() {
		List<PersonDTO> personDTO = new ArrayList<PersonDTO>();
		List<Person> list = this.personDAO.listPersons();
		for (int i = 0; i < list.size(); i++) {
			Person p = list.get(i);

			PersonDTO per = new PersonDTO();
			per.setId(p.getId());
			per.setFirstName(p.getFirstName());
			per.setLastName(p.getLastName());
			per.setCountry(p.getCountry());
			per.setUsername(p.getUsername());
			per.setPassword(p.getPassword());
			per.setAdmin(p.getAdmin());
			per.setContact(p.getContact());
			personDTO.add(per);

		}
		return personDTO;
	}

	@Transactional
	public PersonDTO getPersonById(int id) {
		PersonDTO personDTO = null;
		Person person = this.personDAO.getPersonById(id);
		if(person!=null) {
			personDTO = new PersonDTO();
			personDTO.setId(person.getId());
			personDTO.setFirstName(person.getFirstName());
			personDTO.setLastName(person.getLastName());
			personDTO.setCountry(person.getCountry());
			personDTO.setUsername(person.getUsername());
			personDTO.setPassword(person.getPassword());
			personDTO.setAdmin(person.getAdmin());
			personDTO.setContact(person.getContact());
		}
		return personDTO;

	}

	@Transactional
	public PersonDTO getPersonByContact(long contact) {
		PersonDTO personDTO = new PersonDTO();
		Person person = this.personDAO.getPersonByContact(contact);
		personDTO.setId(person.getId());
		personDTO.setFirstName(person.getFirstName());
		personDTO.setLastName(person.getLastName());
		personDTO.setCountry(person.getCountry());
		personDTO.setUsername(person.getUsername());
		personDTO.setPassword(person.getPassword());
		personDTO.setAdmin(person.getAdmin());
		personDTO.setContact(person.getContact());
		return personDTO;

	}

	@Transactional
	public void removePerson(int id) {
		PersonDTO personDTO = new PersonDTO();
		Person person = this.personDAO.getPersonById(id);
		personDTO.setId(person.getId());
		personDTO.setFirstName(person.getFirstName());
		personDTO.setLastName(person.getLastName());
		personDTO.setCountry(person.getCountry());
		personDTO.setUsername(person.getUsername());
		personDTO.setPassword(person.getPassword());
		personDTO.setAdmin(person.getAdmin());
		personDTO.setContact(person.getContact());
		int ID = personDTO.getId();
		this.personDAO.removePerson(ID);
	}

	@Transactional
	public PersonDTO loginuser(String username, String password) {
		PersonDTO personDTO = null;
		Person person = this.personDAO.loginuser(username, password);
		if (person != null) {
			personDTO = new PersonDTO();
			personDTO.setId(person.getId());
			personDTO.setFirstName(person.getFirstName());
			personDTO.setLastName(person.getLastName());
			personDTO.setCountry(person.getCountry());
			personDTO.setUsername(person.getUsername());
			personDTO.setPassword(person.getPassword());
			personDTO.setAdmin(person.getAdmin());
			personDTO.setContact(person.getContact());
		}
		return personDTO;
	}

	@Transactional
	public PersonDTO getPersonByIdAndName(int id, String firstName) {
		PersonDTO personDTO = new PersonDTO();
		Person person = this.personDAO.getPersonByIdAndName(id, firstName);
		personDTO.setId(person.getId());
		personDTO.setFirstName(person.getFirstName());
		personDTO.setLastName(person.getLastName());
		personDTO.setCountry(person.getCountry());
		personDTO.setUsername(person.getUsername());
		personDTO.setPassword(person.getPassword());
		personDTO.setAdmin(person.getAdmin());
		personDTO.setContact(person.getContact());
		return personDTO;

	}

	@Transactional
	public List<PersonDTO> getPersonByName(String firstName) {
		List<PersonDTO> personDTO =new ArrayList<PersonDTO>();
		List<Person> list = this.personDAO.getPersonByName(firstName);
		if(list!=null) {
			for (int i = 0; i < list.size(); i++) {
				Person p = list.get(i);
				PersonDTO per = new PersonDTO();
				per.setId(p.getId());
				per.setFirstName(p.getFirstName());
				per.setLastName(p.getLastName());
				per.setCountry(p.getCountry());
				per.setUsername(p.getUsername());
				per.setPassword(p.getPassword());
				per.setAdmin(p.getAdmin());
				per.setContact(p.getContact());
				personDTO.add(per);
		}
		}
		return personDTO;

	}

	@Transactional
	public PersonDTO getByName(String firstName) {
		PersonDTO personDTO = new PersonDTO();
		Person person = this.personDAO.getByName(firstName);
		personDTO.setId(person.getId());
		personDTO.setFirstName(person.getFirstName());
		personDTO.setLastName(person.getLastName());
		personDTO.setCountry(person.getCountry());
		personDTO.setUsername(person.getUsername());
		personDTO.setPassword(person.getPassword());
		personDTO.setAdmin(person.getAdmin());
		personDTO.setContact(person.getContact());
		return personDTO;
	}

	@Transactional
	public PersonDTO updatePersons(PersonDTO personDTO) {
		if (personDTO != null) {
			Person person = new Person();
			person.setId(personDTO.getId());
			person.setFirstName(personDTO.getFirstName());
			person.setLastName(personDTO.getLastName());
			person.setCountry(personDTO.getCountry());
			person.setUsername(personDTO.getUsername());
			person.setPassword(personDTO.getPassword());
			person.setAdmin(personDTO.getAdmin());
			person.setContact(personDTO.getContact());
			this.personDAO.updatePersons(person);
		}
		return personDTO;
	}

	@Transactional
	public PersonDTO addPerson(PersonDTO personDTO) {
		if (personDTO != null) {
			Person person = new Person();
			person.setId(personDTO.getId());
			person.setFirstName(personDTO.getFirstName());
			person.setLastName(personDTO.getLastName());
			person.setCountry(personDTO.getCountry());
			person.setUsername(personDTO.getUsername());
			person.setPassword(personDTO.getPassword());
			person.setAdmin(personDTO.getAdmin());
			person.setContact(personDTO.getContact());
			this.personDAO.addPerson(person);
		}
		return personDTO;
	}

	@Transactional
	public List<PersonDTO> listPersonsWithoutAdmin(int id) {
		List<PersonDTO> personDTO = new ArrayList<PersonDTO>();
		List<Person> list = this.personDAO.listPersonsWithoutAdmin(id);
		for (int i = 0; i < list.size(); i++) {
			Person p = list.get(i);

			PersonDTO per = new PersonDTO();
			per.setId(p.getId());
			per.setFirstName(p.getFirstName());
			per.setLastName(p.getLastName());
			per.setCountry(p.getCountry());
			per.setUsername(p.getUsername());
			per.setPassword(p.getPassword());
			per.setAdmin(p.getAdmin());
			per.setContact(p.getContact());
			personDTO.add(per);

		}
		return personDTO;
	}
/*	@Transactional
	public List<PersonDTO> listofPersons(int id) {
		List<PersonDTO> personDTO = new ArrayList<PersonDTO>();
		List<Person> list = this.personDAO.listofPersons(id);
		for (int i = 0; i < list.size(); i++) {
			Person p = list.get(i);

			PersonDTO per = new PersonDTO();
			per.setId(p.getId());
			per.setFirstName(p.getFirstName());
			per.setLastName(p.getLastName());
			per.setCountry(p.getCountry());
			per.setUsername(p.getUsername());
			per.setPassword(p.getPassword());
			per.setAdmin(p.getAdmin());
			per.setContact(p.getContact());
			personDTO.add(per);

		}
		return personDTO;
	}*/
	@Transactional
	public List<PersonDTO> listofPersons(long contact) {
		List<PersonDTO> personDTO = new ArrayList<PersonDTO>();
		List<Person> list = this.personDAO.listofPersons(contact);
		for (int i = 0; i < list.size(); i++) {
			Person p = list.get(i);

			PersonDTO per = new PersonDTO();
			per.setId(p.getId());
			per.setFirstName(p.getFirstName());
			per.setLastName(p.getLastName());
			per.setCountry(p.getCountry());
			per.setUsername(p.getUsername());
			per.setPassword(p.getPassword());
			per.setAdmin(p.getAdmin());
			per.setContact(p.getContact());
			personDTO.add(per);

		}
		return personDTO;
	}
	@Transactional
	public List<PersonDTO> listofPersons(int id) {
		List<PersonDTO> personDTO = null;
		List<Person> list = this.personDAO.listofPersons(id);
		if(list!=null) {
			for (int i = 0; i < list.size(); i++) {
			Person p = list.get(i);

			PersonDTO per = new PersonDTO();
			per.setId(p.getId());
			per.setFirstName(p.getFirstName());
			per.setLastName(p.getLastName());
			per.setCountry(p.getCountry());
			per.setUsername(p.getUsername());
			per.setPassword(p.getPassword());
			per.setAdmin(p.getAdmin());
			per.setContact(p.getContact());
			personDTO=new ArrayList<PersonDTO>();
			personDTO.add(per);

		}
			}
		return personDTO;
	}


}
