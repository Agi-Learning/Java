package com.javatechie.spring.cloud.function.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


package com.javatechie.spring.cloud.function.api;

public class Book {
    private int id;
    private String name;
    private String author;

    public Book() {} // <-- Required for JSON to object conversion

    public Book(int id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getAuthor() { return author; }

    @Override
    public String toString() {
        return "Book{id=" + id + ", name='" + name + "', author='" + author + "'}";
    }
}

