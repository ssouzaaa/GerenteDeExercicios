package Eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Interfce_Grafica.Menu;
import Interfce_Grafica.TelaExercicio;

public class EventoSorteaExercicio implements ActionListener{

	private Menu menu;
	private TelaExercicio tela;
	
	public EventoSorteaExercicio(Menu menu, TelaExercicio tela){
		this.menu = menu;
		this.tela = tela;
	}
	
	public void actionPerformed(ActionEvent e) {
		this.menu.criarExercicio();
	}
}