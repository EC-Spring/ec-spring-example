package org.ec.example.community;

import javax.persistence.*;

@Entity
public class Community {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 64)
    private String title;
    @Column(nullable = false, length = 1024)
    private String content;

    @Column(nullable = false)
    private Long views;

    @Column(nullable = false)
    private Long createdAt;
    private Long updatedAt;

    protected Community() {
        super();
    }

    public Community(Long id, String title, String content, Long views, Long createdAt, Long updatedAt) {
        this();
        this.id = id;
        this.title = title;
        this.content = content;
        this.views = views;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Community(String title, String content) {
        this();
        this.title = title;
        this.content = content;
        this.views = 0L;
        this.createdAt = System.currentTimeMillis();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Long getViews() {
        return views;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void increaseViews() {
        views++;
    }
}
