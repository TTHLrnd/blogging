import database.dbEngine;

public class blogApplication {
    public static void main(String[] args) {
        dbEngine dbEngine = new dbEngine();
        System.out.println(dbEngine.isConnected());
    }
}
