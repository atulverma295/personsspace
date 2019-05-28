package com.freedom.persons.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;



@Repository
public class PersonDAOImpl implements PersonDAO {

	private static final Logger logger = LoggerFactory.getLogger(PersonDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@SuppressWarnings("unchecked")
	
	public List<Person> listPersons() {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Person p");	
		List<Person> personsList = (List<Person>) query.list();
		for (Person p : personsList) {
			logger.info("Person List::" + p);
		}
		return personsList;
	}

	public Person getPersonById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Person p = (Person) session.load(Person.class, new Integer(id));
		logger.info("Person loaded successfully, Person details=" + p);
		return p;
	}
	public Person getPersonByContact(long contact) {
		Session session = this.sessionFactory.getCurrentSession();
		Person p = (Person) session.load(Person.class, new Long(contact));
		logger.info("Person loaded successfully, Person details=" + p);
		return p;
	}


	public void removePerson(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Person p = (Person) session.load(Person.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
		logger.info("Person deleted successfully, person details=" + p);
	}

	public Person loginuser(String username, String password) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Person p where p.username = :userName and p.password = :password");
		query.setString("userName", username);
		query.setString("password", password);
		List<Person> list = (List<Person>) query.list();
		if(list.size() > 0) {
			return (Person) query.list().get(0);
		}
		else {
			return null;
		}
	}
	
	public Person getPersonByIdAndName(int id, String name) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Person p where p.id = :id and p.name = :name");
		query.setInteger("id", id);
		query.setString("name", name);
		List<Person> list = (List<Person>) query.list();
		if(list.size() > 0) {
			return (Person) query.list().get(0);
		}
		else {
			return null;
		}
	}
	
	public List<Person> getPersonByName(String name) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Person p where p.name LIKE '"+ name+ "%'");
		List<Person> list=(List<Person>) query.list();
		if(list.size()>0)
		{
		  return list;
		}
		else {
			return null;
		}
	}
	public Person getByName(String name) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Person p where p.name=:name");
		query.setString("name", name);
		List<Person> list=(List<Person>) query.list();
		if(list.size()>0)
		{
			return (Person) query.list().get(0);
		}
		else {
			return null;
		}
	}
	
	public Person updatePersons(Person p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Person update successfully, Person Details=" + p);
		return p;
	}
	
	public Person addPerson(Person p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Person saved successfully, Person Details="+p);
		return p;
	}
	public List<Person> listPersonsWithoutAdmin(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Person p where p.id!=:id");
		query.setInteger("id", id);
		
		List<Person> personsList = (List<Person>) query.list();
		for (Person p : personsList) {
			logger.info("Person List::" + p);
		}
		return personsList;
	}
}
