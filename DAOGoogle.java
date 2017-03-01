import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by Guillaume Gingembre on 01/03/2017.
 */
public class DAOGoogle implements DAO {

    private static Room[] rooms =  new Room[5];

    public static Room[] initializeDB() throws ParseException {
        // creating 5 rooms by default, first create dates and then rooms

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy");
        String strDate1 = "02-04-2017";
        String strDate2 = "01-03-2017";
        String strDate3 = "28-02-2017";
        String strDate4 = "03-03-2017";

        Date date1 = dateFormat.parse(strDate1);
        Date date2 = dateFormat.parse(strDate2);
        Date date3 = dateFormat.parse(strDate3);
        Date date4 = dateFormat.parse(strDate4);
        Date date5 = new Date();

        rooms[0] = new Room(1234,1000,4, date1,"Crillon","Paris");
        rooms[1] = new Room(1235,100,2, date2,"Hostel Oxford","London");
        rooms[2] = new Room(1236,300,2, date3,"Rus","Kiev");
        rooms[3] = new Room(1237,500,2, date4,"Ukraina","Kiev");
        rooms[4] = new Room(1238,200,2, date5,"Tourist Inn","Kiev");

        return rooms;
    }

    public Room[] save(Room newRoom) {

        // add room to array and return the new array
        Room [] newRooms = Arrays.copyOf(rooms, rooms.length + 1);
        newRooms [newRooms.length-1] = newRoom;
        return newRooms;
    }

    public Room[] delete(Room room){
        for (int i = 0; i < rooms.length; i++)
        {
            if (rooms[i] == room)
            {
                Room[] copy = new Room[rooms.length-1];
                System.arraycopy(rooms, 0, copy, 0, i);
                System.arraycopy(rooms, i+1, copy, i, rooms.length-i-1);
                return copy;
            }
        }
        return rooms;
    }

    public Room[] update(Room room){
        for (int i = 0; i < rooms.length; i++)
        {
            if (rooms[i].getId() == room.getId())
            {
                rooms[i].setCityName(room.getCityName());
                rooms[i].setHotelName(room.getHotelName());
                rooms[i].setPrice(room.getPrice());
                rooms[i].setPersons(room.getPersons());
                rooms[i].setDateAvailableFrom(room.getDateAvailableFrom());
            }
        }
        return rooms;
    }

    public Room findById(long id) {

        for (Room room : rooms) {
            if (room!=null && room.getId() == id ){
                return room;
            }
        }

        return null;
    }
}