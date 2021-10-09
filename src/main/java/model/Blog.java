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
    private Categories category;
    private String content;
    private long authorId;
    private long templateId;
    private Timestamp pubDate;
    private BlogState blogState;
    private List<Comment> comments;

    public Blog(
            long id,
            String title,
            String category,
            String content,
            long authorId,
            long templateId,
            Timestamp pubDate,
            String blogState) {
        this.id = id;
        this.title = title;
        this.category = Categories.valueOf(category);
        this.content = content;
        this.authorId = authorId;
        this.templateId = templateId;
        this.pubDate = pubDate;
        this.blogState = BlogState.valueOf(blogState);
    }

    public Blog(String title, Categories category, String content, long templateId) {
        this.title = title;
        this.category = category;
        this.content = content;
        this.templateId = templateId;
    }
}
