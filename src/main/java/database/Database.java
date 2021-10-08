package database;

import lombok.Getter;
import lombok.Setter;
import model.Blog;
import model.Comment;
import model.Template;
import model.User;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class Database {
    private List<User> users = new ArrayList<>();
    private List<Blog> blogs = new ArrayList<>();
    private List<Comment> comments = new ArrayList<>();
    private List<Template> templates = new ArrayList<>();
    private static Database database;

    private Database() {
    }

    private Database(List<User> users, List<Blog> blogs, List<Comment> comments, List<Template> templates) {
        this.users = users;
        this.blogs = blogs;
        this.comments = comments;
    }

    public static Database getInstance(List<User> users, List<Blog> blogs, List<Comment> comments, List<Template> templates) {
        if (database == null) {
            database = new Database(users, blogs, comments, templates);
        }
        return database;
    }

    public static Database getInstance() {
        if (database == null) {
            database = new Database();
        }
        return database;
    }
}
