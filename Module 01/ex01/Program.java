
public class Program {

    public static void main(String[] args) {
        User x = new User("null", 500);
        System.err.println(x.getIdentifier());
        User y = new User("me", 0);
        System.err.println(y.getIdentifier());

    }
}
