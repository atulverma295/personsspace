package com.freedom.persons.commons.validators;

import com.freedom.persons.commons.PersonDTO;

public class PersonRequestValidator {

	public static boolean isValidateName(String name) {
		if (name == null || name.isEmpty() || name.trim().isEmpty())
			return false;
		else
			return true;
	}

	public static boolean isValidPassword(String password) {
		if (password == null || password.isEmpty() || password.trim().isEmpty())
			return false;
		else
			return true;
	}

	public static boolean isValidContact(long contacts) {
		String contact = String.valueOf(contacts);
		if (contact == null || contact.isEmpty() || contact.trim().isEmpty() || contact.length()!=10 || contact.charAt(0) < '9')
			return false;
		else
			return true;
	}

	public static boolean isValidPersonType(String type) {
		if (type == null || type.isEmpty() || type.trim().isEmpty())
			return false;
		else
			return true;
	}

	public static boolean isPersonRequestValid(PersonDTO dto) {
		if (isValidateName(dto.getFirstName()) && isValidateName(dto.getLastName()) 
				&& isValidateName(dto.getCountry()) && isValidateName(dto.getUsername())
				&& isValidPassword(dto.getPassword()) && isValidContact(dto.getContact())
				&& isValidPersonType(dto.getAdmin()))
			return true;
		else
			return false;
	}

	public String inValid() {
		String s = "invalid values please try agaian";
		return s;
	}

}