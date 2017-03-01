import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by Guillaume Gingembre on 01/03/2017.
 */
public class DAOBookingCom implements DAO {

    private static Room[] rooms =  new Room[5];

    public static Room[] initializeDB(){
        // creating 5 rooms by default, first create dates and then rooms

        Date date4 =  new Date();
        Date date5 = new Date();
        Date date6 = new Date();
        Date date7 = new Date();
        Date date8 = new Date();

        rooms[0] = new Room(123,1000,4, date4,"Sofitel","Paris");
        rooms[1] = new Room(124,100,2, date5,"Hostel Cheap","London");
        rooms[2] = new Room(125,500,2, date6,"11 Mirrors","Kiev");
        rooms[3] = new Room(126,1000,2, date7,"Hyatt","Kiev");
        rooms[4] = new Room(127,900,2, date8,"Hilton","Kiev");

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
                rooms[i] = room ;
            }
        }
        return rooms;
    }

    public Room findById(long id){
        Room room;
        room = null;

        for (int i = 0; i < rooms.length; i++)
        {
            if (rooms[i].getId() == id)
            {
                room = rooms[i];
            }
        }
        return room;
    }
}