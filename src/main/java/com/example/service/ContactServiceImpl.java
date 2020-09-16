package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.binding.Contact;
import com.example.entity.ContactEntity;
import com.example.persistence.ContactDtlsRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactDtlsRepository repo;

	@Override
	public boolean save(Contact contact) {
		ContactEntity entity = new ContactEntity();

		BeanUtils.copyProperties(contact, entity);

		ContactEntity contactEntity1 = repo.save(entity);

		return contactEntity1 != null;
	}

	@Override
	public List<Contact> viewAllContact() {

		List<ContactEntity> contactEntity = repo.findAll();

		List<Contact> contacts = new ArrayList<Contact>();

		contactEntity.forEach(entity -> {
			Contact contact = new Contact();

			BeanUtils.copyProperties(entity, contact);

			System.out.println(contact.getContactName());

			contacts.add(contact);
		});
		return contacts;
	}

	@Override
	public Contact getContactById(int contactId) {
		Optional<ContactEntity> optional = repo.findById(contactId);
		ContactEntity contactEntity = optional.get();
		Contact contact = new Contact();
		System.out.println(contactEntity);
		BeanUtils.copyProperties(contactEntity, contact);

		return contact;
	}

	/*
	 * @Override public boolean updateContact(Contact contact) { // TODO
	 * Auto-generated method stub return false; }
	 */

	@Override
	public boolean deleteContact(int contactId) {
		repo.deleteById(contactId);
		return true;
	}

}
