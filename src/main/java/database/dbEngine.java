package database;

import model.Blog;
import model.Comment;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class dbEngine {
    private Connection connection;

    public dbEngine() {
        connection = connect();
    }

    public boolean isConnected() {
        return (connection != null);
    }

    private Connection connect() {
        String url = "jdbc:mysql://localhost:3306/blogDatabase" +
                "?" +
                "useUnicode = yes" +
                "&" +
                "characterEncoding = UTF-8";

        Properties pr = new Properties();
        pr.put("user", System.getenv("USERNAME"));
        pr.put("password", System.getenv("PASSWORD"));

        try {
            return DriverManager.getConnection(url, pr);
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("error");
            return null;
        }


    }

    public void loadAllData() {
        Database.getInstance(getAuthorsFromDB(), getBlogsFromDB(), getCommentsFromDB());
        linkAuthorsToBlogs();
        linkCommentsToBlogs();
    }

    private void linkAuthorsToBlogs() {
        for (User user : Database.getInstance().getUsers()) {
            user.setBlogs(getUsersBlogs(user.getId()));
        }
    }

    private List<Blog> getUsersBlogs(long userId) {
        List<Blog> temp = new ArrayList<>();
        for (Blog blog : Database.getInstance().getBlogs()) {
            if (blog.getAuthorId() == userId) {
                temp.add(blog);
            }
        }
        return temp;
    }

    private void linkCommentsToBlogs() {
        for (Blog blog : Database.getInstance().getBlogs()) {
            blog.setComments(getBlogComments(blog.getId()));
        }
    }

    private List<Comment> getBlogComments(long blogId) {
        List<Comment> temp = new ArrayList<>();
        for (Comment comment : Database.getInstance().getComments()) {
            if (comment.getBlogId() == blogId) {
                temp.add(comment);
            }
        }
        return temp;
    }

    public List<User> getAuthorsFromDB() {
        String query = "SELECT * FROM authors;";

        List<User> temp = new ArrayList<>();

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()) {
                long id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                Timestamp regDate = resultSet.getTimestamp("regdate");
                String role = resultSet.getString("role");
                temp.add(new User(
                        id,
                        username,
                        email,
                        password,
                        regDate,
                        role

                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error");
            return null;
        }
        return temp;
    }

    public List<Blog> getBlogsFromDB() {
        String query = "SELECT * FROM blogs;";

        List<Blog> temp = new ArrayList<>();

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()) {
                long id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String content = resultSet.getString("content");
                long authorId = resultSet.getInt("authorid");
                Timestamp pubDate = resultSet.getTimestamp("pubdate");
                temp.add(new Blog(
                        id,
                        title,
                        content,
                        authorId,
                        pubDate
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error");
            return null;
        }
        return temp;
    }

    public List<Comment> getCommentsFromDB() {
        String query = "SELECT * FROM comments;";

        List<Comment> temp = new ArrayList<>();

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()) {
                long id = resultSet.getInt("id");
                Timestamp pubDate = resultSet.getTimestamp("pubdate");
                long blogId = resultSet.getInt("blogid");
                long authorId = resultSet.getInt("authorid");
                String comment = resultSet.getString("comment");
                temp.add(new Comment(
                        id,
                        pubDate,
                        blogId,
                        authorId,
                        comment
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error");
            return null;
        }
        return temp;
    }


}
