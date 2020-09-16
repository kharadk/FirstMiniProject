package com.example.service;

import java.util.List;

import com.example.binding.Contact;
import com.example.entity.ContactEntity;

public interface ContactService {
  
	public boolean save(Contact contact);
	
	public List<Contact> viewAllContact();
	
	public Contact getContactById(int contactId);

	
	public boolean deleteContact(int contactId);
		
	
}
