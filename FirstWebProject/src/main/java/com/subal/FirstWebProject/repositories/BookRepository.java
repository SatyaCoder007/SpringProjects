package com.subal.FirstWebProject.repositories;

import com.subal.FirstWebProject.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
