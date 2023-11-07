public final class UserIdsGenerator {
    private static UserIdsGenerator INSTANCE;
    private int id = 0;

    private UserIdsGenerator() {
    }

    public static UserIdsGenerator getInstance() {
        if (INSTANCE == null)
            INSTANCE = new UserIdsGenerator();
        return INSTANCE;
    }

    public int generateId() {
        return id++;
    }
}
