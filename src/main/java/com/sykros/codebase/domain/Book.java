package com.sykros.codebase.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "books")
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    @NotNull
    private String description;

    @NotEmpty
    @NotNull
    @Column(name = "book_name")
    private String bookName;

    @NotEmpty
    @NotNull
    @Column(name = "pages")
    private int pages;

    public Book(Builder builder){
            this.bookName = builder.bookName;
            this.pages = builder.pages;
            this.description = builder.description;
    }

    public static class Builder{
        private String description;
        private String bookName;
        private int pages;

        public Builder setDescription(String description){
            this.description = description;
            return this;
        }

        public Builder bookName(String bookname){
            this.bookName = bookname;
            return this;
        }

        public Builder withPages(int page){
            this.pages = page;
            return this;
        }

        public Book build(){
            return new Book(this);
        }
    }

}
