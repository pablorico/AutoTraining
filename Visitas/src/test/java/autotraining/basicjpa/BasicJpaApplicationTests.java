package autotraining.basicjpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;

import visitas.VisitasApplication;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = VisitasApplication.class)
@WebAppConfiguration
public class BasicJpaApplicationTests {

	@Test
	public void contextLoads() {
	}

}
