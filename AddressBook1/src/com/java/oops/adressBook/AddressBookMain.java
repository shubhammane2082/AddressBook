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
			System.out.println("1.Add contact 2.Edit Contact 3.Delete Contact 4.Show All Contact 5.Exit");
			System.out.println("Enter your choice : ");
			choice=sc.nextInt();
			
			switch(choice)
			{ 
			    case 1 : 
				  contact.Addcontact();
				  break;
				  
			    case 2 :
			    	contact.Editcontact();
			    	break;
				  
			    case 3 : 
			    	contact.Deletecontact();
			    	break;
			    	
				default : 
					System.out.println("Invalid Choice...");
					break;
			}
		}while(choice !=0);
	}
}