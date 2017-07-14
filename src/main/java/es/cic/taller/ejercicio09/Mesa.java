package es.cic.taller.ejercicio09;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;


public class Mesa extends GridLayout{
	
	private Puntuacion puntuacion = new Puntuacion(3,3);
	private Fases fases = new Fases(2,5);
	private Botones botones = new Botones(4,2);

	public Mesa(int columnas,int filas) {
		super(columnas,filas);
		addStyleName("outlined");
        setSpacing(true);
        setSizeFull();
        
	}
	
	
	public void repartir(TapeteForm t1,TapeteForm t2,TapeteForm t3,TapeteForm t4) {
		puntuacion.generarPuntuación();
		fases.getFases();
		botones.getBotones();
		addComponent(t1, 1, 2);
        addComponent(t2, 0, 1);
        addComponent(t3, 2, 1);
        addComponent(t4, 1, 0);
        addComponent(puntuacion,0,2);
        addComponent(fases,2,2);
        addComponent(botones,1,1);
		
	}
}
	
	