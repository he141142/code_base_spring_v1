package com.sykros.codebase.dto.request;

import com.sykros.codebase.decorators.IsEntityExist;
import com.sykros.codebase.dto.object.Book;

public class GetBookRequest {

    @IsEntityExist(ForClass = Book.class)
    private Long bookID;

}
