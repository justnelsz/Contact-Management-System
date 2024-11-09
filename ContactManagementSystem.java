import java.util.Scanner;

public class ContactManagementSystem{
    private static final Contacts contacts = new Contacts();
    public static void main (String[] args){
        Scanner scan = new Scanner(System.in);
        
        while (true){
            System.out.println("\nContact Management System:");
            System.out.println("1. Add Contact\n2. View Contacts\n3. Update Contact\n4. Delete Contact\n5. Exit");
            System.out.println("Enter your choice: ");

            while(!scan.hasNextInt()){ //This is for invalid input
                System.out.println("Invalid prompt. Please enter a numberic value!");
                scan.nextLine();
                System.out.println("1. Add Contact\n2. View Contacts\n3. Update Contact\n4. Delete Contact\n5. Exit");
            }
           
            int userChoice = scan.nextInt();
            scan.nextLine();

            switch(userChoice){
                case 1: 
                    System.out.print("Name: ");
                    String name = scan.nextLine().toUpperCase();
                    System.out.print("Phone Number: ");
                    String phoneNum = scan.nextLine();
                    Contacts.addContact(name, phoneNum); 
                    break;

                case 2: 
                    Contacts.viewContacts();
                    break;

                case 3: 
                    System.out.print("Enter the name to be changed: ");
                    String oldName = scan.nextLine().toUpperCase();
                    System.out.print("Enter new name: ");
                    String newName = scan.nextLine().toUpperCase();
                    System.out.print("Enter new contact number: ");
                    String newNum = scan.nextLine();
                    Contacts.updateContact(oldName, newName, newNum); //to be added phone number
                    break;

                case 4: 
                    System.out.print("Enter name to be deleted in your contacts: ");
                    String deleteName = scan.nextLine().toUpperCase();
                    Contacts.deleteContact(deleteName);
                    break;

                case 5:
                    System.out.println("Thank you!");
                    return;

                default:
                    System.out.println("Invalid input! Please try again");
            }
        }    
    }
}


