import java.text.ParseException;
import java.util.Arrays;

/**
 * Created by Guillaume Gingembre on 01/03/2017.
 */
public class TripAdvisorAPI implements API {

    public TripAdvisorAPI() throws ParseException {
    }

    DAOTripAdvisor DAOTAInitiate = new DAOTripAdvisor();
    private Room[] TARooms = DAOTAInitiate.initializeDB();

    // the implementation of the API should implement the method findRooms:

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel){
            int i;
            Room [] roomArray = new Room[0];
            Room newRoom;

            for (i =0; i < TARooms.length; i++){
                if (( price == TARooms[i].getPrice()) && (persons == TARooms[i].getPersons()) &&
                        (city == TARooms[i].getCityName()) && hotel == TARooms[i].getHotelName()){
                    newRoom = TARooms[i];
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

    public Room[] getRooms() {
        return TARooms;
    }
}