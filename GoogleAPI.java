import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by Guillaume Gingembre on 01/03/2017.
 */
public class GoogleAPI implements API {

    // Every implementation has global variable Room[] rooms which must be initialized in empty constructor with 5 differentRooms.

    private static Room[] rooms =  new Room[5];

    public GoogleAPI() throws ParseException {   // empty constructor

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

        rooms[0] = new Room(123,1000,4, date1,"Crillon","Paris");
        rooms[1] = new Room(124,100,2, date2,"Hostel Oxford","London");
        rooms[2] = new Room(125,300,2, date3,"Rus","Kiev");
        rooms[3] = new Room(126,500,2, date4,"Ukraina","Kiev");
        rooms[4] = new Room(127,200,2, date5,"Tourist Inn","Kiev");
    }

    // the implementation of the API should implement the method findRooms:


// this duplicates code in other APIs, can I do something?

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
