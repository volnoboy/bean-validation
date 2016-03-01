import static org.junit.Assert.assertEquals;

import java.util.Date;

import com.volnoboy.model.Book;
import com.volnoboy.ModelValidator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Volodymyr Volnoboy
 * @since 2/14/16 7:30 PM
 */
public class BookValidatorTest {

	ModelValidator<Book> modelValidator;

	@Before
	public void init() {
		modelValidator = new ModelValidator<>();
		System.out.println("Validator is created.");
	}

	@Test
	public void testBookMinPrice() {
		Book book = new Book("9781234567890", "Kotlovan", 3f, null, 255, new Date(), "http://www.volnoboy.com");
		modelValidator.validateModel(book);
		assertEquals(0, modelValidator.getViolations().size());
	}

	@Test
	public void testNotEmptyAnnotation() {
		Book book = new Book("9781234567890", "", 3f, null, 255, new Date(), "http://www.volnoboy.com");
		modelValidator.validateModel(book);
		assertEquals(2, modelValidator.getViolations().size());
	}

	@Test
	public void testURLAnnotation() {
		Book book = new Book("9781234567890", "Kotlovan", 3f, null, 255, new Date(), "www.volnoboy.com");
		modelValidator.validateModel(book);
		assertEquals(1, modelValidator.getViolations().size());
	}

	@After
	public void tearDown() {
		modelValidator.closeValidator();
		System.out.println("Validator is closed.");
	}
}
