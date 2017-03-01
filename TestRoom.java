import java.text.*;
import java.util.Date;

/**
 * Created by Guillaume Gingembre on 28/02/2017.
 */
public class TestRoom {

    public static void main(String[] args) throws ParseException {


        // task 2 : test equal method

        boolean test1, test2;

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy");
        String strDate1 = "02-04-2017";
        String strDate2 = "01-03-2017";
        String strDate3 = "28-02-2017";

        Date date1 = dateFormat.parse(strDate1);
        Date date2 = dateFormat.parse(strDate2);
        Date date3 = dateFormat.parse(strDate3);

        // create three rooms in order to test the equals to method

        Room testRoom1 = new Room(1111, 1000, 2, date1, "VintageBoutique", "Lvov");
        Room testRoom2 = new Room(1112, 2000, 3, date2, "Hotel", "Lvov");
        Room testRoom3 = new Room(1113, 1000, 2, date3, "LvivHotel", "Lvov");

        // test equality for the rooms

        test1 = testRoom1.equals(testRoom2);
        test2 = testRoom1.equals(testRoom3);

        System.out.println(test1 + " this should be false\n" + test2 + " this should be true");

        // task 3 and 4: test APIs and see if they find a room as they should

        // BookingComAPI
        BookingComAPI testBookingAPI = new BookingComAPI();

        // this should find a room
        Room [] testRoom4 = testBookingAPI.findRooms(1000,2,"Kiev","Hyatt");

        if (testRoom4.length == 0){
            System.out.println("Your search returned no result");
        } else {
            for (int i = 0; i < testRoom4.length; i++ ){
                System.out.println(testRoom4[i]);
            }

        }

        // this should say this room does not exist
        Room [] testRoom5 = testBookingAPI.findRooms(1000,1,"Kiev","Hyatt");
        if (testRoom5.length == 0){
            System.out.println("Your search returned no result");
        } else {
            for (int i = 0; i < testRoom5.length; i++ ){
                System.out.println(testRoom5[i]);
            }

        }

        // question : is there a way to put this "print logic" somewhere else, so that I do not have to repeat it each time?
        // I guess for now it would have been easier to have a "void" findRoom function that prints results...

        TripAdvisorAPI testTripAdvisorAPI = new TripAdvisorAPI();

        // this should find a room
        Room [] testRoom6 = testTripAdvisorAPI.findRooms(1000,2,"Kiev","Intercontinental");

        if (testRoom6.length == 0){
            System.out.println("Your search returned no result");
        } else {
            for (int i = 0; i < testRoom6.length; i++ ){
                System.out.println(testRoom6[i]);
            }

        }

        // this should say this room does not exist
        Room [] testRoom7 = testTripAdvisorAPI.findRooms(1000,2,"Kiev","Hyatt");
        if (testRoom7.length == 0){
            System.out.println("Your search returned no result");
        } else {
            for (int i = 0; i < testRoom7.length; i++ ){
                System.out.println(testRoom7[i]);
            }

        }

        // question : is there a way to put this "print logic" somewhere else, so that I do not have to repeat it each time?
        // I guess for now it would have been easier to have a "void" findRoom function that prints results...

        GoogleAPI testGoogleAPI = new GoogleAPI();

        // this should find a room
        Room [] testRoom8 = testGoogleAPI.findRooms(1000,4,"Paris","Crillon");

        if (testRoom8.length == 0){
            System.out.println("Your search returned no result");
        } else {
            for (int i = 0; i < testRoom8.length; i++ ){
                System.out.println(testRoom8[i]);
            }

        }

        // this should say this room does not exist
        Room [] testRoom9 = testGoogleAPI.findRooms(1000,2,"Paris","Hyatt");
        if (testRoom9.length == 0){
            System.out.println("Your search returned no result");
        } else {
            for (int i = 0; i < testRoom9.length; i++ ){
                System.out.println(testRoom9[i]);
            }

        }

        // question : is there a way to put this "print logic" somewhere else, so that I do not have to repeat it each time?
        // I guess for now it would have been easier to have a "void" findRoom function that prints results...

    }
}
