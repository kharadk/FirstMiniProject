package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

import lombok.Data;
import lombok.Setter;


@Entity
@Table(name = "contact1")
@Data
public class ContactEntity {
	@Id
	@GeneratedValue
	private int cid;
	@Column(name = "contact_name")
	private String contactName;
	@Column(name = "email_address")
	private String emailAddress;
	@Column(name = "mobile_no")
	private String mobileNo;
}
