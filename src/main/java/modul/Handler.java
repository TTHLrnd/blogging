package modul;

import database.Database;
import lombok.Getter;
import lombok.Setter;
import model.User;
import model.UserRoles;
import utils.Utils;

public class Handler {
    @Getter
    @Setter
    static User currentUser;

    public static void run(){
        System.out.println("Registration - 1");
        System.out.println("Login - 2");
        System.out.println("Browse blogs - 3");
        System.out.println("My blogs - 4");
        System.out.println("Profile - 5");
        int input = Utils.sc().nextInt();
        switch (input){
            case 1 :
                UserHandler.registerUser();
                break;
            case 2 :
                UserHandler.loginUser();
                break;
            case 3 :
                BlogHandler.readBlog(currentUser,Database.getInstance().getBlogs());
                break;
            case 4 :
                SearchEngine.listUserBlogs(currentUser);
                break;
            case 5 :
                if (!currentUser.getRole().equals(UserRoles.admin)) {
                    UserHandler.editUser(currentUser);
                } else {
                    System.out.println("User id: ");
                    UserHandler.editUser(SearchEngine.searchUser(Utils.sc().nextLong(), Database.getInstance().getUsers()).get(0));
                }
                break;
            default:
                Handler.run();
        }
        Handler.run();
    }
}
