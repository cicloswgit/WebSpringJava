package com.aprendendojava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aprendendojava.model.Person;
import com.aprendendojava.service.PersonService;

@Controller
public class PersonController {
	
	private PersonService personService;
	
	@Autowired(required=true)
	@Qualifier(value="personService")
	public void setPersonService(PersonService ps){
		this.personService = ps;
	}
	
	@RequestMapping(value = "/person", method = RequestMethod.GET)
	public String listPeople(Model model) {
		model.addAttribute("person", new Person());
		model.addAttribute("listPeople", this.personService.listPeople());
		return "person";
	}
	
	//For add and update person both
	@RequestMapping(value= "/person/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("person") Person p){
		
		try{
			if(p != null & p.getId() == 0){
				//new person, add it
				this.personService.addPerson(p);
			}else{
				//existing person, call update
				this.personService.updatePerson(p);
			}
		}catch(Exception e)
		{
			System.out.println("Ocorreu um erro. Motivo: "+ e.getMessage());
		}
		
		return "redirect:/person";
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removePerson(@PathVariable("id") int id){
		
        this.personService.removePerson(id);
        return "redirect:/person";
    }
 
    @RequestMapping("/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model){
        model.addAttribute("person", this.personService.getPersonById(id));
        model.addAttribute("listPeople", this.personService.listPeople());
        return "person";
    }
	
}
