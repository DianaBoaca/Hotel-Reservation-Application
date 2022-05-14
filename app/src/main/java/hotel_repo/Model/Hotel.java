package hotel_repo.Model;

public class Hotel {

    private String ID;
    private String name;
    private String address;
    private String description;

    public Hotel(String ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public Hotel() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() { return address; }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() { return description; }

    public void setDescription(String description) {
        this.description = description;
    }

}
