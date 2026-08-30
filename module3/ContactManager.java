import java.util.*; 
 
public class ContactManager { 
 
    public static void main(String[] args) { 
 
        HashMap<String, Contact> contacts = new HashMap<>(); 
 
        // Step 4: add contacts here 
        contacts.put("Jokah", new Contact("Jokah", "614-864-7074"));
        contacts.put("Zion", new Contact("Zion", "201-864-7074"));
        contacts.put("Xenith", new Contact("Xenith", "415-864-7074"));
        contacts.put("Pixel", new Contact("Pixel", "123-864-7074"));
        contacts.put("Caesar", new Contact("Caesar", "703-864-7074"));

        // Step 5: look up a contact 
        Contact found = contacts.get("Jokah");
        if (found == null) {
            System.out.println("Contact not found.");
        } else {
            System.out.println(found);
        }

        Contact missing = contacts.get("Nobody");
        if (missing == null) {
            System.out.println("Contact not found.");
        } else {
            System.out.println(missing);
        }

        // Step 6: print sorted list 
        ArrayList<Contact> sorted = new ArrayList<>(contacts.values()); 
        sorted.sort((a, b) -> a.getName().compareTo(b.getName()));  

        System.out.println("=== All Contacts ===");
        for (Contact contact : sorted) {
            System.out.println(contact);

        }

    } 
}