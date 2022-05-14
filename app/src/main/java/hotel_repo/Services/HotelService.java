package hotel_repo.Services;

import hotel_repo.Model.Hotel;
import java.util.ArrayList;
import java.io.*;

public class HotelService {

    private static Hotel hotelTimisoara = new Hotel("01", "Hotel Timisoara");
    private static Hotel hotelCluj = new Hotel("02", "Hotel Cluj");
    private static Hotel hotelBrasov = new Hotel("03", "Hotel Brasov");
    private static ArrayList<Hotel> hotels = new ArrayList<Hotel>()
    {{
        add(hotelTimisoara);
        add(hotelCluj);
        add(hotelBrasov);
    }};

    public static String[] test(FileReader reader, BufferedReader br) throws Exception {

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

        FileReader reader = new FileReader("C:\\Users\\Diana\\.registration-example\\storage.txt");
        BufferedReader br = new BufferedReader(reader);
        String x[] = { "", ""};

        x = test(reader, br);
        hotelTimisoara.setAddress(x[0]);
        hotelTimisoara.setDescription(x[1]);

        x = test(reader, br);
        hotelCluj.setAddress(x[0]);
        hotelCluj.setDescription(x[1]);

        x = test(reader, br);
        hotelBrasov.setAddress(x[0]);
        hotelBrasov.setDescription(x[1]);

    }

    public static void storage(String title, String address, String description) throws Exception {

        PrintWriter writer = new PrintWriter("C:\\Users\\Diana\\.registration-example\\storage.txt", "UTF-8");

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

}