import database.Database;
import database.dbEngine;
import model.Blog;
import model.Comment;
import model.User;

public class blogApplication {
    public static void main(String[] args) {
        dbEngine dbEngine = new dbEngine();
        System.out.println(dbEngine.isConnected());

        dbEngine.loadAllData();

        for (User user : Database.getInstance().getUsers()) {
            System.out.println(user.getUsername());
        }

        for (Blog blog : Database.getInstance().getBlogs()) {
            System.out.println(blog.getTitle());
        }

        for (Comment comment : Database.getInstance().getComments()) {
            System.out.println(comment.getId());
        }
    }
}
