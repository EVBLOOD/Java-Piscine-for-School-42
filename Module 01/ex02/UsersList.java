
public interface UsersList {

    public void addUser(String Name, int Balance);

    public User retrieveUserById(int id) throws Exception;

    public User retrieveUserByIndex(int index) throws Exception;

    public int retrieveUsersNumber();

}