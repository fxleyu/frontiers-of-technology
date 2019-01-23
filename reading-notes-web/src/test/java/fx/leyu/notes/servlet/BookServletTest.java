package fx.leyu.notes.servlet;

import fx.leyu.notes.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class BookServletTest {
    @Autowired
    private BookService bookService;

    @Test
    public void test() {
        System.out.println(bookService.getBook("s"));
    }
}
