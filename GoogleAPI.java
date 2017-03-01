import java.text.ParseException;
import java.util.Arrays;

/**
 * Created by Guillaume Gingembre on 01/03/2017.
 */
public class GoogleAPI implements API {

    public GoogleAPI() throws ParseException {
    }

    DAOGoogle DAOGoogleInitiate = new DAOGoogle();
    private Room[] googleRooms = DAOGoogleInitiate.initializeDB();

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel){
        int i;
        Room [] roomArray = new Room[0];
        Room newRoom;

        for (i =0; i < googleRooms.length; i++){
            if (( price == googleRooms[i].getPrice()) && (persons == googleRooms[i].getPersons()) &&
                    (city == googleRooms[i].getCityName()) && hotel == googleRooms[i].getHotelName()){
                newRoom = googleRooms[i];
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
