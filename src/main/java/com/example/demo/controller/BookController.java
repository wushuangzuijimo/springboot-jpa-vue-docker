package com.example.demo.controller;


import com.example.demo.BookRepo.BookRepository;
import com.example.demo.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.support.Repositories;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/books")


public class BookController {
    @Autowired
    private BookRepository bookRepository;



    @GetMapping("/findById/{id}")
    public Book findById(@PathVariable("id") Integer id){
        return bookRepository.findById(id).get();

    }
    @PutMapping
    public String update(@RequestBody Book book){


        Book res = bookRepository.save(book);
        if (res!=null) {

            return "success";
        }else {
            return "error";
        }

    }
    @GetMapping("/{page}/{size}")
    public Page<Book> findAll(@PathVariable("page") Integer page,@PathVariable("size") Integer size){
        PageRequest pageRequest = PageRequest.of(page,size);


        return bookRepository.findAll(pageRequest);

    }

    @PostMapping
    public String save(@RequestBody Book book){
        bookRepository.save(book);


        return "success";

    }


    @DeleteMapping("/deleteById/{id}")
    public void delete(@PathVariable("id") Integer id){
        bookRepository.deleteById(id);

    }











}
