package database;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.Blog;
import model.Comment;
import model.User;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class Database {
    private List<User> users = new ArrayList<>();
    private List<Blog> blogs = new ArrayList<>();
    private List<Comment> comments = new ArrayList<>();

    private static Database database;


    public static Database getInstance(){
        if (database == null) {
            database = new Database();
        }
        return database;
    }
}
