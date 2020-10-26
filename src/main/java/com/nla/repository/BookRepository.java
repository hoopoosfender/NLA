package com.nla.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nla.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
