package com.example.springbookdbexcersise.Controller;

import com.example.springbookdbexcersise.Model.Book;
import com.example.springbookdbexcersise.Service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    //get
    @GetMapping("/get")
    public ResponseEntity getBooks(){

        List<Book>books=bookService.getBooks();
        return ResponseEntity.status(200).body(books);
    }

    //add

    @PostMapping("/add")
    public ResponseEntity addBook(@Valid @RequestBody Book book){
        bookService.addBook(book);
        return ResponseEntity.status(200).body("Congrats!, your book has been successfully added");
    }

    //update
    @PutMapping("/update/{id}")
    public ResponseEntity updateBook(@Valid @RequestBody Book book,@PathVariable Integer id){
        bookService.updateBook(book,id);
        return ResponseEntity.status(200).body("your book has been successfully updated!");
    }

    //delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBook(@PathVariable Integer id){
        bookService.deleteBook(id);
        return ResponseEntity.status(200).body("Sadly, yor book has been deleted");
    }

    //get by category
    @GetMapping("/get-category/{category}")
    public ResponseEntity getCategory(@PathVariable String category){
        List<Book>books=bookService.getCategory(category);
        return ResponseEntity.status(200).body(books);
    }

    //find by pages
    @GetMapping("/get-page/{pagenum}")
    public ResponseEntity getByPages(@PathVariable Integer pagenum){
        List<Book>books=bookService.getByPages(pagenum);
        return ResponseEntity.status(200).body(books);
    }
    //get by author
    @GetMapping("/get-author/{author}")
    public ResponseEntity getByAuthor(@PathVariable String author){
        List<Book>books=bookService.getByAuthor(author);
        return ResponseEntity.status(200).body(books);
    }

    //get by title
    @GetMapping("/get-title/{title}")
    public ResponseEntity getByTitle(@PathVariable String title){
        Book book=bookService.getByTitle(title);
        return ResponseEntity.status(200).body(book);
    }



}
