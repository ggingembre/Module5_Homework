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

        // task 5: testing the new methods of the DAO

        // add room
        // why do I need to write this again? Java did not find the already created object
        DAOGoogle DAOGoogleTest = new DAOGoogle();

        Room newRoom = new Room(999,300,2, date1, "Tashkent Inn", "Tashkent" );
        Room[] testRoom10 = DAOGoogleTest.save(newRoom);
        System.out.println(testRoom10[5]);

        // update room - it does not work, and I cannot understand why...

        //System.out.println("The room before updating is: " + testRoom10[5]);
        //Room updateRoom = new Room(1235, 110, 2, date2, "Hostel London", "London");
        //testRoom10 = DAOGoogleTest.update(updateRoom);
        //System.out.println("The room after updating is: " + testRoom10[5]);

        // delete room

        System.out.println("Before deleting, the third room in the Google DB is: " + testRoom10[2]);
        Room testRoom11 = testRoom10[2];
        testRoom10 = DAOGoogleTest.delete(testRoom11);
        System.out.println("After deleting, the third room in the Google DB is: " + testRoom10[2]);

        // find room byID - for some reason it did not find the tashkent room

        Room testRoom12 = DAOGoogleTest.findById(1237);
        if (testRoom12 != null) {
            System.out.println(testRoom12);
        } else{
            System.out.println("There is no such room, please check the room ID");
        }
    }
}