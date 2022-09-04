package com.abdillah;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("0888888888");

    public static void main(String[] args) {
        boolean quit = false;
        startPhone();
        printActions();
        while(!quit){
            int action = scanner.nextInt();
            scanner.nextLine();

            switch(action){
                case 0 :
                    System.out.println("Shutting down");
                    quit = true;
                    break;
                case 1 :
                    printContacts();
                    break;
                case 2 :
                    addContact();
                    break;
                case 3 :
                    removeContact();
                    break;
                case 4 :
                    updateContact();
                    break;
                case 5 :
                    queryContact();
                    break;
                case 6 :
                    printActions();
                    break;
            }
        }
    }

    public static void printContacts(){
        System.out.println("Contact list\n");
        mobilePhone.printContacts();
    }
    public static void addContact(){ 
        System.out.println("Enter name : \n");
        String name = scanner.nextLine();
        System.out.println("Enter phone : \n");
        String phoneNum = scanner.nextLine();
        Contact contact = Contact.createContact(name, phoneNum);

        if(mobilePhone.addNewContact(contact)){
            System.out.println("New contact added. name: " + contact.getName() + ", phone: " + contact.getPhoneNumber() + "\n");
        }else {
            System.out.println("Contact already saved\n");
        }
    }

    private static void removeContact(){
        System.out.println("Enter contact name to be removed\n");
        String name = scanner.nextLine();
        Contact existingContact = mobilePhone.queryContact(name);
        if(existingContact == null){
            System.out.println(name + " is not exist");
            return;
        }
        if(mobilePhone.removeContact(existingContact)){
            System.out.println(name + " successfully removed  from contact list");
        } else {
            System.out.println(name + "is not exist in contact list");
        }
    }

    private static void updateContact(){
        System.out.println("Enter old contact name\n");
        String oldName = scanner.nextLine();
        Contact existingContact = mobilePhone.queryContact(oldName);

        if(existingContact == null){
            System.out.println(oldName + "was not found");
            return;
        }

        System.out.println("Enter new contact name\n");
        String newName = scanner.nextLine();
        System.out.println("Enter new phone number:\n");
        String newPhoneNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(newName, newPhoneNumber);


        if(mobilePhone.updateContact(existingContact,newContact)){
            System.out.println(oldName + " successfully updated");
        } else {
            System.out.println(oldName + " is not exist in contact list");
        }
    }

    public static void queryContact(){
        System.out.println("Enter contact name: \n");
        String name = scanner.nextLine();
        System.out.println("Enter contact number: \n");
        String phone = scanner.nextLine();
        Contact contact = new Contact(name, phone);

        mobilePhone.queryContact(contact);
    }

    private static void startPhone(){
        System.out.println("Starting phone...");
    }

    private static void printActions(){
        System.out.println("\nAvailable actions:\npress");
        System.out.println("\n0 - to shutdown");
        System.out.println("\n1 - to print contacts");
        System.out.println("\n2 - to add new contact");
        System.out.println("\n3 - to update existing contact");
        System.out.println("\n4 - to remove contacts");
        System.out.println("\n5 - query if contact exists");
        System.out.println("\n6 - print list of available actions");
        System.out.println("\nChoose your actions: ");
    }
}
