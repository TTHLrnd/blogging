package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Blog {
    private long id;
    private String title;
    private String content;
    private long authorId;
    private Timestamp pubDate;
    private List<Comment> comments;

    public Blog(long id, String title, String content, long authorId, Timestamp pubDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.authorId = authorId;
        this.pubDate = pubDate;
    }
}
