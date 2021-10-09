package utils;

import database.Database;
import model.Blog;
import model.User;
import modul.SearchEngine;

import java.util.List;
import java.util.Scanner;

public class Utils {
    public static Scanner sc(){
        return new Scanner(System.in);
    }

    public static void showUserData(User user){
        System.out.println("Username: " + user.getUsername());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Password: " +user.getPassword());
        System.out.println("User ID: " +user.getId());
        System.out.println("Registration date: " +user.getRegDate());
        System.out.println("Role: " +user.getRole());
        System.out.println("Blogs name: ");
        for (Blog blog:  user.getBlogs()){
            System.out.println(blog.getTitle());
        }
    }

    public static void showBlog(Blog blog){
        System.out.println(blog.getTitle());
        System.out.println("Published " + blog.getPubDate());
        System.out.println(blog.getContent());
        //TODO show comments
        System.out.println("Author " + SearchEngine.searchUser(blog.getAuthorId(), Database.getInstance()
                .getUsers()).get(0).getUsername());
    }

    public static void showBlogTitles(List<Blog> blogs){
        for (Blog blog : blogs) {
            System.out.println(blog.getTitle() + " ID: " + blog.getId());
        }
    }
}
