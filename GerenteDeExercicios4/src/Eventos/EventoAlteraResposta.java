package Eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Interfce_Grafica.Menu;

public class EventoAlteraResposta implements ActionListener{

	private Menu menu;
	
	public EventoAlteraResposta(Menu menu){
		this.menu = menu;
	}
	
	public void actionPerformed(ActionEvent e) {
		this.menu.setMenu(this.menu.getTelaAlteraResposta());
	}
}