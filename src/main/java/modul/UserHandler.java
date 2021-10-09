package modul;

import database.Database;
import model.User;
import model.UserRoles;
import utils.Utils;

public class UserHandler extends Handler {


    /**
     *     private long id;
     *     private String username;
     *     private String email;
     *     private String password;
     *     private Timestamp regDate;
     *     private UserRoles role;
     *     private List<Blog> blogs = new ArrayList<>();
     */

    public static void registerUser(){
        System.out.println("----Registration----");
        System.out.println("Username: ");
        String username = Utils.sc().nextLine();
        System.out.println("Email: ");
        String email = Utils.sc().nextLine();
        System.out.println("Password: ");
        String password = Utils.sc().nextLine();

        User temp = new User(username, email, password);
        Database.getInstance().getUsers().add(temp);
    }

    public static void loginUser(){
        System.out.println("----Login----");
        System.out.println("Username: ");
        String username = Utils.sc().nextLine();
        System.out.println("Password: ");
        String password = Utils.sc().nextLine();

        setCurrentUser(getUser(username, password));
    }

    private static User getUser(String username, String password){
        if (!Database.getInstance().getUsers().isEmpty()) {
            User temp = SearchEngine.searchUser(username, Database.getInstance().getUsers()).get(0);
            if (temp.getPassword().equals(password)) {
                System.out.println("Logged in!");
                return temp;
            } else {
                System.out.println("Wrong password or username!");
            }
        }
        System.out.println("An error occurred!");
        return null;
    }

    public static void editUser(User user){
        if (user.equals(currentUser)) {
            Utils.showUserData(user);
            System.out.println("Edit username: ");
            String editUsername = Utils.sc().nextLine();
            System.out.println("Edit email: ");
            String editEmail = Utils.sc().nextLine();
            System.out.println("Edit password: ");
            String editPassword = Utils.sc().nextLine();
            String editRole = "";
            if (RoleHandler.getUserRole(currentUser).isEditUser()) {
                System.out.println("Edit role(user, mod, admin): ");
                editRole = Utils.sc().nextLine();
            }
            editData(editUsername, editEmail, editPassword, editRole, user);
        }

    }

    private static void editData(String username, String email, String password, String role, User user){
        if (!username.equals("")){
            user.setUsername(username);
        }
        if (!email.equals("")){
            user.setEmail(email);
        }
        if (!password.equals("")){
            user.setPassword(password);
        }
        if (!role.equals("")){
            user.setRole(UserRoles.valueOf("role"));
        }
    }
}
