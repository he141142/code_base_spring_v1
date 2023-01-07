package com.sykros.codebase.api;

import com.sykros.codebase.domain.Book;
import com.sykros.codebase.dto.request.CreateBookRequestDto;
import com.sykros.codebase.enums.message.api_response.BookDomain;
import com.sykros.codebase.service.interfaces.IBookService;
import com.sykros.codebase.utils.responseUtils.ResponseMessage;
import com.sykros.codebase.utils.responseUtils.SykrosResponseEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatusCode;

@RestController
@RequestMapping(value = "/sykros/v1/book")
//@Api(tags = {"hotels"})
public class BookController {

    IBookService bookService;

    @Autowired
    public void setBookService(IBookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(method = RequestMethod.POST,name = "/create",path = "/create")
    public SykrosResponseEntity<ResponseMessage<Book>> Create(@RequestBody @Valid CreateBookRequestDto createBookRequest){
        Book book = new Book.
                Builder().
                bookName(createBookRequest.getBookName()).
                setDescription(createBookRequest.getDescription()).
                withPages(createBookRequest.getPages()).
                build();

        return new SykrosResponseEntity.
                Builder<Book>().
                withResponseComponent().
                setData(book).
                status(HttpStatus.OK).
                withMessage(BookDomain.CREATE_SUCCESSFULLY.getMessage()).
                buildResponseEntity();
    }

}
