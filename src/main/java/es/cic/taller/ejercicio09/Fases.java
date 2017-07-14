package es.cic.taller.ejercicio09;

import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;

public class Fases extends GridLayout {
	
	public Fases(int columnas, int filas) {
		super(columnas,filas);
		addStyleName("lined");
        setSpacing(true);
        
	}
	
	public void getFases() {
		addComponents(new Label("Grande:"),new Label(" "),
					new Label("Pequeña:"),new Label(" "),	
					new Label("Par:"),new Label(" "),
					new Label("Juego:"),new Label(" "),
					new Label("Punto:"),new Label(" "));
		
		
	}
	

}
