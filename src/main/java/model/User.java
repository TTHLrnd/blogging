package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class User {
    private long id;
    private String username;
    private String email;
    private String password;
    private Timestamp regDate;
    private UserRoles role;
    private List<Blog> blogs = new ArrayList<>();

    public User(long id, String username, String email, String password, Timestamp regDate, String role) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.regDate = regDate;
        this.role = UserRoles.valueOf(role);
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
