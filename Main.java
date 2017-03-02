import java.text.ParseException;

/**
 * Created by Guillaume Gingembre on 02/03/2017.
 */
public class Main {
    public Main() throws ParseException {
    }

    public static void main(String[] args) throws ParseException {

        /* В методе класса Main создайте Controller и сделайте 3 запроса с разными параметрами, чтобы найти номера.
Также проверьте все методы 3 раза с разными API, чтобы продемонстрировать, как работает программа. */

        Controller mainController = new Controller();

        /*
        Booking Room(123,1000,4, date4,"Sofitel","Paris");
        Google Room(1237,500,2, date4,"Ukraina","Kiev")
        TA Room(16,900,2, date5,"Premier Inn","Kiev");
        */

        Room[] bookingRoom = mainController.requestRooms(1000,4,"Paris","Sofitel");
        if (bookingRoom.length == 0){
            System.out.println("We did not find such a room with our partners. Please modify your search criteria.");
        }else{
        for (int i = 0; i < bookingRoom.length; i++)
            System.out.println(bookingRoom[i] + ". This room is brought to you by BookingCom");}

        Room[] googleRoom = mainController.requestRooms(500,2,"Kiev","Ukraina");
        if (googleRoom.length == 0){
            System.out.println("We did not find such a room with our partners. Please modify your search criteria.");
        }else{
        for (int i = 0; i < googleRoom.length; i++)
            System.out.println(googleRoom[i] + ". This room is brought to you by Google");}

        Room[] taRoom = mainController.requestRooms(900,2,"Kiev","Premier Inn");
        if (taRoom.length == 0){
            System.out.println("We did not find such a room with our partners. Please modify your search criteria.");
        }else{
        for (int i = 0; i < taRoom.length; i++)
            System.out.println(taRoom[i] + ". This room is brought to you by TripAdvisor");}

        Room[] dreamRoom = mainController.requestRooms(1,2,"Kiev","Hyatt");
        if (dreamRoom.length == 0){
            System.out.println("We did not find such a room with our partners. Please modify your search criteria.");
        }else{
            for (int i = 0; i < dreamRoom.length; i++)
                System.out.println(dreamRoom[i] + ". This room is brought to you by Dream");}


        // question: what can I do so that I do not have to write in the main method the print logic for room arrays?
        // there is a print logic for room in the room class, for not for room arrays...

    /* find, add, delete, findbyID methods tested in previous tasks (in class TestRoom). Update room does not work. I need
     * to test the api check method of the controller class
     * in order to do that, I will change one room in the BookingComDAO to make it equal to one room in Google.
     * All other rooms are different. The comparison of booking and google should return one room,
     * the comparison of booking and TripAdvisor should return no room
     * */

        API apiBooking = new BookingComAPI();
        API apiGoogle = new GoogleAPI();
        API apiTrip = new TripAdvisorAPI();

        Room[] apiCheckTrue = mainController.check(apiBooking,apiGoogle);
        if (apiCheckTrue.length == 0){
            System.out.println("There is no common room between these two providers.");
        }else{
            for (int i = 0; i < apiCheckTrue.length; i++)
                System.out.println(apiCheckTrue[i] + ". This room is proposed by both Booking and Google");}

        Room[] apiCheckFalse1 = mainController.check(apiBooking,apiTrip);
        if (apiCheckFalse1.length == 0){
            System.out.println("There is no common room between these two providers.");
        }else{
            for (int i = 0; i < apiCheckFalse1.length; i++)
                System.out.println(apiCheckFalse1[i] + ". This room is proposed by both Booking and TripAdvisor");}

        Room[] apiCheckFalse2 = mainController.check(apiGoogle,apiTrip);
        if (apiCheckFalse2.length == 0){
            System.out.println("There is no common room between these two providers.");
        }else{
            for (int i = 0; i < apiCheckFalse2.length; i++)
                System.out.println(apiCheckFalse2[i] + ". This room is proposed by both TripAdvisor and Google");}

                /*
        Room[] apiBookingRoom = apiBooking.getRooms();
        Room[] apiGoogleRoom = apiGoogle.getRooms();

        for (int i = 0; i < apiBookingRoom.length;i++){
            System.out.println(apiBookingRoom[i]);
            System.out.println(apiBookingRoom[i].equals(apiGoogleRoom[i]));
        }
*/


    }
}
