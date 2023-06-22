package com.example.sd11_exercisespringdataadvancedquerying.repositories;

import com.example.sd11_exercisespringdataadvancedquerying.models.Book;
import com.example.sd11_exercisespringdataadvancedquerying.models.enums.AgeRestrictionType;
import com.example.sd11_exercisespringdataadvancedquerying.models.enums.BookEditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<List<Book>> findBooksByAgeRestriction(AgeRestrictionType ageRestrictionType);

    Optional<List<Book>> findBooksByBookEditionTypeAndCopiesLessThan(BookEditionType editionType, int copies);

    Optional<List<Book>> findBooksByPriceLessThanOrPriceGreaterThan(BigDecimal lowerPrice, BigDecimal higherPrice);

    @Query(nativeQuery = true, value = "SELECT * FROM books AS b WHERE YEAR(b.release_date) NOT LIKE ?1")
    List<Book> findBooksByReleaseDateIsNot(int year);

    Optional<List<Book>> findBooksByReleaseDateBefore(LocalDate dateFormatted);

    Optional<List<Book>> findBooksByTitleContainsIgnoreCase(String input);

    Optional<List<Book>> findBooksByAuthorLastNameStartsWithIgnoreCase(String letters);

    @Query("SELECT COUNT(b.title) FROM Book AS b WHERE CHAR_LENGTH(b.title) > ?1")
    int countBooksByTitleLengthGreaterThan(int length);

    @Query("SELECT a, SUM(b.copies) AS sum_copies FROM Author AS a JOIN a.books AS b GROUP BY a.id ORDER BY sum_copies DESC")
    Optional<List<Object[]>> findTotalBooksCopiesByAuthor();

    @Query("SELECT b.title, b.bookEditionType, b.ageRestriction, b.price FROM Book AS b WHERE b.title = ?1")
    Optional<String[]> findBookInfoByTitle(String title);

    @Query("UPDATE Book AS b SET b.copies = b.copies + ?2 WHERE b.releaseDate > ?1")
    @Modifying
    Optional<Integer> updateCopiesOfBooksReleasedBeforeDate(LocalDate date, int copies);

    @Query(value = "CALL usp_get_count_of_written_books_by_author(?1)", nativeQuery = true)
    int getAuthorWrittenBookCountUsingUSP(String fullName);

    @Modifying
    int deleteBookByCopiesLessThan(int copies);
}
