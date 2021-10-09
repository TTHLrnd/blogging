package modul;

import model.*;
import utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    public static List<User> searchUser(String search, List<User> users) {
        List<User> res = new ArrayList<>();
        if (search == null || search.equals("")) {
            System.out.println("Search field is empty!");
            return users;
        }
        for (User user : users) {
            if (search.equals(user.getUsername())) {
                res.add(user);
            }

        }
        return res;
    }

    public static List<User> searchUser(long searchId, List<User> users) {
        List<User> res = new ArrayList<>();
        for (User user : users) {
            if (searchId == user.getId()) {
                res.add(user);
            }

        }
        return res;
    }

    public static List<User> searchByRoleGroup(UserRoles search, List<User> users) {
        if (search == null) {
            System.out.println("Search field is empty!");
            return users;
        }
        List<User> res = new ArrayList<>();
        for (User user : users) {
            if (search.equals(user.getRole())) {
                res.add(user);
                Utils.showUserData(user);
            }

        }
        return res;
    }

    public static List<Blog> listUserBlogs(User user){
        if (user == null || user.getBlogs() == null) {
            System.out.println("No user or blogs to be listed");
            return null;
        }
        for (Blog blog : user.getBlogs()){
            System.out.println(blog.getTitle());
        }
        return user.getBlogs();
    }

    public static List<Blog> searchInBlogs(String title, List<Blog> blogs) {
        if (title == null || title.equals("")) {
            System.out.println("Search field is empty!");
            return blogs;
        }
        List<Blog> res = new ArrayList<>();
        for (Blog blog : blogs){
            if (blog.getTitle().contains(title)){
                res.add(blog);
            }
        }
        return res;
    }

    public static List<Comment> searchInComments(String commentSearch, List<Comment> comments) {
        if (commentSearch == null || commentSearch.equals("")) {
            System.out.println("Search field is empty!");
            return comments;
        }
        List<Comment> res = new ArrayList<>();
        for (Comment comment : comments){
            if (comment.getComment().contains(commentSearch)){
                res.add(comment);
            }
        }
        return res;
    }

    public static List<Blog> getBlogByCategory(Categories category, List<Blog> blogs) {
        if (category == null) {
            System.out.println("Wrong input!");
            return blogs;
        }
        List<Blog> res = new ArrayList<>();
        for (Blog blog: blogs){
            if (blog.getCategory().equals(category)){
                res.add(blog);
            }
        }
        return res;
    }

    public static List<Comment> getCommentsFromBlog(Blog blog) {
        return blog.getComments();
    }
}
