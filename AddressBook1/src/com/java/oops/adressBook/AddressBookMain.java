package com.java.oops.adressBook;

import java.util.Scanner;

public class AddressBookMain 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		Person person=new Person();
		person.setFirstName("Alex");
		person.setLastName("Johnson");
		person.setAddress("A/P.Syndney");
		person.setCity("Syndney");
		person.setState("Australia");
		person.setZIP("345678");
		person.setPhone_Number("657898765");
		person.setEmail("Alex123@gmail.com");
		
		System.out.println(person.getFirstName()+" "+person.getLastName()+" "+person.getAddress()+" "+person.getCity()
		+" "+person.getState()+" "+person.getZIP()+" "+person.getPhone_Number()+person.getEmail());
	}
}