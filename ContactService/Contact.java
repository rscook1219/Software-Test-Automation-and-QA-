package contact_Service;

public class Contact {
    private String contactID;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    public Contact(String contactID, String firstName, String lastName, String phone, String address) {
        if (contactID == null || contactID.length() > 10) {
            throw new IllegalArgumentException("Contact ID must not be null and cannot exceed 10 characters");
        }

        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First Name must not be null and cannot exceed 10 characters");
        }

        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last Name must not be null and cannot exceed 10 characters");
        }

        if (phone == null || phone.length() != 10) {
            throw new IllegalArgumentException("Phone must not be null and must be exactly 10 digits");
        }

        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address must not be null and cannot exceed 30 characters");
        }

        this.contactID = contactID;
        this.firstName = firstName;
        this.lastName = lastName;
        setPhone(phone); // Use the setter to validate and set the phone
        this.address = address;
    }

    public String getContactID() {
        return contactID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First Name must not be null and cannot exceed 10 characters");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last Name must not be null and cannot exceed 10 characters");
        }
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        if (phone == null || phone.length() != 10) {
            throw new IllegalArgumentException("Phone must not be null and must be exactly 10 digits");
        }
        this.phone = phone;
    }

    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address must not be null and cannot exceed 30 characters");
        }
        this.address = address;
    }
}
