package com.sykros.codebase.domain;

import jakarta.persistence.*;
import lombok.Getter;
//import com.sykros.codebase.enums.StorageType;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@Entity
@Table(name = "book_inventory",indexes ={
        @Index(columnList = "storage_code",name = "code_idx")
})
@Getter
@NoArgsConstructor
public class BookInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "amount")
    int amount = 0;

    @Column(name = "storage_type")
    private String storageType;

    @Column(name = "storage_code",unique = true)
    private String storageCode;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "bookInventory")
    List<Book> books;


}
