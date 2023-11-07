
public class Program {

    public static void main(String[] args) {
        // User x = new User("null", 500);
        // System.err.println(x.getIdentifier());
        // User y = new User("me", 0);
        // System.err.println(y.getIdentifier());
        UsersArrayList all = new UsersArrayList();
        all.addUser("saad", 0);
        all.addUser("saad1", 0);
        all.addUser("saad2", 0);
        all.addUser("saad3", 0);
        all.addUser("saad4", 0);
        try {
            all.retrieveUserById(11); // throwing
        } catch (Exception err) {
            System.err.println("all.retrieveUserById(11)");
            System.err.println(err.toString());
        }

        try {
            User x = all.retrieveUserById(1); // won't throw
            System.err.printf("id: %d, name %s%n", x.Identifier, x.Name);
        } catch (Exception err) {
            System.err.println(err.toString());
        }

        try {
            User x = all.retrieveUserByIndex(1); // won't throw
            System.err.printf("id: %d, name %s%n", x.Identifier, x.Name);
        } catch (Exception err) {
            System.err.println(err.toString());
        }

        try {
            all.retrieveUserByIndex(100); // throwing
        } catch (Exception err) {
            System.err.println("all.retrieveUserByIndex(100)");
            System.err.println(err.toString());
        }

    }
}
