package com.freedom.persons.commons;

public class PersonDTO {

	private int id;
	private String firstName;
	private String lastName;
	private String country;
	private String username;
	private String password;
	private String admin;
	private int adminId;
	private long contact;

	public int getId() {
		return id;
	}

	public void setId(int Id) {
		this.id = Id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String FirstName) {
		this.firstName = FirstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String LastName) {
		this.lastName = LastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String Country) {
		this.country = Country;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String Username) {
		this.username = Username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String Password) {
		this.password = Password;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String Admin) {
		this.admin = Admin;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "PersonDTO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", country=" + country
				+ ", username=" + username + ", password=" + password + ", admin=" + admin + ", adminId=" + adminId
				+ ", contact=" + contact + "]";
	}

}