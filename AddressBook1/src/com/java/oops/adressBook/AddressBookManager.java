package com.java.oops.adressBook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class AddressBookManager 
{
	static Contact contact=new Contact();
	static Person person=new Person();
	static Map<String, Contact> AddressBooks=new HashMap<>();
	static Map<String, List<String>> citys=new HashMap<>();
	static Map<String, List<String>> states=new HashMap<>();
	static Scanner sc=new Scanner(System.in);
	
	public static void addAddressBook(String addressBookname)
	{
		if(AddressBooks.containsKey(addressBookname))
		{
			System.out.println("Address Book with name "+addressBookname+" Already Present."+"\n");
		}
		else {
			AddressBooks.put(addressBookname, contact);
			System.out.println("Sucessfully added Address Book with Name "+addressBookname+"\n");
		}
	}
	
	public static void useAddressbook(String addressBookname)
	{
		contact=AddressBooks.get(addressBookname);
		if(contact == null)
		{
			System.out.println("Address Book with name "+addressBookname+" not found");
			return;
		}
		

        int choice;
		
		do {
			System.out.println("0.Exit \n1.Add contact \n2.Edit Contact \n3.Delete Contact \n4.Show All Contact \n5.search by state \n6.search by city \n7.sort By city");
			System.out.println("Enter your choice : ");
			choice=sc.nextInt();
			
			switch(choice)
			{ 
			   case 0 :
				  System.out.println("Exiting Address Book "+addressBookname+"...");
				  break;
				
			    case 1 : 
				  contact.Addcontact();
				  break;
				  
			    case 2 :
			    	contact.Editcontact();
			    	break;
				  
			    case 3 : 
			    	contact.Deletecontact();
			    	break;
			    	
			    case 4 : 
			    	contact.showAllcontact();
			    	break;
			    	
			    case 5:
			    	System.out.println("Enter the state : ");
			    	String state=sc.next();
			    	searchState(AddressBooks,state);
			    	break;
			    	
			    case 6:
			    	System.out.println("Enter the city : ");
			    	String city=sc.next();
			    	searchCity(AddressBooks,city);
			    	break;	
			    	
			    case 7:
			        System.out.println("Enter the city name to sort by city: ");
			        String city1 = sc.next();
			        sortyBycity(city1);
			        break;
			    	
				default : 
					System.out.println("Invalid Choice...");
					break;
			}
		}while(choice !=0);
	}

	private static void sortyBycity(String city1) 
	{
		for(Contact contact : AddressBooks.values())
		{
			List<Person> searchbyCity = contact.searchbyCity(city1);
			if(!searchbyCity.isEmpty())
			{
				Collections.sort(searchbyCity, Comparator.comparing(Person::getCity));
				System.out.println("contacts are sorted in city "+city1);
				
				for(Person person : searchbyCity)
				{
					System.out.println(person);
				}
			}
			return;
		}
		System.out.println("person with city you entered not found...");
	}
	

	private static void searchCity(Map<String, Contact> addressBooks, String city) 
	{
		List<String> cityName=new ArrayList<>();
		for(String addressBookname: addressBooks.keySet())
		{
			Contact contact=addressBooks.get(addressBookname);
			List<Person> searchbyCity = contact.searchbyCity(city);
			if(!searchbyCity.isEmpty())
			{
				System.out.println("Contacts in city : "+city+" in address Book "+addressBookname+"\n");
				
				for(Person person : searchbyCity)
				{
					System.out.println(" First Name is : "+person.getFirstName());
					System.out.println(" Last Name is : "+person.getLastName());
					System.out.println(" Address is : "+person.getAddress());
					System.out.println(" City is : "+person.getCity());
					System.out.println(" State is : "+person.getState());
					System.out.println(" ZIP code is : "+person.getZIP());
					System.out.println(" Phone Number is : "+person.getPhone_Number());
					System.out.println(" Email is : "+person.getEmail());
					System.out.println("------------------------------------------------------------------------------------");
					cityName.add(person.getCity());
				}
			}
			else {
				System.out.println("There is no any person with "+city+ " you entered");
		    }
			int count=(int) cityName.stream().count();
			citys.put(city, cityName);
			System.out.println("City list is :"+citys);
			System.out.println("Count of city "+city+" is : "+count);
		}
	}

	private static void searchState(Map<String, Contact> addressBooks, String state) {
		List<String> stateName=new ArrayList<>();
		for(String addressBookname: addressBooks.keySet())
		{
			Contact contact=addressBooks.get(addressBookname);
			List<Person> searchbystate=contact.searchbyState(state);
			
			if(!searchbystate.isEmpty())
			{
				System.out.println("Contacts in state : "+state+" in addresss Book "+addressBookname+"\n");
				
				for(Person person : searchbystate)
				{
					System.out.println(" First Name is : "+person.getFirstName());
					System.out.println(" Last Name is : "+person.getLastName());
					System.out.println(" Address is : "+person.getAddress());
					System.out.println(" City is : "+person.getCity());
					System.out.println(" State is : "+person.getState());
					System.out.println(" ZIP code is : "+person.getZIP());
					System.out.println(" Phone Number is : "+person.getPhone_Number());
					System.out.println(" Email is : "+person.getEmail());
					System.out.println("----------------------------------------------------------------------------------");
					stateName.add(person.getState());
				}
			}else {
				System.out.println("There is no any person with state you entered");
			}
			int count=(int) stateName.stream().count();
			states.put(state, stateName);
			System.out.println("State is :"+states);
			System.out.println("Count of state "+state+" is : "+count);
			
			
		}
		
	}
}
