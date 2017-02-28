import java.util.Date;

/**
 * Created by Guillaume Gingembre on 28/02/2017.
 */
public class TestRoom {

    public static void main(String[] args) {

        boolean test1, test2;

        Date date1 =  new Date();
        Date date2 = new Date();
        Date date3 = new Date();

        // create three rooms in order to test the equals to method

        Room testRoom1 = new Room(1111, 1000, 2, date1, "VintageBoutique", "Lvov");
        Room testRoom2 = new Room(1112, 2000, 3, date2, "Hotel", "Lvov");
        Room testRoom3 = new Room(1113, 1000, 2, date3, "LvivHotel", "Lvov");

        // test equality for the rooms

        test1 = testRoom1.equals(testRoom2);
        test2 = testRoom1.equals(testRoom3);

        System.out.println(test1 + " this should be false\n" + test2 + " this should be true");

    }





}
