package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.binding.Contact;
import com.example.service.ContactService;
import com.example.service.ContactServiceImpl;

@Controller
public class ContactInfoController {

	@Autowired
	private ContactService contactService;

	@GetMapping(value = { "/" })
	public String DisplayContactForm(Model model) {

		Contact contactObj = new Contact();

		model.addAttribute("contact", contactObj);

		return "index";
	}

	@PostMapping(value = { "/saveContact" })
	public String handleSubmitButton(@ModelAttribute("contact") Contact contact, RedirectAttributes attributes) {
		boolean isSave = contactService.save(contact);
		System.out.print(contact.getContactName());
		if (isSave) {
			if (contact.getCid() != 0) {
                  attributes.addFlashAttribute("update","Contact Update Successfully");
			} else {
				attributes.addFlashAttribute("success", "Contact Save Successfully");
			}

		} else {
			attributes.addFlashAttribute("fail", "Contact Save Failed");
		}
		return "redirect:/";
	}

	@GetMapping("/viewContacts")
	public String handleViewAllContactact(Model model, Contact contact) {

		List<Contact> allContact = contactService.viewAllContact();
		System.out.println(allContact);

		model.addAttribute("contacts", allContact);

		return "viewContacts";

	}
}
