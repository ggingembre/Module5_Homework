import java.text.ParseException;
import java.util.Arrays;

/**
 * Created by Guillaume Gingembre on 01/03/2017.
 */
public class Controller {

    private static API apis[] = new API[3];

    public Room[] requestRooms(int price, int persons, String city, String hotel) throws ParseException {

        // initiate APIs
        BookingComAPI controlBAPI = new BookingComAPI();
        TripAdvisorAPI controlTAPI = new TripAdvisorAPI();
        GoogleAPI controlGAPI = new GoogleAPI();

        apis[0] = controlBAPI;
        apis[1] = controlTAPI;
        apis[2] = controlGAPI;

        // create array for rooms found
        Room resulta[] = new Room[0];

        // look for rooms
        for (int i = 0; i < apis.length; i++){
                Room resultb [] = apis[i].findRooms(price, persons, city, hotel);
                resulta = concat(resulta,resultb);
        }
        return resulta;
    }


   public Room[] check(API api1, API api2){
            // check rooms that are the same in different arrays and returns an array of results

       Room[] api1Room = api1.getRooms();
       Room[] api2Room = api2.getRooms();
       Room[] result = new Room[0];
       Room newRoom;

        for (int i = 0; i < api1Room.length; i++){
            for (int j = 0; j < api2Room.length; j++){
                    if (api1Room[i] == api2Room[j]) {
                            newRoom = api1Room[i];
                            result = addElementToArray (result, newRoom);
                }
            }
        }

    return result;

   }


    private Room[] concat(Room[] a, Room[] b) {
        int aLen = a.length;
        int bLen = b.length;
        Room[] c= new Room[aLen+bLen];
        System.arraycopy(a, 0, c, 0, aLen);
        System.arraycopy(b, 0, c, aLen, bLen);
        return c;
    }

    // function to add a member to a room array
    private static Room [] addElementToArray (Room[] roomArray, Room newRoom) {

        Room [] newRooms = Arrays.copyOf(roomArray, roomArray.length + 1);
        newRooms [newRooms.length-1] = newRoom;
        return newRooms;
    }
}
