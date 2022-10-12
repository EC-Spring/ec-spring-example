package org.ec.example.community.dto;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Component
public class CommunityResponse {

    private Long id;

    private String title;
    private String content;

    private Long views;

    private Long createdAt;
    private Long updatedAt;

    protected CommunityResponse() {
        super();
    }

    public CommunityResponse(Long id, String title, String content, Long views, Long createdAt, Long updatedAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.views = views;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getViews() {
        return views;
    }

    public void setViews(Long views) {
        this.views = views;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }
}
