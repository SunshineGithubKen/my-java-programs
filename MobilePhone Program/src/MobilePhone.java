import java.util.ArrayList;
import java.util.Scanner;

    public class MobilePhone {

        public static Scanner scanner;
        private static MobilePhone mobilePhone;
        private String myNumber;
        private static ArrayList<Contact> myContact;

        public MobilePhone(String myNumber) {
            this.myNumber = myNumber;
            this.myContact = new ArrayList<Contact>();
        }

        public static boolean addNewContact(Contact contact) {
            if (findContact(contact.getName()) != -1) {
                return false;
            } else {
                return myContact.add(contact);
            }
        }

        public static void addNewContact() {
            System.out.print("Enter new contact name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new contact phone : ");
            String phone = scanner.nextLine();
            Contact newContact = Contact.createContact(name, phone);
            if (addNewContact(newContact)) {
                System.out.println("New contact added: name = " + name + ", phone = " + phone);
            } else {
                System.out.println("Cannot add, " + name + " already on file");
            }
        }

        public boolean updateContact(Contact oldContact, Contact newContact) {
            int position = findContact(oldContact);
            if (position < 0) {
                System.out.println("Contact not found, no update ");
                return false;
            } else {
                myContact.set(position, newContact);
                System.out.println(newContact.getName() +
                        "Contact found, updated list");
                return true;
            }
        }

        private static void updateContact() {
            System.out.println("Enter existing contact name: ");
            String name = scanner.nextLine();
            Contact existingContactRecord = mobilePhone.queryContact(name);
            if (existingContactRecord == null) {
                System.out.println("Contact not found.");
                return;
            }
        }

        public boolean removeContact(Contact contact) {
            return findContact(contact) == -1 ? false : myContact.remove(contact);
        }

        private static void removeContact() {
            System.out.println("Enter existing contact name: ");
            String name = scanner.nextLine();
            Contact existingContactRecord = mobilePhone.queryContact(name);
            if (existingContactRecord == null) {
                System.out.println("Contact not found.");
                return;
            }}

            private int findContact (Contact contact){
                return (myContact.contains(contact) ? myContact.indexOf(contact) : -1);
            }

            private static int findContact(String name) {
                for(Contact contact : myContact) {
                    if(contact.getName().equals(name)) {
                        return myContact.indexOf(contact);
                    }
                }
                return -1;
            }

            public Contact queryContact (String contactName){
                for (int i = 0; i < myContact.size(); i++) {
                    Contact contact = myContact.get(i);
                    if (contact.getName().equals(contactName)) {
                        return contact;
                    }
                }
                return null;
            }
            private static void queryContact() {
            System.out.println("Enter existing contact name: ");
            String name = scanner.nextLine();
            Contact existingContactRecord = mobilePhone.queryContact(name);
            if (existingContactRecord == null) {
                System.out.println("Contact not found.");
                return;
            }}

            public static void printContact () {
                System.out.println("Contact List:");
                for (int i = 0; i < myContact.size(); i++) {
                    Contact contact = myContact.get(i);
                    System.out.println(i + 1 + ". " + contact.getName() + "-> " +
                            contact.getPhoneNumber());
                }
            }

            public static void printActions () {
                System.out.print("\nAvailable actions:\npress ");
                System.out.println(" 0  - to shutdown\n" +
                        "       1  - to print contacts\n" +
                        "       2  - to add a new contact\n" +
                        "       3  - to update existing an existing contact\n" +
                        "       4  - to remove an existing contact\n" +
                        "       5  - query if an existing contact exists\n" +
                        "       6  - to print a list of available actions.");
                System.out.print("Choose your action: ");
            }
        }




