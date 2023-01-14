package rocks.zipcode.Jive;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@SpringBootTest
class JiveApplicationTests {
	@Mock
	private SpringApplication springApplication;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}


	@Test
	void contextLoads() {
	}

	@Test
	public void testMainMethodArgument() {
		Method mainMethod = null;
		try {
			mainMethod = JiveApplication.class.getMethod("main", String[].class);
		} catch (NoSuchMethodException e) {
			fail("main method not found");
		}
		assertNotNull(mainMethod);
	}
//	@Test
//	public void testSpringApplicationRun() throws NoSuchMethodException {
//		Method method = JiveApplication.class.getMethod("main", String[].class);
//		assertTrue(Modifier.isStatic(method.getModifiers()));
//
//		SpringApplication app = new SpringApplication(JiveApplication.class);
//		app.run();
//	}






	@Test
	public void testSpringBootApplicationAnnotation() {
		assertTrue(JiveApplication.class.isAnnotationPresent(SpringBootApplication.class));
	}



}
