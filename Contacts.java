import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Contacts{
    private static final String FILE = "contacts.txt";

    public static void addContact(String name, String phoneNum){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE, true))){
            writer.write(name + ", " + phoneNum);
            writer.newLine();
            System.out.println("Contact has been added!");
        } catch (IOException e){
            System.out.println("An error occured " + e.getMessage());
        }
        if (!name.matches(".*[a-zA-Z].*")){
            System.out.println("Invalid name. Use letters!");
            clearContactsFile();
            return;
        }
        if (phoneNum.length() != 11 || phoneNum.matches(".*[a-zA-Z]")){
            System.out.println("Invalid phone number! It should be exactly 11 digits & with no letters.");
            clearContactsFile();
            return;
        }
    }

    private static void clearContactsFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE))) {
            //to clear the contacts!!!
        } catch (IOException e) {
            System.out.println("An error occurred while clearing the contacts file: " + e.getMessage());
        }
    }

    public static void viewContacts(){
        try(BufferedReader reader = new BufferedReader(new FileReader(FILE))){
            System.out.println("List of Contacts:");
            String line;
            boolean hasContacts = false;
            while ((line = reader.readLine()) != null){
                if(!line.trim().isEmpty()){
                    System.out.println(line);
                    hasContacts = true;
                }
            }
            if (!hasContacts){
                System.out.println("No contacts found!");
            }
        } catch (IOException e){
            System.out.println("An error occured " + e.getMessage());
        }
    }

    public static void updateContact(String oldName, String newName, String newNum){
        List<String> contacts = new ArrayList<>();
        boolean found = false;

        try(BufferedReader reader = new BufferedReader(new FileReader(FILE))){
            String line;
            while((line = reader.readLine()) != null){
                if (line.trim().startsWith(oldName.trim())){
                    contacts.add(newName + ", " + newNum);
                    found = true;
                } else {
                    contacts.add(line);
                }
            }
        } catch (IOException e ){
            System.out.println("An error occured " + e.getMessage());
            return;
        }
        if (!found){
            System.out.println("Contact not found!");
            return;
        }

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE))){
            for (String contact: contacts){
                writer.write(contact);
                writer.newLine();
            }
            System.out.println("Contact successfully updated!");
        } catch (IOException e){
            System.out.println("An error occured " + e.getMessage());
        }
    }

    public static void deleteContact(String name) {
        List<String> contacts = new ArrayList<>();
        boolean found = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().startsWith(name.trim())) {
                    found = true;
                } else {
                    contacts.add(line);
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while deleting the contact.");
            return;
        }

        if (!found) {
            System.out.println("Contact not found.");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE))) {
            for (String contact : contacts) {
                writer.write(contact);
                writer.newLine();
            }
            System.out.println("Contact deleted.");
        } catch (IOException e) {
            System.out.println("An error occurred while saving contacts.");
        }
    }
}


