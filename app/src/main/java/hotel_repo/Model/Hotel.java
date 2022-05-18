package hotel_repo.Model;

import java.util.ArrayList;

public class Hotel {

    private String ID;
    private String name;
    private String address;
    private String description;
    private int Room_number;
    private ArrayList<String> Dates = new ArrayList<String>();
    private  ArrayList<Integer> Dates_count = new ArrayList<Integer>();

    public Hotel(String ID, String name, int Room_number) {
        this.ID = ID;
        this.name = name;
        this.Room_number=Room_number;
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

    public int getRoom_number() {
        return Room_number;
    }

    public void setRoom_number(int room_number) {
        Room_number = room_number;
    }

    public ArrayList<String> getDates() {
        return Dates;
    }

    public void setDates(ArrayList<String> dates) {
        Dates = dates;
    }

    public ArrayList<Integer> getDates_count() {
        return Dates_count;
    }

    public void setDates_count(ArrayList<Integer> dates_count) {
        Dates_count = dates_count;
    }
}
