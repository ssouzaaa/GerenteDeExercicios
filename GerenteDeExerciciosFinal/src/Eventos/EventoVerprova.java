package Eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Gerente.Gerente;
import Interfce_Grafica.Menu;

public class EventoVerprova implements ActionListener{

	private Menu menu;
	private Gerente gerente;
	
	public EventoVerprova(Menu menu, Gerente gerente){
		this.gerente = gerente;
		this.menu = menu;
	}
	public void actionPerformed(ActionEvent arg0) {
		this.menu.setMenu(this.menu.getTelaPesquisa());
		this.menu.setTextoPesquisa(this.gerente.getProfessor().getFeedback());
	}
}