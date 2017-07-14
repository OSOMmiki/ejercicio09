package es.cic.taller.ejercicio09;

import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;

public class Puntuacion extends GridLayout{
	
	public Puntuacion(int columnas, int filas) {
		super(columnas,filas);
		addStyleName("lined");
        setSpacing(true);
       
	}
	public void generarPuntuación() {
	
		addComponents(new Label("Equipo:"),new Label("Puntos:"),new Label("Juegos:"),new Label("Equipo1:"),new Label("0"),new Label("0"),new Label("Equipo2:"),new Label("0"),new Label("0"));
		
		
	}

}
