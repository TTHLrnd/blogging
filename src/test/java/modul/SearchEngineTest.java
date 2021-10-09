package modul;

import model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.time.LocalTime.now;


class SearchEngineTest {

    @Test
    public void searchUserByNameTest() {
        String nullEntry = null;
        String emptyEntry = "";
        String testData = "Olajos";
        List<User> expectedList = Arrays.asList(
                new User(),
                new User(),
                new User(),
                new User()

        );
        List<User> nullList = null;
        Assertions.assertTrue(checkLists(expectedList, SearchEngine.searchUser(nullEntry, expectedList)));
        Assertions.assertTrue(checkLists(expectedList, SearchEngine.searchUser(emptyEntry, expectedList)));

        List<User> resList = new ArrayList<>();
        expectedList.get(0).setUsername("Olajos");
        resList.add(expectedList.get(0));

        Assertions.assertTrue(checkLists(resList, SearchEngine.searchUser(testData, expectedList)));
    }

    private boolean checkLists(List<User> expected, List<User> actual) {
        if (!(expected.size() == actual.size())) {
            return false;
        }
        for (int i = 0; i < expected.size(); i++) {
            if (!expected.get(i).equals(actual.get(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean checkBlogList(List<Blog> expected, List<Blog> actual) {
        if (!(expected.size() == actual.size())) {
            return false;
        }
        for (int i = 0; i < expected.size(); i++) {
            if (!expected.get(i).equals(actual.get(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean checkCommentLists(List<Comment> expected, List<Comment> actual) {
        if (!(expected.size() == actual.size())) {
            return false;
        }
        for (int i = 0; i < expected.size(); i++) {
            if (!expected.get(i).equals(actual.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Test
    void searchByRoleGroupTest() {
        UserRoles test = UserRoles.valueOf("admin");
        UserRoles test2 = null;
        Timestamp ts = Timestamp.from(Instant.now());
        List<User> testList = Arrays.asList(
                new User(1, "username", "email", "password", ts, "mod"),
                new User(2, "username2", "email", "password", ts, "user"),
                new User(3, "username3", "email", "password", ts, "admin"),
                new User(4, "username4", "email", "password", ts, "user")
        );
        List<User> expected = new ArrayList<>();
        expected.add(testList.get(2));
        Assertions.assertTrue(checkLists(expected, SearchEngine.searchByRoleGroup(test, testList)));
        Assertions.assertTrue(checkLists(testList, SearchEngine.searchByRoleGroup(test2, testList)));
    }

    @Test
    void listUserBlogsTest() {
        User test = new User();
        User test2 = null;
        Assertions.assertTrue(checkBlogList(test.getBlogs(), SearchEngine.listUserBlogs(test)));
        Assertions.assertEquals(null, SearchEngine.listUserBlogs(test2));
    }

    @Test
    void searchInBlogsTest() {
        String testTitle = null;
        String testTitle2 = "";
        List<Blog> testBlogs = Arrays.asList(
                new Blog(),
                new Blog(),
                new Blog()
        );

        Assertions.assertTrue(checkBlogList(testBlogs, SearchEngine.searchInBlogs(testTitle, testBlogs)));
        Assertions.assertTrue(checkBlogList(testBlogs, SearchEngine.searchInBlogs(testTitle2, testBlogs)));
    }

    @Test
    void searchInCommentsTest() {
        String testComm = null;
        String testComm2 = "";
        List<Comment> testComments = Arrays.asList(
                new Comment(),
                new Comment(),
                new Comment()
        );

        Assertions.assertTrue(checkCommentLists(testComments, SearchEngine.searchInComments(testComm, testComments)));
        Assertions.assertTrue(checkCommentLists(testComments, SearchEngine.searchInComments(testComm2, testComments)));
    }

    @Test
    void getBlogByCategoryTest() {
        Categories testCategory = null;
        Categories testCategory2 = Categories.valueOf("Art");
        Timestamp ts = Timestamp.from(Instant.now());
        List<Blog> testBlogs = Arrays.asList(
                new Blog(1, "title", "Art", "content", 1, 1, ts, "published"),
                new Blog(2, "title", "Science", "content", 2, 1, ts, "draft"),
                new Blog(3, "title", "Food", "content", 3, 1, ts, "published")
        );

        List<Blog> expected = new ArrayList<>();
        expected.add(testBlogs.get(0));

        Assertions.assertTrue(checkBlogList(testBlogs, SearchEngine.getBlogByCategory(testCategory, testBlogs)));
        Assertions.assertTrue(checkBlogList(expected, SearchEngine.getBlogByCategory(testCategory2, testBlogs)));
    }

    @Test
    void getCommentsFromBlogTest() {
    }
}