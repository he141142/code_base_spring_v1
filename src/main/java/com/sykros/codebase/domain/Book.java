package com.sykros.codebase.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sykros.codebase.utils.module.console.wagu.WaguAnnotation;
import com.sykros.codebase.utils.module.console.wagu.WaguExtension;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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
    @WaguAnnotation(Header = "description")
    private String description;

    @NotEmpty
    @NotNull
    @JsonProperty("book_name")
    @Column(name = "book_name")
    @WaguAnnotation(Header = "book_name")
    private String bookName;

    @NotNull
    @JsonProperty("pages")
    @Column(name = "pages")
    @WaguAnnotation(Header = "pages")
    private int pages;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storage_id")
    @WaguAnnotation(Header = "storage_id")
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

    @Override
    public String toString() {
        return super.toString();
    }

    public void PrintTable() {
        String bookInventoryId = this.getBookInventory() == null ? "":   Long.toString(this.getBookInventory().getId());
        System.out.println(new WaguExtension().
                WithHeaders("book_name",
                        "pages",
                        "storage_id").
                AddRow(
                        this.getBookName(),
                        String.valueOf(this.getPages()),
                        bookInventoryId
                ).
                getTableFormat());
    }
}
