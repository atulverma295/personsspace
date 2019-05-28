package com.freedom.persons.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.freedom.persons.commons.LoginDTO;
import com.freedom.persons.commons.PersonDTO;
import com.freedom.persons.commons.validators.PersonRequestValidator;
import com.freedom.persons.dao.Person;
import com.freedom.persons.service.PersonService;

@Controller
public class PersonController {

	private PersonService personService;

	@Autowired(required = true)
	@Qualifier(value = "personService")
	public void setPersonService(PersonService ps) {
		this.personService = ps;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(@ModelAttribute("loginDTO") LoginDTO loginDTO, BindingResult result, ModelMap model) {

		String name = loginDTO.getUsername();
		String password = loginDTO.getPassword();
		if (PersonRequestValidator.isValidateName(name) && PersonRequestValidator.isValidateName(password))
			model.addAttribute("username", name);
		model.addAttribute("password", password);
		String forward = "login";
		return forward;
	}

	@RequestMapping(value = "/loginUser", method = RequestMethod.POST)
	public String loginUser(@ModelAttribute("loginDTO") LoginDTO loginDTO, ModelMap model) {

		String forwardPage = "";
		PersonDTO personDTO = personService.loginuser(loginDTO.getUsername(), loginDTO.getPassword());
		if (personDTO != null) {
			if (personDTO.getAdmin().equalsIgnoreCase("yes")) {
				List<PersonDTO> personList = this.personService.listPersonsWithoutAdmin(personDTO.getId());
				model.addAttribute("personDTO", personDTO);
				model.addAttribute("listPersonDTO", personList);
				forwardPage = "adminEmployee2";
			} else {
				model.addAttribute("personDTO", personDTO);
				forwardPage = "employee";
			}
		} else {
			model.addAttribute("error", "value is wrong please try again");

			forwardPage = "login";
		}
		return forwardPage;
	}

	@RequestMapping(value = "/searchById", method = RequestMethod.GET)
	public String displayUser(ModelMap model, @RequestParam("id") Integer id,
			@RequestParam("firstName") String firstName) {
		String forwardPage = "";
		PersonDTO personDTO = this.personService.getPersonByIdAndName(id, firstName);
		if (personDTO != null) {
			System.out.println("User is present.");
			forwardPage = "employee";
			model.addAttribute("personDTO", personDTO);
		} else {
			System.out.println("User is not present.");
		}
		return forwardPage;
	}

	@RequestMapping(value = "/remove", method = RequestMethod.GET)
	public String removePerson(@RequestParam("userId") int userId, @RequestParam("adminId") int adminId, Model model) {
		this.personService.removePerson(userId);
		model.addAttribute("personDTO", this.personService.getPersonById(adminId));
		List<PersonDTO> listpersonDTO = this.personService.listPersonsWithoutAdmin(adminId);
		model.addAttribute("listPersonDTO", listpersonDTO);
		return "adminEmployee2";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String editPerson(@RequestParam("userId") int userId, @RequestParam("adminId") int adminId, Model model) {
		PersonDTO userDTO = this.personService.getPersonById(userId);
		userDTO.setAdminId(adminId);
		int id = userDTO.getAdminId();
		model.addAttribute("userDTO", userDTO);
		return "editemployee";
	}

	@RequestMapping(value = "/searchByName", method = RequestMethod.GET)
	public String displayListbyname(ModelMap model, @RequestParam("firstName") String name) {
		String forwardPage = "";
		List<PersonDTO> personDTOlist = this.personService.getPersonByName(name);
		List<PersonDTO> personDTOList = this.personService.listPersons();

		if (personDTOlist != null) {
			System.out.println("User is present.");
			System.out.println(personDTOlist);
			System.out.println(personDTOList);

			forwardPage = "employeelist";
			model.addAttribute("personDTOlist", personDTOlist);
			model.addAttribute("listPersonDTO", personDTOList);

		} else {
			System.out.println("User is not present.");
		}
		return forwardPage;
	}
	
	@RequestMapping(value = "/searchByContact", method = RequestMethod.GET)
	public String byContact(ModelMap model, @RequestParam("contact") long contact) {
		String forwardPage = "";
		PersonDTO personDTO = this.personService.getPersonByContact(contact);
		if (personDTO != null) {
			if(PersonRequestValidator.isValidContact(contact)) {

			forwardPage = "employeelist";
			model.addAttribute("personDTOlist", personDTO);
			}
		} else {
			System.out.println("User is not present.");
		}
		return forwardPage;
	}

	@RequestMapping(value = "/employeename", method = RequestMethod.GET)
	public String getByName(ModelMap model, @RequestParam("firstName") String firstName) {
		String forwardPage = "";
		PersonDTO personDTO = this.personService.getByName(firstName);
		if (personDTO != null) {
			System.out.println("User is present.");
			System.out.println(personDTO);
			forwardPage = "employee";
			model.addAttribute("personDTO", personDTO);
		} else {
			System.out.println("User is not present.");
		}
		return forwardPage;
	}

	@RequestMapping(value = "/employeelist", method = RequestMethod.GET)
	public String getlist(ModelMap model) {
		String forward = "";
		List<PersonDTO> list = this.personService.listPersons();
		if (list != null) {
			model.addAttribute("personDTO", list);
			System.out.println(list);
			forward = "list";
		} else {
			System.out.println("User is not present.");
		}
		return forward;
	}

	@RequestMapping(value = "/editinfo", method = RequestMethod.POST)
	public String updatePersons(ModelMap model, @ModelAttribute("userDTO") PersonDTO userDTO) {
		String forward = "";
		if (userDTO != null) {
			if (PersonRequestValidator.isPersonRequestValid(userDTO)) {
				PersonDTO user = this.personService.updatePersons(userDTO);
				int id = user.getAdminId();
				PersonDTO dto = this.personService.getPersonById(id);
				List<PersonDTO> list = this.personService.listPersonsWithoutAdmin(id);
				model.addAttribute("personDTO", dto);
				model.addAttribute("listPersonDTO", list);
				forward = "adminEmployee2";
			} 
			  else if(userDTO.getAdmin().equalsIgnoreCase("yes")) {		
					int id = userDTO.getId();
					PersonDTO dto = this.personService.getPersonById(id);
					List<PersonDTO> list = this.personService.listPersonsWithoutAdmin(userDTO.getId());
					model.addAttribute("personDTO", dto);
					model.addAttribute("listPersonDTO", list);
					model.addAttribute("error", "value is wrong please try again");
					forward = "adminEmployee2";			
				}
				else {
				int id = userDTO.getId();
				PersonDTO dto = this.personService.getPersonById(id);
				model.addAttribute("personDTO", dto);
				forward = "editemployee";
				model.addAttribute("error", "value is wrong please try again");
				}
			
		} else {
			model.addAttribute("error", "value is wrong please try again");

			forward = "editemployee";
		}

		return forward;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addPersons(Model model, @RequestParam("adminId") int adminId) {
		PersonDTO personDTO = this.personService.getPersonById(adminId);
		PersonDTO per = new PersonDTO();
		per.setAdminId(adminId);
		model.addAttribute("userDTO", per);
		return "addperson";
	}

	@RequestMapping(value = "/noadmin", method = RequestMethod.GET)
	public String listPersonsWithoutAdmin(ModelMap model, @RequestParam("id") int id) {
		String forward = "";
		List<PersonDTO> list = this.personService.listPersonsWithoutAdmin(id);
		if (list != null) {
			model.addAttribute("personDTO", list);
			System.out.println(list);
			forward = "list";
		} else {
			System.out.println("User is not present.");
		}
		return forward;
	}
	@RequestMapping(value = "/addperson", method = RequestMethod.POST)
	public String addPerson(ModelMap model, @ModelAttribute("userDTO") PersonDTO userDTO) {
		String forward = "";
		if (userDTO != null) {
			if (PersonRequestValidator.isPersonRequestValid(userDTO)) {
				PersonDTO addDTO = this.personService.addPerson(userDTO);
				PersonDTO usersDTO = this.personService.getPersonById(addDTO.getAdminId());
				List<PersonDTO> lists = this.personService.listPersonsWithoutAdmin(addDTO.getAdminId());
				model.addAttribute("personDTO", usersDTO);
				model.addAttribute("listPersonDTO", lists);

				forward = "adminEmployee2";
			} else {
				model.addAttribute("error", "value is wrong please try again");
				forward = "addperson";
			}
		} else {
			model.addAttribute("error", "value is wrong please try again");
			forward = "addperson";
		}
		return forward;
	}
}
