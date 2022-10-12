package org.ec.example.hello;

import javax.persistence.*;

@Entity
public class Hello {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 64)
    private String content;

    protected Hello() {
        super();
    }

    public Hello(Long id, String content) {
        this();
        this.id = id;
        this.content = content;
    }

    public Hello(String content) {
        this();
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}