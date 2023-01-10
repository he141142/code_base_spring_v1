package com.sykros.codebase.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    @NotNull
    @JsonProperty("description")
    private String description;

    @NotEmpty
    @NotNull
    @JsonProperty("book_name")
    @Column(name = "book_name")
    private String bookName;

    @NotNull
    @JsonProperty("pages")
    @Column(name = "pages")
    private int pages;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storage_id")
    BookInventory bookInventory = null;

    public Book(Builder builder) {
        this.setBookName(builder.bookName);
        this.setDescription(builder.description);
        this.setPages(builder.pages);
    }

    public static class Builder {
        private String description;
        private String bookName;
        private int pages;

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder bookName(String bookName) {
            this.bookName = bookName;
            return this;
        }

        public Builder withPages(int page) {
            this.pages = page;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }

}
