package es.cic.taller.ejercicio09;

import com.vaadin.ui.Button;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.TextField;

public class Botones extends GridLayout {
	

	public Botones(int columnas, int filas) {
		super(columnas,filas);
		addStyleName("lined");
        setSpacing(true);
        

	}
	
	public void getBotones() {
		addComponents(new Button("Mus"), new Button("Paso"),new Button("Ordago"),new Button("Envidar"),
				new Button("Cortar"),new Button("Cerrar"), new Button("No querer"),new TextField() );
			
		
	}
}
