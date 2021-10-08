package model;

/**
 * admin: does everything
 * mod: Has privileges to edit blogs
 * user: blog, edit self stuff, comment
 */

public class Roles {
    private boolean readBlog;
    private boolean writeBlog;
    private boolean editBlog;
    private boolean deleteBlog;
    private boolean readUser;
    private boolean editUser;

    private Roles(
            boolean readBlog,
            boolean writeBlog,
            boolean editBlog,
            boolean deleteBlog,
            boolean readUser,
            boolean editUser) {
        this.readBlog = readBlog;
        this.writeBlog = writeBlog;
        this.editBlog = editBlog;
        this.deleteBlog = deleteBlog;
        this.readUser = readUser;
        this.editUser = editUser;
    }

    public static Roles Roles(UserRoles role) {
        if (role.equals(UserRoles.user)) {
            return new Roles(
                    true,
                    true,
                    false,
                    false,
                    false,
                    false);
        } else if (role.equals(UserRoles.mod)) {
            return new Roles(
                    true,
                    true,
                    true,
                    true,
                    false,
                    false);
        } else if (role.equals(UserRoles.admin)) {
            return new Roles(
                    true,
                    true,
                    true,
                    true,
                    true,
                    true);
        }
        return null;
    }


}
