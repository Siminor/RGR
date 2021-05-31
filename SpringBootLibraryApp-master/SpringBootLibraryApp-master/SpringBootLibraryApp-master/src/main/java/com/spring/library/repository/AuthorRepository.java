package com.spring.library.repository;

import com.spring.library.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    List<Author> findByAuthorName(String authorName);
    @Query(value = "select * from book b inner join author a on (b.author_id = a.author_id) inner join publisher p on (b.publisher_id= p.publisher_id) where count(b.publisher_id) < 2", nativeQuery = true)
List<Author> findAuthorWithOnePublishe();
}
