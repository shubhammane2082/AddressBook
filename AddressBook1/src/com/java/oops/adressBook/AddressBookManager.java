package com.java.oops.adressBook;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookManager 
{
	static Map<String, Contact> AddressBooks=new HashMap<>();
	static Contact contact=new Contact();
	static Scanner sc=new Scanner(System.in);
	
	public static void addAddressBook(String addressBookname)
	{
		if(AddressBooks.containsKey(addressBookname))
		{
			System.out.println("Address Book with name "+addressBookname+" Already Present.");
		}
		else {
			AddressBooks.put(addressBookname, contact);
			System.out.println("Sucessfully added Address Book with Name "+addressBookname);
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
			System.out.println("0.Exit 1.Add contact 2.Edit Contact 3.Delete Contact 4.Show All Contact");
			System.out.println("Enter your choice : ");
			choice=sc.nextInt();
			
			switch(choice)
			{ 
			   case 0 :
				  System.out.println("Exiting Address Book "+addressBookname+"...");
				  sc.close();
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
			    	
				default : 
					System.out.println("Invalid Choice...");
					break;
			}
		}while(choice !=0);
	}
}
