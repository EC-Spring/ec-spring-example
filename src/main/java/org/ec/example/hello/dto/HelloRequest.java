package org.ec.example.hello.dto;

import org.springframework.stereotype.Component;

@Component
public class HelloRequest {

    private Long id;
    private String content;

    protected HelloRequest() {
        super();
    }

    public HelloRequest(Long id, String content) {
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
