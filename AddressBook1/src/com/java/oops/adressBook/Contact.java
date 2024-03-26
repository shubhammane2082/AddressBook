package com.java.oops.adressBook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Contact 
{
	List<Person> contactList;
	static Person person;
	
	public Contact()
	{
		this.contactList=new ArrayList<>();
	}
	
	Scanner sc=new Scanner(System.in);
	
	public void Addcontact()
	{
		Person person=new Person();
		
		System.out.println("Enter your First Name : ");
		String firstName=sc.next();
		person.setFirstName(firstName);
		
		boolean matchfirstName=contactList.stream().anyMatch(contact -> contact.getFirstName().equals(firstName));
		if(matchfirstName)
		{
			System.out.println("User with same name already present...");
			return;
		}
		
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
		
		System.out.println("Enter your Email : ");
		String email=sc.next();
		person.setEmail(email);
		
		contactList.add(person);
		Collections.sort(contactList, Comparator.comparing(c -> c.getFirstName()));
		System.out.println("Contact Added Sucessfully...");
	}
	
	public void Editcontact()
	{
		System.out.println("Enter your first Name : ");
		String firstName=sc.next();
		
		for(int i=0;i<contactList.size();i++)
		{
			Person person=contactList.get(i);
			int choicetoedit;
			if(person.getFirstName().equals(firstName))
			{
				System.out.println(" Enter to edit 1.lastName 2.Address 3.city 4.State 5.ZIP 6.phone Number 7.Email");
				choicetoedit = sc.nextInt();
				switch(choicetoedit)
				{
				  case 1 :
					System.out.println("correct your last name :");
					String lastName=sc.next();
					person.setLastName(lastName);
					break;
					
				  case 2 :
						System.out.println("correct your Address :");
						String Address=sc.next();
						person.setAddress(Address);
						break;
						
				  case 3 :
						System.out.println("correct your city :");
						String city=sc.next();
						person.setCity(city);
						break;
						
				  case 4 :
							System.out.println("correct your state :");
							String state=sc.next();
							person.setState(state);
							break;
				  case 5:
					  
						System.out.println("correct your ZIP code :");
						String ZIP=sc.next();
						person.setZIP(ZIP);
						break;
						
				 case 6 :
							System.out.println("correct your Phone No. :");
							String  phone_Number=sc.next();
							person.setPhone_Number(phone_Number);
							break;
							
				case 7 :
							System.out.println("correct your Email :");
							String Email=sc.next();
							person.setEmail(Email);
							break;			
				}
		}
	}
		System.out.println("Contact Edited Sucessfully...");
   }
	
	public void Deletecontact()
	{
		System.out.println("Enter your first Name : ");
		String firstName=sc.next();
		for(int i=0;i<contactList.size();i++)
		{
			Person person=contactList.get(i);
			if(person.getFirstName().equals(firstName))
			{
				contactList.remove(i);
			}
		}
		System.out.println("Delete Sucessfully...");
		System.out.println(contactList);
	}
	
	public void showAllcontact()
	{
		for(int i=0;i<contactList.size();i++)
		{
			Person person=contactList.get(i);
			System.out.println(" First Name is : "+person.getFirstName());
			System.out.println(" Last Name is : "+person.getLastName());
			System.out.println(" Address is : "+person.getAddress());
			System.out.println(" City is : "+person.getCity());
			System.out.println(" State is : "+person.getState());
			System.out.println(" ZIP code is : "+person.getZIP());
			System.out.println(" Phone Number is : "+person.getPhone_Number());
			System.out.println(" Email is : "+person.getEmail());
			System.out.println("   ----------------------------------------------------------------------------------");
		}
	}

	public List<Person> searchbyState(String state1)
	{
		return contactList.stream()
		                           .filter(state -> state.getState().equalsIgnoreCase(state1))
		                           .collect(Collectors.toList());
		                           
	}
	
	public List<Person> searchbyCity(String city1)
	{
		return contactList.stream()
		                           .filter(city -> city.getCity().equalsIgnoreCase(city1))
		                           .collect(Collectors.toList());
	}
}
