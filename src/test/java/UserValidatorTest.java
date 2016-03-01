import static org.junit.Assert.assertEquals;

import java.util.Date;

import com.volnoboy.ModelValidator;
import com.volnoboy.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Volodymyr Volnoboy
 * @since 3/1/16 5:15 PM
 */
public class UserValidatorTest {

	ModelValidator<User> modelValidator;

	@Before
	public void init() {
		modelValidator = new ModelValidator<>();
		System.out.println("Validator is created.");
	}

	@Test
	public void testName() {
		User user = new User("valera", "Nosov", new Date(), 23, "a@b.com", true);
		modelValidator.validateModel(user);
		assertEquals(1, modelValidator.getViolations().size());
	}

	@Test
	public void testLastName() {
		User user = new User("Valera", "nosov", new Date(), 23, "a@b.com", true);
		modelValidator.validateModel(user);
		assertEquals(1, modelValidator.getViolations().size());
	}

	@Test
	public void testDateIsPast() {
		Date date = new Date();
		date.setYear(2050);
		User user = new User("Valera", "Nosov", date, 23, "a@b.com", true);
		modelValidator.validateModel(user);
		assertEquals(1, modelValidator.getViolations().size());
	}

	@Test
	public void testAge() {
		User user = new User("Valera", "Nosov", new Date(), 9, "a@b.com", true);
		modelValidator.validateModel(user);
		assertEquals(1, modelValidator.getViolations().size());
	}

	@Test
	public void testEmail() {
		User user = new User("Valera", "Nosov", new Date(), 20, "ab", true);
		modelValidator.validateModel(user);
		assertEquals(1, modelValidator.getViolations().size());
	}

	@After
	public void tearDown() {
		modelValidator.closeValidator();
		System.out.println("Validator is closed. \n");
	}
}
