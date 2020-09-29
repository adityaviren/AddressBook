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
		System.out.println("Welcome to Address Book System");
		AddressBook book = new AddressBook();
		for(int i=0;i<3;i++) {
			book.addDetails(getContact());
		}
		book.viewAllContacts();
		
	}
}

class Contact {
	private String f_name, l_name, address, city, state, zip, phone_number, email;
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
		AddressBook(String f_name,String l_name,String address,String city,String state,String zip,String phone_number,String email){
			super(f_name, l_name, address, city, state, zip, phone_number, email);
		}
		AddressBook(){
			
		}
}
