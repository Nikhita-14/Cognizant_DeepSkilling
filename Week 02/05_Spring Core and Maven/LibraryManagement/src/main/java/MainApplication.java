import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApplication {
    public static void main(String[] args) {
        // 1. Boot up the Spring Container by reading the XML configuration file
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 2. Fetch the fully configured BookService bean managed by Spring
        BookService bookService = (BookService) context.getBean("bookService");

        // 3. Execute the service method to see if dependency injection worked
        bookService.manageBooks();
    }
}