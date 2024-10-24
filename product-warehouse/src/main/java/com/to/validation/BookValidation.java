package com.to.validation;

import com.to.exception.BookValidationException;
import com.to.exception.NameValidationException;
import com.to.ordermanagementservice.entity.Book;

import java.time.Year;

public class BookValidation extends ProductValidation<Book>{
    @Override
    public void doValidateInternal (Book book){
        if (book.getAuthor().length() > 255 || book.getAuthor().isEmpty()){
            throw new BookValidationException("Length of Author name " + book.getAuthor() +
                    " must not be empty and longer that 255 characters");
        }
        if (book.getPages() < 1 ){
            throw new BookValidationException("the count of page " + book.getPages() +
                    " must be positive number");
        }
        if (book.getYear() > Year.now().getValue()){
            throw new BookValidationException("the year " + book.getYear() + " must be real");
        }
    }
}
