package com.example.repository;

import com.example.entity.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Book findByTitle(String bookName);

    List<Book> findByTitleLikeOrderByTitleAsc(String bookName);
    List<Book> findByTitleContainingOrderByTitleDesc(String bookName);
    List<Book> findByTitleStartingWith(String bookName);
    List<Book> findByTitleEndingWith(String bookName);
    List<Book> findByTitleIgnoreCase(String bookName);

    //relational operations
    List<Book> findByPageCountGreaterThan(int pageCount);
    List<Book> findByPageCountGreaterThanEqual(int pageCount);
    List<Book> findByPageCountLessThanEqual(int pageCount);
    List<Book> findByPageCountBetween(int min, int max);

    //logical operations
    List<Book> findByTitleContainingOrTitleContaining(String param1, String param2);
    List<Book> findByTitleContainingAndPageCountGreaterThan(String param1, int param2);
    List<Book> findByTitleNotContaining(String param1);
    List<Book> findByTitleNot(String param1);

    //limiting query result
    List<Book> findTopByOrderByPageCountDesc();
    List<Book> findFirstByOrderByPageCountDesc(); //same top
    List<Book> findTop3ByOrderByPriceDesc();
}
