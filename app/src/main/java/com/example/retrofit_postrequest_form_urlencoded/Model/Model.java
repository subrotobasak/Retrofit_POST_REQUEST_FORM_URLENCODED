package com.example.retrofit_postrequest_form_urlencoded.Model;

public class Model {

    private int userId;
    private Integer id;
    private String title;
    private String body;

    public Model(int userId, String title, String body) {
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
