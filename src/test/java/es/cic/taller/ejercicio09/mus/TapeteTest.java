package es.cic.taller.ejercicio09.mus;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TapeteTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetPuntuacion() {
		
		Baraja baraja = new Baraja();
		Tapete tapete = baraja.getTapete();
		
		Carta carta1 = tapete.getCarta1();
		Carta carta2 = tapete.getCarta2();
		Carta carta3 = tapete.getCarta3();
		Carta carta4 = tapete.getCarta4();
		
		int resultadoEsperado = 
				carta1.getNumero().getValor()+	
				carta2.getNumero().getValor()+
				carta3.getNumero().getValor()+
				carta4.getNumero().getValor();
		
		int puntuacion = tapete.getPuntuacion();
		
		assertEquals(resultadoEsperado,puntuacion);
	}

}
