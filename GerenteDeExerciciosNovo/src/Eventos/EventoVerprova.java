package Eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Exception.AlunoNaoExisteException;
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
		String matricula = JOptionPane.showInputDialog(null, "Matricula");
		try {
			this.menu.setTextoPesquisa(this.gerente.getProvaAluno(matricula));
		} catch (AlunoNaoExisteException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}