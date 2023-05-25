package com.example.springbookdbexcersise.Service;

import com.example.springbookdbexcersise.APIException.APIException;
import com.example.springbookdbexcersise.Model.Librarian;
import com.example.springbookdbexcersise.Repository.BookRepository;
import com.example.springbookdbexcersise.Repository.LibrarianRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LibrarianService {
    private final LibrarianRepository librarianRepository;

//-All CRUD

    //get
    public List<Librarian> getLibrarians(){
       return librarianRepository.findAll();
    }
    //add

    public void addLib(Librarian librarian){
        librarianRepository.save(librarian);
    }

    //update

    public void updateLib(Librarian librarian, Integer id){
        Librarian oldLib=librarianRepository.findLibrarianById(id);
        if(oldLib==null){
            throw new APIException("this librarian is not exist, try another id");
        }
        oldLib.setName(librarian.getName());
        oldLib.setUsername(librarian.getUsername());
        oldLib.setEmail(librarian.getEmail());
        oldLib.setPassword(librarian.getPassword());
        librarianRepository.save(oldLib);
    }

    //delete

    public void deleteLib(Integer id){
      Librarian theLib=  librarianRepository.findLibrarianById(id);
      if(theLib==null){
          throw new APIException("this librarian is not exist");
      }
      librarianRepository.delete(theLib);
    }

    //-get librarian by Id

    public Librarian getById(Integer id){
      Librarian librarian=librarianRepository.findLibrarianById(id);
        if(librarian==null){
            throw new APIException("no such librarian with this id");
        }
        return librarian;
    }
    //-check login by username and password
    public Librarian login(String username , String password){
        Librarian librarian=librarianRepository.findLibrarianByUsernameAndPassword(username,password);
        if(librarian==null){
            throw new APIException("no such librarian with this acc");
        }
        return librarian;
    }

    //-get librarian Account by email

    public Librarian getEmail(String email){
        Librarian librarian=librarianRepository.findLibrarianByEmail(email);
        if(librarian==null){
            throw new APIException("no such librarian with this eemail");
        }
        return librarian;
    }

}
