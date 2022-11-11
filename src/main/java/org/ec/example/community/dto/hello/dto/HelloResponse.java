package org.ec.example.community.dto.hello.dto;

import org.springframework.stereotype.Component;

@Component
public class HelloResponse {

    private Long id;
    private String content;

    protected HelloResponse() {
        super();
    }

    public HelloResponse(Long id, String content) {
        this();
        this.id = id;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
