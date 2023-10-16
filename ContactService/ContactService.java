package contact_Service;

import java.util.ArrayList;
import java.util.List;

public class ContactService {
    private List<Contact> contacts;

    public ContactService() {
        this.contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        if (getContactByID(contact.getContactID()) != null) {
            throw new IllegalArgumentException("Contact ID must be unique.");
        }

        contacts.add(contact);
    }

    public void deleteContact(String contactID) {
        Contact contactToRemove = getContactByID(contactID);

        if (contactToRemove == null) {
            throw new IllegalArgumentException("Contact not found.");
        }
        contacts.remove(contactToRemove);
    }

    public void updateContact(String contactID, String newFirstName, String newLastName, String newPhone, String newAddress) {
        Contact contactToUpdate = getContactByID(contactID);

        if (contactToUpdate == null) {
            throw new IllegalArgumentException("Contact not found.");
        }

        if (newFirstName != null) {
            contactToUpdate.setFirstName(newFirstName);
        }
        if (newLastName != null) {
            contactToUpdate.setLastName(newLastName);
        }
        if (newPhone != null) {
            contactToUpdate.setPhone(newPhone);
        }
        if (newAddress != null) {
            contactToUpdate.setAddress(newAddress);
        }
    }

    public void updateContactFirstName(String contactId, String firstName) {
        Contact contactToUpdate = getContactByID(contactId);

        if (contactToUpdate == null) {
            throw new IllegalArgumentException("Contact not found.");
        }

        contactToUpdate.setFirstName(firstName);
    }

    public void updateContactLastName(String contactId, String lastName) {
        Contact contactToUpdate = getContactByID(contactId);

        if (contactToUpdate == null) {
            throw new IllegalArgumentException("Contact not found.");
        }

        contactToUpdate.setLastName(lastName);
    }

    public void updateContactPhone(String contactId, String number) {
        Contact contactToUpdate = getContactByID(contactId);

        if (contactToUpdate == null) {
            throw new IllegalArgumentException("Contact not found.");
        }

        contactToUpdate.setPhone(number);
    }

    public void updateContactAddress(String contactId, String address) {
        Contact contactToUpdate = getContactByID(contactId);

        if (contactToUpdate == null) {
            throw new IllegalArgumentException("Contact not found.");
        }

        contactToUpdate.setAddress(address);
    }

    private Contact getContactByID(String contactID) {
        for (Contact contact : contacts) {
            if (contact.getContactID().equals(contactID)) {
                return contact;
            }
        }
        return null;
    }

    public List<Contact> getContacts() {
        return contacts;
    }
}

