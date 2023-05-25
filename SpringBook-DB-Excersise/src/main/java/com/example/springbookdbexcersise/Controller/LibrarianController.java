package com.example.springbookdbexcersise.Controller;

import com.example.springbookdbexcersise.Model.Librarian;
import com.example.springbookdbexcersise.Service.LibrarianService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/librarian")
@RequiredArgsConstructor
public class LibrarianController {
    private final LibrarianService librarianService;

    //get
    @GetMapping("/get")
    public ResponseEntity<Object> getLibrarians(){
        List<Librarian> librarians=librarianService.getLibrarians();
        return ResponseEntity.status(200).body(librarians);
    }

    //add
    @PostMapping("/add")
    public ResponseEntity addLib(@Valid @RequestBody Librarian librarian){
        librarianService.addLib(librarian);
         return ResponseEntity.status(200).body("Librarian has been added successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateLib(@Valid@RequestBody Librarian librarian,@PathVariable Integer id){
        librarianService.updateLib(librarian,id);
        return ResponseEntity.status(200).body("librarian has been updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteLib(@PathVariable Integer id){
        librarianService.deleteLib(id);
        return ResponseEntity.status(200).body("lib has been deleted");
    }

    //by id
    @GetMapping("get-id/{id}")
    public ResponseEntity getByID(@PathVariable Integer id){
      Librarian librarian=  librarianService.getById(id);
      return ResponseEntity.status(200).body(librarian);

    }
    @GetMapping("/login/{username}/{password}")
    public ResponseEntity login(@PathVariable String username,@PathVariable String password){
        Librarian librarian=librarianService.login(username,password);
        return ResponseEntity.status(200).body(librarian);
    }

    @GetMapping("/get-email/{email}")
    public ResponseEntity getEmail(@PathVariable String email){
        Librarian librarian=librarianService.getEmail(email);
        return ResponseEntity.status(200).body(librarian);
    }
}
