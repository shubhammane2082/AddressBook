package com.java.oops.adressBook;

import java.util.Scanner;

public class AddressBookMain 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		Contact contact=new Contact();
		int choice;
		
		do {
			System.out.println("0.Exit 1.Add contact 2.Edit Contact 3.Delete Contact 4.Show All Contact");
			System.out.println("Enter your choice : ");
			choice=sc.nextInt();
			
			switch(choice)
			{ 
			   case 0 :
				  System.out.println("Exiting Application...");
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