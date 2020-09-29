package AddressBook;

import java.util.*;

public class AddressBookMain {
	public static Contact getContact() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter First Name");
		String f_name=sc.nextLine();
		System.out.println("Enter Last Name");
		String l_name=sc.nextLine();
		System.out.println("Enter Address");
		String address=sc.nextLine();
		System.out.println("Enter City");
		String city=sc.nextLine();
		System.out.println("Enter State");
		String state=sc.nextLine();
		System.out.println("Enter ZIP");
		String zip=sc.nextLine();
		System.out.println("Enter Phone Number");
		String phone_number=sc.nextLine();
		System.out.println("Enter Email Id");
		String email=sc.nextLine();
		Contact c=new Contact(f_name, l_name, address, city, state, zip, phone_number, email);
		return c;
		
	}
	public static void main(String args[]) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Welcome to Address Book System");
		AddressBook book = new AddressBook();
		boolean loop=true;
		while(loop) {
		System.out.println("Enter 1 to add contact\n"
				+ "Enter 2 to view all contacts\n"
				+ "Enter 3 to edit a contact\n"
				+ "Enter 4 to delete a contact\n"
				+ "Enter 0 to exit");
		int i=Integer.parseInt(sc.nextLine());
		switch (i) {
		case 1:
			book.addDetails(getContact());
			break;
		case 2:
			book.viewAllContacts();
			break;
		case 3:
			System.out.println("Enter first name");
			String first_name=sc.nextLine();
			System.out.println("Enter last name");
			String last_name=sc.nextLine();
			boolean is_present1 = book.editContact(first_name, last_name);
			if(is_present1==false)
				System.out.println("Contact not found");
			else
				System.out.println("Contact edited");
			break;
		case 4:
			System.out.println("Enter first name");
			String f_name=sc.nextLine();
			System.out.println("Enter last name");
			String l_name=sc.nextLine();
			boolean is_present2 = book.deleteContact(f_name, l_name);
			if(is_present2==false)
				System.out.println("Contact not found");
			else
				System.out.println("Contact deleted");
			break;
			
		default :
			loop=false;
			break;
			
				
		}
		}
		
	}
}

class Contact {
	protected String f_name, l_name, address, city, state, zip, phone_number, email;
	Contact(String f_name,String l_name,String address,String city,String state,String zip,String phone_number,String email) {
		this.f_name=f_name;
		this.l_name=l_name;
		this.address=address;
		this.city=city;
		this.state=state;
		this.zip=zip;
		this.phone_number=phone_number;
		this.email=email;
	}
	public String toString() {
		return "Name :"+f_name+" " + l_name+"\nAddress :"+address + " " + city + " " + state + " " + zip + "\nPhone Number "+phone_number+"\nEmail id :  "+email;
	}
	Contact(){
	}
	
}

class AddressBook extends Contact {
		private ArrayList<Contact> address_book = new ArrayList<Contact>();
		
		public void addDetails(Contact contact) {
			address_book.add(contact);
		}
		
		public void viewAllContacts() {
			for(Contact c : address_book) {
				System.out.println(c);
			}
		}
		public boolean deleteContact(String first_name, String last_name) {
			Scanner sc=new Scanner(System.in);
			boolean check=false;
			for(Contact c: address_book) {
				if(c.f_name.equalsIgnoreCase(first_name)&&c.l_name.equalsIgnoreCase(last_name)) {
					address_book.remove(c);
					check=true;
					break;
				}
			}
			return check;
		}
		
		public boolean editContact(String first_name, String last_name) {
			Scanner sc=new Scanner(System.in);
			boolean check=false;
			for(Contact c: address_book) {
				if(c.f_name.equalsIgnoreCase(first_name)&&c.l_name.equalsIgnoreCase(last_name)) {
					System.out.println("Enter Address");
					c.address=sc.nextLine();
					System.out.println("Enter City");
					c.city=sc.nextLine();
					System.out.println("Enter State");
					c.state=sc.nextLine();
					System.out.println("Enter ZIP");
					c.zip=sc.nextLine();
					System.out.println("Enter Phone Number");
					c.phone_number=sc.nextLine();
					System.out.println("Enter Email Id");
					c.email=sc.nextLine();
					check=true;
					break;
				}
			}
			return check;
		}
		
		AddressBook(String f_name,String l_name,String address,String city,String state,String zip,String phone_number,String email){
			super(f_name, l_name, address, city, state, zip, phone_number, email);
		}
		AddressBook(){
			
		}
}
