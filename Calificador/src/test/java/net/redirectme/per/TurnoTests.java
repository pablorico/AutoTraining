package net.redirectme.per;

import static org.junit.Assert.assertEquals;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;

import net.redirectme.per.calificador.Turno;


import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Turno.class)
@WebAppConfiguration
public class TurnoTests {

	@Test
	public void testGetTurno() {
		
		assertEquals("Noche",Turno.getTurno(System.currentTimeMillis()));		
	}
}
