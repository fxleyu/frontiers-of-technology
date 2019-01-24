package fx.leyu.notes.servlet;

import fx.leyu.notes.service.PeopleService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class PeopleServletTest {
    @Autowired
    private PeopleService peopleService;

    @Test
    public void test() {
        Assert.assertTrue(peopleService.isValid("fxleyu"));
        Assert.assertFalse(peopleService.isValid("fxyuer"));
        Assert.assertTrue(peopleService.register("fxyuer"));
        Assert.assertTrue(peopleService.isValid("fxyuer"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testException() {
        Assert.assertTrue(peopleService.register(null));
    }
}
