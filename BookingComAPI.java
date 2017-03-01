import java.util.Date;
import java.util.Arrays;

/**
 * Created by Guillaume Gingembre on 01/03/2017.
 */
public class BookingComAPI implements API {

    // Every implementation has global variable Room[] rooms which must be initialized in empty constructor with 5 differentRooms.

    private static Room[] rooms =  new Room[5];

    public BookingComAPI() {   // empty constructor

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
    }

    // the implementation of the API should implement the method findRooms:

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel){
        int i;
        Room [] roomArray = new Room[0];
        Room newRoom;

        for (i =0; i < rooms.length; i++){
           if (( price == rooms[i].getPrice()) && (persons == rooms[i].getPersons()) &&
                   (city == rooms[i].getCityName()) && hotel == rooms[i].getHotelName()){
               newRoom = rooms[i];
               roomArray = addElementToArray (roomArray, newRoom);
           }
        }
            return roomArray;
    }

    // function to add a member to a room array
    private static Room [] addElementToArray (Room[] roomArray, Room newRoom) {

        Room [] newRooms = Arrays.copyOf(roomArray, roomArray.length + 1);
        newRooms [newRooms.length-1] = newRoom;
        return newRooms;
    }

}