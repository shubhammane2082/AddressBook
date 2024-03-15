package com.java.oops.adressBook;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookMain 
{
	public static void main(String[] args) 
	{
		AddressBookMain addressBookmain=new AddressBookMain();
		Scanner sc=new Scanner(System.in);
		int choice;
		
		while(true)
		{
			System.out.println("0.Exit 1.Add Adress Book 2.Use Address Book");
			System.out.println("Enter your choice : ");
			choice=sc.nextInt();
			
			switch(choice)
			{
			   case 0 :
			           System.out.println("Exiting the Application...");
			           sc.close();
			           break; 
			           
			   case 1 :
				       System.out.println("Enter the Address Book Name : ");
				       String addressBookname=sc.next();
				       AddressBookManager.addAddressBook(addressBookname);
				       break;
				       
			   case 2 :
			          System.out.println("Enter the Address Book Name to use : ");
			          addressBookname=sc.next();
			          AddressBookManager.useAddressbook(addressBookname);
			          break;
				       
			  default : 
				      System.out.println("Invalid Choice...");
				      break;
			}
			
		}
		
	}
}