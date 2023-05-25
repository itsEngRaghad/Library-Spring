package com.example.springbookdbexcersise.Repository;

import com.example.springbookdbexcersise.Model.Book;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    Book findBookById(Integer id);

    List<Book> findBookByCategory(String category);

//    //-Get books hava pages more than 300

    List<Book>findBookByPagenumGreaterThanEqual(Integer pagenum);
//    //-Get books by Author

    List<Book>findBookByAuthor(String author);

    //-get book by title

    Book findBookByTitle(String title);

}

