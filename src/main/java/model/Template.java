package model;

import lombok.Getter;

@Getter
public class Template {
    private long id;
    private String template;

    public Template(long id, String template) {
        this.id = id;
        this.template = template;
    }
}
