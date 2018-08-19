package examples.boot.web1;

import org.apache.tomcat.jni.Local;

import java.time.LocalDateTime;

public class Board {
    private String name;
    private String title;
    private String content;
    private LocalDateTime regdate;

    public Board() {
        regdate = LocalDateTime.now();
    }

    public Board(String name, String title, String content) {
        this();
        this.name = name;
        this.title = title;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getRegdate() {
        return regdate;
    }

    public void setRegdate(LocalDateTime regdate) {
        this.regdate = regdate;
    }
}
