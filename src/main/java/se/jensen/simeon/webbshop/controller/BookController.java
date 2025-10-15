package se.jensen.simeon.webbshop.controller;

import se.jensen.simeon.webbshop.model.SubBook;
import se.jensen.simeon.webbshop.repository.BookRepository;
import se.jensen.simeon.webbshop.view.AddBookView;
import se.jensen.simeon.webbshop.view.InfoView;

public class BookController {
    private BookRepository bookRepository;
    private InfoView infoView;
    private AddBookView addBookView;

    public BookController(BookRepository bookRepository, InfoView infoView, AddBookView addBookView) {
        this.bookRepository = bookRepository;
        this.infoView = infoView;
        this.addBookView = addBookView;
    }

    public void addBook() {
        SubBook book = addBookView.getBookInput();

        bookRepository.addBook(book);
        infoView.infoAdd();
    }
}
