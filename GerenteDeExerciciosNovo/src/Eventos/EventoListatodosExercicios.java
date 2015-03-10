package Eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Gerente.Gerente;
import Interfce_Grafica.*;

public class EventoListatodosExercicios implements ActionListener{
	
	private Menu menu;
	private Gerente gerente;
	
	public EventoListatodosExercicios(Menu menu, Gerente gerente){
		this.menu = menu;
		this.gerente = gerente;
	}
	
	public void actionPerformed(ActionEvent e) {
		this.menu.setTextoPesquisa("");
		this.menu.setTextoPesquisa(this.gerente.getListaTodosExercicio());
		this.menu.setMenu(this.menu.getTelaPesquisa());
	}
}