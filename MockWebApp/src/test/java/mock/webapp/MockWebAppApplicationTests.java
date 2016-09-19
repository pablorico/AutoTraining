package mock.webapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
/*
@SpringApplicationConfiguration(classes = MockWebAppApplication.class)
Se reemplaza por @SpringBootTest
*/
@SpringBootTest
@WebAppConfiguration
public class MockWebAppApplicationTests {

	@Test
	public void contextLoads() {
	}

}
