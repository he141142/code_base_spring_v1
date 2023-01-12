package com.sykros.codebase.dto.request;

import com.sykros.codebase.decorators.IsEntityExist;
import com.sykros.codebase.dto.object.Book;
import com.sykros.codebase.enums.Entity;
import jakarta.validation.constraints.NotNull;

public class GetBookRequest {
    @IsEntityExist(ForEntity = Entity.BOOK)
    @NotNull
    private Long bookID;
}
