package com.example.springbookdbexcersise.Repository;

import com.example.springbookdbexcersise.Model.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibrarianRepository extends JpaRepository<Librarian,Integer> {

    //-get librarian by Id
    Librarian findLibrarianById(Integer id);



    //-check login by username and password

    Librarian findLibrarianByUsernameAndPassword(String username,String password);

    //-get librarian Account by email
    Librarian findLibrarianByEmail(String email);
}
