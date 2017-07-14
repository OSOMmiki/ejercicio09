package es.cic.taller.ejercicio09;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import es.cic.taller.ejercicio09.mus.Baraja;
import es.cic.taller.ejercicio09.mus.Tapete;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

	private TapeteForm tapete1 = new TapeteForm(this);
	private TapeteForm tapete2 = new TapeteForm(this);
	private TapeteForm tapete3 = new TapeteForm(this);
	private TapeteForm tapete4 = new TapeteForm(this);
	private TapeteForm reverso1 = new TapeteForm(this);
	private TapeteForm reverso2 = new TapeteForm(this);
	private TapeteForm reverso3 = new TapeteForm(this);
	private TapeteForm reverso4 = new TapeteForm(this);
	private TapeteForm reverso5 = new TapeteForm(this);
	private TapeteForm reverso6= new TapeteForm(this);
	private TapeteForm reverso7 = new TapeteForm(this);
	private TapeteForm reverso8 = new TapeteForm(this);
	private TapeteForm reverso9 = new TapeteForm(this);
	private TapeteForm reverso10 = new TapeteForm(this);
	private TapeteForm reverso11 = new TapeteForm(this);
	private TapeteForm reverso12 = new TapeteForm(this);
	private Mesa mesa1 = new Mesa(3,3);
	private Mesa mesa2 = new Mesa(3,3);
	private Mesa mesa3 = new Mesa(3,3);
	private Mesa mesa4 = new Mesa(3,3);
	
	
    @Override
    protected void init(VaadinRequest vaadinRequest) {
    	
    	TabSheet sample = new TabSheet();
        sample.setHeight(100.0f, Unit.PERCENTAGE);
        sample.addStyleName(ValoTheme.TABSHEET_FRAMED);
        sample.addStyleName(ValoTheme.TABSHEET_PADDED_TABBAR);
    	
        
        
        Baraja baraja = new Baraja();
        
        Tapete manoTapete1 = baraja.getTapete();
        Tapete manoTapete2 = baraja.getTapete();
        Tapete manoTapete3 = baraja.getTapete();
        Tapete manoTapete4 = baraja.getTapete();
        
        
        tapete1.setTapete(manoTapete1);
        tapete2.setTapete(manoTapete2);
        tapete3.setTapete(manoTapete3);
        tapete4.setTapete(manoTapete4);
        reverso1.setTapeteDorso(manoTapete4);
        reverso2.setTapeteDorso(manoTapete3);
        reverso3.setTapeteDorso(manoTapete2);
        reverso4.setTapeteDorso(manoTapete1);
        reverso5.setTapeteDorso(manoTapete3);
        reverso6.setTapeteDorso(manoTapete4);
        reverso7.setTapeteDorso(manoTapete1);
        reverso8.setTapeteDorso(manoTapete2);
        reverso9.setTapeteDorso(manoTapete4);
        reverso10.setTapeteDorso(manoTapete1);
        reverso11.setTapeteDorso(manoTapete2);
        reverso12.setTapeteDorso(manoTapete3);
        
        mesa1.repartir(tapete1, reverso1, reverso2, reverso3);
        mesa2.repartir(tapete2, reverso4, reverso5, reverso6);
        mesa3.repartir(tapete3, reverso7, reverso8, reverso9);
        mesa4.repartir(tapete4, reverso10, reverso11, reverso12);
    	
        sample.addTab(mesa1, "Jugador1");
        sample.addTab(mesa2, "Jugador2");
        sample.addTab(mesa3, "Jugador3");
        sample.addTab(mesa4, "Jugador4");
    	
        setContent(sample);
   
        
        
        
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }

       
    }

