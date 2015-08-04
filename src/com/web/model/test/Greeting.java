package com.web.model.test;

import com.web.model.BaseModel;

public class Greeting extends BaseModel{
	private final long id;
    private final String content;
    
    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
