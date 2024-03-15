package com.java.oops.adressBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Contact 
{
	List<Person> contactList=new ArrayList<>();
	
	Scanner sc=new Scanner(System.in);
	
	public void Addcontact()
	{
		Person person=new Person();
		
		System.out.println("Enter your First Name : ");
		String firstName=sc.next();
		person.setFirstName(firstName);
		
		System.out.println("Enter your Last Name : ");
		String lastName=sc.next();
		person.setLastName(lastName);
		
		System.out.println("Enter your Address :");
		String Address=sc.next();
		person.setAddress(Address);
		
		System.out.println("Enter your city : ");
		String city=sc.next();
		person.setCity(city);
		
		System.out.println("Enter your State :");
		String state=sc.next();
		person.setState(state);
		
		System.out.println("Enter your ZIP : ");
		String ZIP=sc.next();
		person.setZIP(ZIP);
		
		System.out.println("Enter your Phone Number :");
		String phone_Number=sc.next();
		person.setPhone_Number(phone_Number);
		
		System.out.println("Enter your city : ");
		String email=sc.next();
		person.setEmail(email);
		
		contactList.add(person);
		System.out.println(contactList);
	}
}
