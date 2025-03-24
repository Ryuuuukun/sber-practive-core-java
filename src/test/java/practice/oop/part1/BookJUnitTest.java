package practice.oop.part1;

import org.junit.Test;
import ru.sber.base.syntax.oop.part1.book.Author;
import ru.sber.base.syntax.oop.part1.book.AuthorGender;
import ru.sber.base.syntax.oop.part1.book.Book;

import java.time.LocalDate;

public class BookJUnitTest {

    @Test
    public void initTest() {
        Book a = new Book("Война и мир", new Author("Л. Н. Толстой", AuthorGender.MAN, "-"),
                LocalDate.parse("1867-01-01"));
        Book b = new Book("Преступление и наказание", new Author("Ф. М. Достоевский", AuthorGender.MAN, "-"),
                LocalDate.parse("1865-01-01"));
    }

    @Test
    public void toStringTest() {
        System.out.println(new Book("Война и мир", new Author("Л. Н. Толстой", AuthorGender.MAN, "-"),
                LocalDate.parse("1867-01-01")));
        System.out.println(new Book("Преступление и наказание", new Author("Ф. М. Достоевский", AuthorGender.MAN, "-"),
                LocalDate.parse("1865-01-01")));
    }
}
