package es.cic.taller.ejercicio09;

import java.io.File;

import com.vaadin.server.FileResource;
import com.vaadin.server.Resource;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.TextField;

import es.cic.taller.ejercicio09.mus.Carta;
import es.cic.taller.ejercicio09.mus.Tapete;

public class TapeteForm extends FormLayout {
//	private TextField carta1 = new TextField("Carta 1:");
//	private TextField carta2 = new TextField("Carta 2:");
//	private TextField carta3 = new TextField("Carta 3:");
//	private TextField carta4 = new TextField("Carta 4:");
	
	private HorizontalLayout horizontalLayout = new HorizontalLayout();
	
	private Image imagen1 = new Image();
	private Image imagen2 = new Image();
	private Image imagen3 = new Image();
	private Image imagen4 = new Image();
	private Image mazo = new Image();
	
	
	
	private MyUI myUI;
	
	public TapeteForm(MyUI myUI) {
		this.myUI = myUI;

		horizontalLayout.addComponents(mazo,imagen1, imagen2, imagen3, imagen4);
		
		addComponents(horizontalLayout);
	}
	
	
	
	
	
	
	private Resource getImageResource(String recurso) {
		String basepath = VaadinService.getCurrent()
                .getBaseDirectory().getAbsolutePath();
		FileResource resource = new FileResource(new File(basepath +
                "/images/" + recurso));
        return resource;
	}




	/* Esto es un comentario */
	public void setTapete(Tapete tapete) {
//		carta1.setValue(tapete.getCarta1().toString());
//		carta2.setValue(tapete.getCarta2().toString());
//		carta3.setValue(tapete.getCarta3().toString());
//		carta4.setValue(tapete.getCarta4().toString());
		cargaCarta(tapete.getCarta1(), imagen1);
		cargaCarta(tapete.getCarta2(), imagen2);
		cargaCarta(tapete.getCarta3(), imagen3);
		cargaCarta(tapete.getCarta4(), imagen4);
		cargaCarta(Carta.getMazo(),mazo);
	}
	
	public void setTapeteDorso(Tapete tapete) {
		cargaCarta(Carta.getDorso(),imagen1);
		cargaCarta(Carta.getDorso(),imagen2);
		cargaCarta(Carta.getDorso(),imagen3);
		cargaCarta(Carta.getDorso(),imagen4);
		cargaCarta(Carta.getMazo(),mazo);
	}




	private void cargaCarta(Carta carta, Image imagen) {

		imagen.setSource(getImageResource(carta.getNombreFichero()));
		imagen.setWidth("100px");
		imagen.setHeight("200px");
	}
	
}
