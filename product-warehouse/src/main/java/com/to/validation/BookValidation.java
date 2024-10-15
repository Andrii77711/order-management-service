package com.to.validation;

import com.to.exception.AuthorValidationException;
import com.to.exception.NameValidationException;
import com.to.exception.PageValidationException;
import com.to.exception.YearValidationException;
import com.to.ordermanagementservice.entity.Book;

import java.time.Year;

public class BookValidation implements Validation <Book>{
    @Override
    public Boolean isValid (Book book){
        if (book.getName().length() > 255 || book.getName().isEmpty()) {
            throw new NameValidationException(book.getName());
        }
        if (book.getAuthor().length() > 255 || book.getAuthor().isEmpty()){
            throw new AuthorValidationException(book.getAuthor());
        }
        if (book.getPages() < 1 ){
            throw new PageValidationException(book.getPages());
        }
        if (book.getYear() > Year.now().getValue()){
            throw new YearValidationException(book.getYear());
        }
        return true;
    }
}
