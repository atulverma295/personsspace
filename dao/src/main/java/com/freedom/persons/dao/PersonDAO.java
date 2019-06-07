package com.freedom.persons.dao;

import java.util.List;



public interface PersonDAO {

	public List<Person> listPersons();
	public Person getPersonById(int id);
	public Person getPersonByContact(long contact);
	public Person getPersonByIdAndName(int id, String name);
	public void removePerson(int id);
	public Person loginuser(String username,String password);
	public List<Person> getPersonByName(String name);
	public Person getByName(String name);
	public Person updatePersons(Person p);
	public Person addPerson(Person p);
	public List<Person> listPersonsWithoutAdmin(int id);
	public List<Person> listofPersons(int id);
	public List<Person> listofPersons(long contact);
}
