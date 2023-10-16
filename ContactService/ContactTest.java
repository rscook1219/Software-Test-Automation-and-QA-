package contact_Service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test; 


class ContactTest {
	
	@Test
	public void testValidContactCreation() {
		Contact contact = new Contact("12345","John","Doe", "1234567890","123 Address Cir");
		assertNotNull(contact);
	}
	
	@Test
	public void testInvalidContactID_Null() {
		assertThrows(IllegalArgumentException.class, () -> new Contact(null,"John","Doe", "1234567890","123 Address Cir"));
	}
	
	@Test
	public void testInvalidContactID_LongerThan10Characters() {
		assertThrows(IllegalArgumentException.class, () -> new Contact("12345678901","John","Doe", "1234567890","123 Address Cir"));
	}
	
	@Test
	public void testInvalidFirstName_Null() {
		assertThrows(IllegalArgumentException.class, () -> new Contact("12345",null,"Doe", "1234567890","123 Address Cir"));
	}
	
	@Test
	public void testInvalidLastName_Null() {
		assertThrows(IllegalArgumentException.class, () -> new Contact("12345","John",null, "1234567890","123 Address Cir"));
	}
	
	@Test
	public void testInvalidPhone_Null() {
		assertThrows(IllegalArgumentException.class, () -> new Contact("12345","John","Doe",null,"123 Address Cir"));
	}
	
	@Test
	public void testInvalidPhone_NotExactly10Digits() {
		assertThrows(IllegalArgumentException.class, () -> new Contact("12345","John","Doe", "12345","123 Address Cir"));
	}
	
	@Test
	public void testInvalidAddress_Null() {
		assertThrows(IllegalArgumentException.class, () -> new Contact("12345","John","Doe", "1234567890",null));
	}
	
	@Test
	public void testInvalidAddress_LongerThan30Characters() {
		assertThrows(IllegalArgumentException.class, () -> new Contact("12345","John","Doe", "1234567890","123456789012345 Address Somewhere"));
	}
}
	

