package es.cic.taller.ejercicio09.mus;

import java.util.*;

public class Tapete {
	private Carta carta1;
	private Carta carta2;
	private Carta carta3;
	private Carta carta4;
	

	public Carta getCarta1() {
		return carta1;
	}
	public void setCarta1(Carta carta1) {
		this.carta1 = carta1;
	}
	public Carta getCarta2() {
		return carta2;
	}
	public void setCarta2(Carta carta2) {
		this.carta2 = carta2;
	}
	public Carta getCarta3() {
		return carta3;
	}
	public void setCarta3(Carta carta3) {
		this.carta3 = carta3;
	}
	public Carta getCarta4() {
		return carta4;
	}
	public void setCarta4(Carta carta4) {
		this.carta4 = carta4;
	}

	public int getPuntuacion() {
		return 
				carta1.getNumero().getValor()+	
				carta2.getNumero().getValor()+
				carta3.getNumero().getValor()+
				carta4.getNumero().getValor();	
	}
	public static int compararMayor(Tapete tapete1,Tapete tapete2) {
		List<Carta> listaCartasTapete1 = getCartasOrdenadas(tapete1);
		List<Carta> listaCartasTapete2 = getCartasOrdenadas(tapete1);

		int resultado=0;

		for(int i = 0 ; i< listaCartasTapete1.size(); i++) {
			int numero1 = listaCartasTapete1.get(i).getNumero().getNumeroReal();
			int numero2 = listaCartasTapete2.get(i).getNumero().getNumeroReal();
			if( numero1!=numero2) {
				resultado= numero2-numero1;
				break;
			}

		}
		return resultado;
	}

	public static int compararMenor(Tapete tapete1,Tapete tapete2) {
		List<Carta> listaCartasTapete1 = getCartasOrdenadas(tapete1);
		List<Carta> listaCartasTapete2 = getCartasOrdenadas(tapete1);

		int resultado=0;

		for(int i =listaCartasTapete1.size()-1 ; i >= 0; i--) {
			int numero1 = listaCartasTapete1.get(i).getNumero().getNumeroReal();
			int numero2 = listaCartasTapete2.get(i).getNumero().getNumeroReal();
			if( numero1!=numero2) {
				resultado= numero1-numero2;
				break;
			}

		}
		return resultado;
	}
	/**
	 * comparamos los pares de dos tapetes mirando quien tiene par, si retorna positivo gana el tapete 1 y si retorna negativo gana el tapete 2 
	 * en caso de que retorne 0 es empate
	 * @param tapete1 mano del jugador 1
	 * @param tapete2 mano del jugador 2
	 * @return resultado que indica quien gana pares o empate
	 */
	public static int compararPar(Tapete tapete1, Tapete tapete2) {
		int numero1;
		int numero2;
		int resultado;
		List<Carta> pares1 = cartasPar(tapete1);
		List<Carta> pares2 =cartasPar(tapete2);

			if(tieneElMismoTipoDePar(pares1, pares2)) {
				
				numero1 = pares1.get(1).getNumero().getNumeroReal();
				numero2 = pares2.get(1).getNumero().getNumeroReal();
				
				if(tieneDuplexConLaPrimeraCartaIgual(numero1, numero2, pares1)) {
					numero1 = pares1.get(3).getNumero().getNumeroReal();
					numero2 = pares2.get(3).getNumero().getNumeroReal();
				}
				resultado = numero2 - numero1;
				
			}else if(esLaPrimeraParejaMayorQueLaSegunda(pares1, pares2)) {
				resultado = -1;
			}else {
				resultado = 1;
			}
		
		return resultado;
	}
	private static boolean esLaPrimeraParejaMayorQueLaSegunda(List<Carta> pares1, List<Carta> pares2) {
		return pares1.size()>pares2.size();
	}
	private static boolean tieneDuplexConLaPrimeraCartaIgual(int numero1, int numero2, List<Carta> pares1) {
		return pares1.size()==4 && numero1== numero2;
	}
	private static boolean tieneElMismoTipoDePar(List<Carta> pares1, List<Carta> pares2) {
		return pares1.size()==pares2.size();
	}
	/**
	 * comparacion de juego entre dos jugadores si retorna positvo gana el 1 si retorna negativo gana el 2 en caso de retornar 0 empate
	 * @param tapete1 mano del jugador 1
	 * @param tapete2 mano del jugador 2
	 * @return resultado que indica quien gana el juego o empate
	 */
	public static int compararJuego(Tapete tapete1, Tapete tapete2) {
		
	
			int juego1 = getValorJuego(tapete1);
			int juego2 = getValorJuego(tapete2);
			int resultado = juego1-juego2;
		
		return resultado;
	}
	
	public static int compararPunto(Tapete tapete1, Tapete tapete2) {
		int punto1 = getValorMano(tapete1);
		int punto2 = getValorMano(tapete2);
		int resultado = punto1-punto2;
		return resultado;
	}
	
	
	
	private static List<Carta> getCartasOrdenadas(Tapete tapete){
		List<Carta> listaCartas = getListaCartas(tapete);


		for (int i=0; i<listaCartas.size()-1;i++) {
			int indiceMayor = i;
			for(int j = i +1; j < listaCartas.size(); j++) {
				if(listaCartas.get(j).getNumero().getNumeroReal()>listaCartas.get(indiceMayor).getNumero().getNumeroReal()) {
					indiceMayor = j;
				}
			}
			Carta aux = listaCartas.get(i);
			listaCartas.set(i, listaCartas.get(indiceMayor));
			listaCartas.set(indiceMayor, aux);
		}
		return listaCartas;
	}

	public static boolean tienePar(Tapete tapete) {
		List<Carta> listaCartas = getListaCartas(tapete);
		boolean Par =false;
		for (int i=0; i<listaCartas.size()-1;i++) {
			for(int j = i +1; j < listaCartas.size(); j++) {
				if(listaCartas.get(j).getNumero().getNumeroReal()==listaCartas.get(i).getNumero().getNumeroReal()) {
					Par = true;
					break;
				}
			}


		}
		return Par;
	}
	private static List<Carta> getListaCartas(Tapete tapete) {
		List<Carta> listaCartas = new ArrayList<>();
		listaCartas.add(tapete.getCarta1());
		listaCartas.add(tapete.getCarta2());
		listaCartas.add(tapete.getCarta3());
		listaCartas.add(tapete.getCarta4());
		return listaCartas;
	}

	private static List<Carta> cartasPar(Tapete tapete) {
		List<Carta> listaCartas = getCartasOrdenadas(tapete);
		List<Carta> cartasPares = new ArrayList<>();
		for (int i=0; i<listaCartas.size()-1;i++) {
			Carta cartaAux1 = listaCartas.get(i);
			Carta cartaAux2 = listaCartas.get(i +1);
			if(cartaAux2.getNumero().getNumeroReal()==cartaAux1.getNumero().getNumeroReal()) {
				if(!cartasPares.contains(cartaAux1)) {
					cartasPares.add(cartaAux1);
					cartasPares.add(cartaAux2);
				}else {
					cartasPares.add(cartaAux2);
				}
			}
		}
		return cartasPares;
	}
	
	public static boolean tieneJuego(Tapete tapete){
		int valorMano = getValorMano(tapete);
		if (valorMano>30) {
			return true;
		}
		return false;
	}
	private static int getValorMano(Tapete tapete) {
		List<Carta> listaCartas = getListaCartas(tapete);
		int valorMano= 0;
		for(int i =0;i<listaCartas.size();i++) {
			valorMano = valorMano +listaCartas.get(i).getNumero().getValor();
		}
		return valorMano;
	}
	
	private static int getValorJuego(Tapete tapete) {
		int juego = getValorMano(tapete);
		switch(juego) {
		case 31:	return 42;
		case 32:	return 41;
		default: return juego;
		}
	}
	

}