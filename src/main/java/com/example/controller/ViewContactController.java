package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.binding.Contact;
import com.example.service.ContactServiceImpl;

@Controller
public class ViewContactController {

	@Autowired
	private ContactServiceImpl contactServiceImpl;

	@GetMapping("/editContact")
	public String handleEditButton(@RequestParam("cid") Integer cid, Model model) {
		Contact contactById = contactServiceImpl.getContactById(cid);

		model.addAttribute("contact", contactById);

		return "index";
	}
      
	@GetMapping("/deleteContact")
	public String handleDelete(@RequestParam("cid") int cid, RedirectAttributes redirectAttributes) {

		boolean deleteContact = contactServiceImpl.deleteContact(cid);
		if (deleteContact) {
			redirectAttributes.addFlashAttribute("delete", "Contact Deleted Successfully..!");
		}
		return "redirect:viewContacts";

	}
}
