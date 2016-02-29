package net.redirectme.per;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;

import net.redirectme.per.calificador.CalificadorApplication;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CalificadorApplication.class)
@WebAppConfiguration
public class CalificadorApplicationTests {

	@Test
	public void contextLoads() {
	}

}

