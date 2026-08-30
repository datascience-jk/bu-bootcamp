public class Contact {
    //Fields
    private String name;
    private String phone;

    //Constructor
    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    //Getters
    public String getName() { return name; }
    public String getPhone() { return phone; }


    //To String
    public String toString() {
        return name + " | " + phone; 
    }

}
