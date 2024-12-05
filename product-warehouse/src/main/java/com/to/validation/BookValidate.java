package com.to.validation;

import com.to.exception.ProductValidationException;
import com.to.ordermanagementservice.entity.Book;
import org.springframework.stereotype.Component;

import java.time.Year;

import static com.to.utils.Constant.MAX_TEXT_SIZE;

@Component
public class BookValidate extends ProductValidate<Book> {
    @Override
    public Class<Book> supports() {
        return Book.class;
    }

    @Override
    public void doValidateInternal(Book book) {
        if (book.getAuthor().length() > MAX_TEXT_SIZE || book.getAuthor().isEmpty()) {
            throw new ProductValidationException("Length of Author name " + book.getAuthor()
                    + " must not be empty and longer that 255 characters");
        }
        if (book.getPages() < 1) {
            throw new ProductValidationException("the count of page " + book.getPages()
                    + " must be positive number");
        }
        if (book.getYear() > Year.now().getValue()) {
            throw new ProductValidationException("the year " + book.getYear() + " must be real");
        }
    }
}
