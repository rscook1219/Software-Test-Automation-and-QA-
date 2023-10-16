package contact_Service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactServiceTest {
    ContactService contactService;
    Contact contact;

    @BeforeEach
    void setUp() {
        contactService = new ContactService();
        contact = new Contact("12345", "John", "Doe", "1234567890", "123 Address Circle");
    }

    @Test
    public void testAddContact() {
        contactService.addContact(contact);
        assertTrue(contactService.getContacts().contains(contact));
    }

    @Test
    public void testDeleteContact() {
        contactService.addContact(contact);

        contactService.deleteContact(contact.getContactID());
        assertFalse(contactService.getContacts().contains(contact));

        assertThrows(IllegalArgumentException.class, () -> contactService.deleteContact("nonexistent ID"));
    }

    @Test
    public void testUpdateContact() {
        contactService.addContact(contact);

        contactService.updateContact(contact.getContactID(), "Jane", "Doe", "9876543210", "456 Somewhere Dr");
        Contact updatedContact = contactService.getContacts().get(0);
        assertEquals("Jane", updatedContact.getFirstName());
        assertEquals("Doe", updatedContact.getLastName());
        assertEquals("9876543210", updatedContact.getPhone());
        assertEquals("456 Somewhere Dr", updatedContact.getAddress());

        assertThrows(IllegalArgumentException.class, () -> contactService.updateContact("nonexistentID", "Jane", "Doe", "9876543210", "456 Somewhere Dr"));
    }

    @Test
    public void testUpdateContactFirstName() {
        contactService.addContact(contact);

        contactService.updateContactFirstName(contact.getContactID(), "Jane");
        Contact updatedContact = contactService.getContacts().get(0);
        assertEquals("Jane", updatedContact.getFirstName());
        assertEquals("Doe", updatedContact.getLastName());
        assertEquals("1234567890", updatedContact.getPhone());
        assertEquals("123 Address Circle", updatedContact.getAddress());

        assertThrows(IllegalArgumentException.class, () -> contactService.updateContactFirstName("nonexistentID", "Jane"));
    }

    @Test
    public void testUpdateContactLastName() {
        contactService.addContact(contact);

        contactService.updateContactLastName(contact.getContactID(), "Smith");
        Contact updatedContact = contactService.getContacts().get(0);
        assertEquals("John", updatedContact.getFirstName());
        assertEquals("Smith", updatedContact.getLastName());
        assertEquals("1234567890", updatedContact.getPhone());
        assertEquals("123 Address Circle", updatedContact.getAddress());

        assertThrows(IllegalArgumentException.class, () -> contactService.updateContactLastName("nonexistentID", "Smith"));
    }

    @Test
    public void testUpdateContactPhone() {
        contactService.addContact(contact);

        contactService.updateContactPhone(contact.getContactID(), "9876543210");
        Contact updatedContact = contactService.getContacts().get(0);
        assertEquals("John", updatedContact.getFirstName());
        assertEquals("Doe", updatedContact.getLastName());
        assertEquals("9876543210", updatedContact.getPhone());
        assertEquals("123 Address Circle", updatedContact.getAddress());

        assertThrows(IllegalArgumentException.class, () -> contactService.updateContactPhone("nonexistentID", "9876543210"));
    }

    @Test
    public void testUpdateContactAddress() {
        contactService.addContact(contact);

        contactService.updateContactAddress(contact.getContactID(), "456 Somewhere Dr");
        Contact updatedContact = contactService.getContacts().get(0);
        assertEquals("John", updatedContact.getFirstName());
        assertEquals("Doe", updatedContact.getLastName());
        assertEquals("1234567890", updatedContact.getPhone());
        assertEquals("456 Somewhere Dr", updatedContact.getAddress());

        assertThrows(IllegalArgumentException.class, () -> contactService.updateContactAddress("nonexistentID", "456 Somewhere Dr"));
    }
}

