package com.example.springbookdbexcersise.Service;

import com.example.springbookdbexcersise.APIException.APIException;
import com.example.springbookdbexcersise.Model.Book;
import com.example.springbookdbexcersise.Repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class BookService {
    private final BookRepository bookRepository;
//-All CRUD

    //get
    public List<Book> getBooks(){
       return bookRepository.findAll();
    }

    //add
    public void addBook(Book book){
         bookRepository.save(book);
    }
    //update

    public void updateBook(Book book, Integer id){
        Book oldBook=bookRepository.findBookById(id);
        if(oldBook==null){
            throw new APIException("sorry no such book to update, try another ID");

        }
        oldBook.setTitle(book.getTitle());
        oldBook.setCategory(book.getCategory());
        oldBook.setPagenum(book.getPagenum());
        oldBook.setAuthor(book.getAuthor());
        bookRepository.save(oldBook);
    }
    //delete

    public void deleteBook(Integer id){
        Book theBook= bookRepository.findBookById(id);
        if (theBook==null){
            throw new APIException("this book isn't exist, try another id");
        }

        bookRepository.delete(theBook);
    }

    //-Get books by Category
    public List<Book> getCategory(String category){
      List<Book>books=bookRepository.findBookByCategory(category);
      if(books==null){
          throw new APIException("wrong category, try again");
      }
      return books;
    }
    //-Get books hava pages more than 300

    public List<Book>getByPages(Integer pagenum){
        List<Book>books=bookRepository.findBookByPagenumGreaterThanEqual(pagenum);
        return books;
    }
    //-Get books by Author

    public List<Book> getByAuthor(String author){
        List<Book>books=bookRepository.findBookByAuthor(author);
        return books;
    }
    //-get book by title

    public Book getByTitle(String title){
      Book book= bookRepository.findBookByTitle(title);
      if(book==null){
          throw new APIException("sorry no book with this title");
      }
      return book;
    }

}
