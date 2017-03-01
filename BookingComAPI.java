import java.util.Date;
import java.util.Arrays;

/**
 * Created by Guillaume Gingembre on 01/03/2017.
 */
public class BookingComAPI implements API {

    DAOBookingCom DAOBookingInitiate = new DAOBookingCom();
    private Room[] bookingComRooms = DAOBookingInitiate.initializeDB();

    // the implementation of the API should implement the method findRooms:

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel){
        int i;
        Room [] roomArray = new Room[0];
        Room newRoom;

        for (i =0; i < bookingComRooms.length; i++){
           if (( price == bookingComRooms[i].getPrice()) && (persons == bookingComRooms[i].getPersons()) &&
                   (city == bookingComRooms[i].getCityName()) && hotel == bookingComRooms[i].getHotelName()){
               newRoom = bookingComRooms[i];
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