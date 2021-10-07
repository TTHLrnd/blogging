package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
public class Comment {
    private long id;
    private Timestamp pubDate;
    private long blogId;
    private long authorId;
    private String comment;

    public Comment(long id, Timestamp pubDate, long blogId, long authorId, String comment) {
        this.id = id;
        this.pubDate = pubDate;
        this.blogId = blogId;
        this.authorId = authorId;
        this.comment = comment;
    }
}
