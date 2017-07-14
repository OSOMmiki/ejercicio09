package es.cic.taller.ejercicio09.mus;

public enum Palo {
	OROS("Oros", 1),
	COPAS("Copas", 2),
	BASTOS("Bastos", 3),
	ESPADAS("Espadas", 4),
	ESPECIAL("Especial",5);
	
	private final String texto;
	private final int numero;
	
	
	Palo(String texto, int numero)
	{
		this.texto = texto;
		this.numero = numero;
	}
	
	public String getTexto() {
		return this.texto;
	}
	
	public int getNumero() {
		return this.numero;
	}
	
}
