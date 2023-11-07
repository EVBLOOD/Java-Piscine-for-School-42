
public class UsersArrayList implements UsersList {
    int size;
    User[] Users;

    public UsersArrayList() {
        size = 0;
        Users = new User[10];
    }

    public void addUser(String Name, int Balance) {
        if (Users.length == size) {
            int Capacity = Users.length + Users.length / 2;
            User[] tmpUsers = new User[Capacity];
            for (int i = 0; i < Users.length; i++) {
                tmpUsers[i] = Users[i];
            }
            Users = tmpUsers;
        }
        Users[size++] = new User(Name, Balance);
    }

    public User retrieveUserById(int id) throws Exception {
        for (int i = 0; Users[i] != null; i++) {
            if (Users[i].getIdentifier() == id)
                return Users[i];
        }
        throw new Exception("UserNotFoundException");
    }

    public User retrieveUserByIndex(int index) throws Exception {
        if (index >= size)
            throw new Exception("UserNotFoundException");
        return Users[index];
    }

    public int retrieveUsersNumber() {
        return size;
    }

}
