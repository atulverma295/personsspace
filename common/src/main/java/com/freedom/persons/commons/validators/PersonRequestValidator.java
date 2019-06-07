package com.freedom.persons.commons.validators;

import com.freedom.persons.commons.PersonDTO;
import com.freedom.persons.commons.SearchDTO;

public class PersonRequestValidator {

	public static boolean isValidSearchDTO(SearchDTO dto) {
		if (dto.getSearchCriteria().equalsIgnoreCase("id")) {
			return isValidId(dto.getSearchText());

		} else if (dto.getSearchCriteria().equalsIgnoreCase("name")) {
			return isValidateName(dto.getSearchText());

		} else if (dto.getSearchCriteria().equalsIgnoreCase("contact")) {
			return isValidContact(dto.getSearchText());
		} else {
			return false;
		}
	}

	public static boolean isValidateName(String name) {
		if (name == null || name.trim().isEmpty())
			return false;
		else
			return true;
	}

	public static boolean isValidId(String id) {
		if (id == null || id.trim().isEmpty()) {
			return false;
		}
		for (int a = 0; a < id.length(); a++) {
			if (Character.isDigit(id.charAt(a)) == false) {
				return false;
			}
		}
		return true;
	}

	public static boolean isValidContact(String contact) {
		if (contact == null || contact.trim().isEmpty() || contact.length() != 10 || contact.charAt(0) < '9') {
			return false;
		}
		for (int a = 0; a < contact.length(); a++) {
			if (Character.isDigit(contact.charAt(a)) == false) {
				return false;
			}
		}
		return true;
	}

	public static boolean isValidPassword(String password) {
		if (password == null || password.trim().isEmpty())
			return false;
		else
			return true;
	}

	public static boolean isValidContact(long contacts) {
		return isValidContact(String.valueOf(contacts));

	}

	public static boolean isValidId(int id) {
		String Id = String.valueOf(id);
		if (Id == null || Id.trim().isEmpty())
			return false;
		else
			return true;
	}

	public static boolean isValidPersonType(String type) {
		if (type == null || type.trim().isEmpty())
			return false;
		else
			return true;
	}

	public static boolean isPersonRequestValid(PersonDTO dto) {
		if (isValidateName(dto.getFirstName()) && isValidateName(dto.getLastName()) && isValidateName(dto.getCountry())
				&& isValidateName(dto.getUsername()) && isValidPassword(dto.getPassword())
				&& isValidContact(dto.getContact()) && isValidPersonType(dto.getAdmin()))
			return true;
		else
			return false;
	}

}