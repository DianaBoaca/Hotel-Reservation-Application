package hotel_repo.Services;

import hotel_repo.Services.FileSystemService;
import hotel_repo.Model.Hotel;
import java.util.ArrayList;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.*;

public class HotelService {

    private static Hotel hotelTimisoara = new Hotel("01", "Hotel Timisoara", 15);
    private static Hotel hotelCluj = new Hotel("02", "Hotel Cluj", 15);
    private static Hotel hotelBrasov = new Hotel("03", "Hotel Brasov", 15);
    private static ArrayList<Hotel> hotels = new ArrayList<Hotel>()
    {{
        add(hotelTimisoara);
        add(hotelCluj);
        add(hotelBrasov);
    }};

    public static String[] text(FileReader reader, BufferedReader br) throws Exception {

        int readedValue;
        int ok = 0;
        String address = "", description = "";

        for(;;) {

            readedValue = reader.read();
            char ch = (char) readedValue;

            if (ch == '#' && ok == 0)
            {
                ok = 1;
                continue;
            }

            if (ch == '#' && ok == 1)
                break;

            if (ok == 1)
                description += ch;
            else
                address += ch;

        }

        String x[] = {address, description};
        return x;

    }

    public static ArrayList<Hotel> getHotels() {
        return hotels;
    }

    public static void setHotels() throws Exception {

        Path pathFile = Paths.get(System.getProperty("user.home"), ".registration-example");
        File yourFile = new File(pathFile + "\\storage.txt");
        boolean exist = yourFile.exists();

        if (exist == false)
        {
            yourFile.createNewFile();
            PrintWriter writer = new PrintWriter(pathFile + "\\storage.txt", "UTF-8");
            writer.print("######");
            writer.close();
        }

        FileReader reader = new FileReader(pathFile + "\\storage.txt");
        BufferedReader br = new BufferedReader(reader);
        String x[] = { "", ""};

        x = text(reader, br);
        hotelTimisoara.setAddress(x[0]);
        hotelTimisoara.setDescription(x[1]);

        x = text(reader, br);
        hotelCluj.setAddress(x[0]);
        hotelCluj.setDescription(x[1]);

        x = text(reader, br);
        hotelBrasov.setAddress(x[0]);
        hotelBrasov.setDescription(x[1]);

    }

    public static void storage(String title, String address, String description) throws Exception {

        Path pathFile = Paths.get(System.getProperty("user.home"), ".registration-example");
        PrintWriter writer = new PrintWriter(pathFile + "\\storage.txt", "UTF-8");

        for (Hotel h : hotels) {

            if((h.getName()).equals(title)) {
                h.setAddress(address);
                h.setDescription(description);
            }

            writer.print(h.getAddress());
            writer.print("#");
            writer.print(h.getDescription());
            writer.print("#");

        }

        writer.close();

    }

    public static int getRoom_NumberbyID(String ID){
        if(ID.equals(hotelTimisoara.getID()))
            return hotelTimisoara.getRoom_number();

        if(ID.equals(hotelCluj.getID()))
            return hotelCluj.getRoom_number();

        if(ID.equals(hotelBrasov.getID()))
            return hotelBrasov.getRoom_number();
        return 0;
    }

    public static Hotel getHotelbyID(String ID){
        if(ID.equals(hotelTimisoara.getID()))
            return hotelTimisoara;

        if(ID.equals(hotelCluj.getID()))
            return hotelCluj;

        if(ID.equals(hotelBrasov.getID()))
            return hotelBrasov;
        return null;
    }

}