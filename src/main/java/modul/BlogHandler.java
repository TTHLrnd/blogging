package modul;

import database.Database;
import model.Blog;
import model.Categories;
import model.Template;
import model.User;
import utils.Utils;

import java.util.List;


public class BlogHandler extends Handler {
    /**
     *             long id,
     *             String title,
     *             String category,
     *             String content,
     *             long authorId,
     *             long templateId,
     *             Timestamp pubDate,
     *             String blogState
     * @param user
     */
    public static void createBlog(User user) {
        if (user != null) {
            System.out.println("Add title: ");
            String title = Utils.sc().nextLine();
            for (Categories cat : Categories.values()) {
                System.out.println(cat);
            }
            System.out.println("Add category: ");
            String category = Utils.sc().nextLine();
            System.out.println("Add content: ");
            String content = Utils.sc().nextLine();
            for (Template template : Database.getInstance().getTemplates()) {
                System.out.println(template.getTemplate());
            }
            System.out.println("Add template: ");
            String templateString = Utils.sc().nextLine();
            long newTemplate = Database.getInstance().getTemplates().get(0).getId();
            for (Template template : Database.getInstance().getTemplates()) {
                if (template.getTemplate().equals(templateString)) {
                    newTemplate = template.getId();
                }
            }
            Blog newBlog = new Blog(title, Categories.valueOf(category), content, newTemplate);
            Database.getInstance().getBlogs().add(newBlog);
            user.getBlogs().add(newBlog);
        }
    }

    public static void editBlog(User user, Blog blogToEdit, List<Blog> blogs) {
        if (blogToEdit.getAuthorId() == user.getId() || RoleHandler.getUserRole(user).isEditBlog()) {
            for (Blog blog : blogs) {
                if (blog.equals(blogToEdit)) {
                    editingBlog(blog);
                }
            }
        }
    }

    private static void editingBlog(Blog blog) {
        Utils.showBlog(blog);
        System.out.println("Edit title: ");
        String title = Utils.sc().nextLine();
        System.out.println("Edit content: ");
        String editContent = Utils.sc().nextLine();

        edit(title,editContent, blog);
    }

    private static void edit(String title, String editContent, Blog blog){
        if (!title.equals("")){
            blog.setTitle(title);
        }
        if (!editContent.equals("")){
            blog.setContent(editContent);
        }
    }

    public static void deleteBlog(User user, Blog blogToDelete, List<Blog> blogs) {
        if (blogToDelete.getAuthorId() == user.getId() || RoleHandler.getUserRole(user).isDeleteBlog()) {
            for (Blog blog : blogs) {
                if (blog.equals(blogToDelete)) {
                    blogs.remove(blogToDelete);
                }
            }
        }
    }

    public static void readBlog(User user, List<Blog> blogs) {
        Utils.showBlogTitles(blogs);
        long blogID = Utils.sc().nextLong();
        for (Blog blog : blogs) {
            if (blog.getId() == blogID) {
                Utils.showBlog(blog);
            }
        }
    }
}
