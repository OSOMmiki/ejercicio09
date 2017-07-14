package es.cic.taller.ejercicio09.mus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baraja {
	private List<Carta> listaCartas = new ArrayList<>();
	
	private List<Carta> listaMonton = new ArrayList<>();
	
	public Baraja() {
		generarCartas();
	}
	private void generarCartas() {
		listaCartas.addAll(getPalo(Palo.OROS));
		listaCartas.addAll(getPalo(Palo.COPAS));
		listaCartas.addAll(getPalo(Palo.BASTOS));
		listaCartas.addAll(getPalo(Palo.ESPADAS));
		barajear();
	}
	public void tirarAlMonton(List<Carta> descartadas) {
		listaMonton.addAll(descartadas);
	}
	
	private List<Carta> getPalo(Palo palo) {
		
		List<Carta> listaCartasPalo = new ArrayList<>();
		
		for (int i= 1; i <= 10; i++) {
			Carta carta = new Carta();
			Numero numero = Numero.getNumeroReal(i);
			carta.setNumero(numero);
			carta.setPalo(palo);
			listaCartasPalo.add(carta);
		}
		return listaCartasPalo;
	}
	
	public void barajear() {
		Collections.shuffle(listaCartas);
	}
	
	public void resetear() {
		listaCartas.clear();
		listaMonton.clear();
		
		generarCartas();
	}
	
	private Carta getCarta() {
		if (listaCartas.isEmpty()) {
			listaCartas.addAll(listaMonton);
			barajear();
			listaMonton.clear();
		}
		Carta carta = listaCartas.remove(0);
		return carta;		
	}
	
	public Tapete getTapete() {
		Tapete tapete = new Tapete();
		tapete.setCarta1(getCarta());
		tapete.setCarta2(getCarta());
		tapete.setCarta3(getCarta());
		tapete.setCarta4(getCarta());
	
		return tapete;
	}
}
