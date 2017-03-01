/**
 * Created by Guillaume Gingembre on 01/03/2017.
 */
public interface DAO {

    // I do not understand why they are of type room,  some should be of different types

    static Room[] initializeDB(){return null;} // creates our DB (array) in each DAO implementation; I cannot make it static if I do not make it here
    Room[] save(Room room); // it adds a room to the DB, it returns the updated DB
    Room[] delete(Room room); // it deletes a room from the DB, it returns the updated DB
    Room[] update(Room room); // it updates a room in the DB, it returns the updated DB
    Room findById(long id);
}
