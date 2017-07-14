package es.cic.taller.ejercicio09.mus;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class BarajaTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testTirarAlMonton() {
		Baraja cut = new Baraja();
		List <Carta> devueltas = new ArrayList<>();
		devueltas.add(Carta.getDorso());
			cut.tirarAlMonton(devueltas);
		
		
	}


	@Test
	public void testBarajear() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTapete() {
		fail("Not yet implemented");
	}

}
