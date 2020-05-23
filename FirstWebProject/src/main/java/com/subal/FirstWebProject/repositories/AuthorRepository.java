package com.subal.FirstWebProject.repositories;

import com.subal.FirstWebProject.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
