package Interfce_Grafica;

import java.awt.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Dados.Questao;
import Exception.ProfessorInexistenteException;
import Gerente.Gerente;

public class TelaPesquisa extends JFrame implements ActionListener{

	private JButton OK, cancelar;
	private JTextField nomeProfessor;
	private Menu menu;
	private Gerente gerente;
	
	public TelaPesquisa(){
		this.OK = new JButton("OK");
		this.OK.addActionListener(this);
		this.cancelar = new JButton("Cancelar");
		this.cancelar.addActionListener(this);
		
		this.nomeProfessor = new JTextField();
		
		Container c = this.getContentPane();
		
		c.setLayout(new GridLayout(3,2,0,4));
		
		c.add(new JLabel("Nome do Professor:"));
		c.add(this.nomeProfessor);
		c.add(new JLabel());
		c.add(new JLabel());
		c.add(this.OK);
		c.add(this.cancelar);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(300,160);
		setVisible(false);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.OK){
			List<Questao> l;
			try {
				l = this.gerente.getListaExercicioDoprofessor(this.nomeProfessor.getText());
				String toString = new String();
				for(Questao q : l){
					toString += " Pergunta: " + q.getPergunta() + " \n Resposta: " + q.getResposta() + " \n Tipo: " + q.getTipo() + "\n \n";
				}
				JOptionPane.showMessageDialog(null, toString);
			} catch (ProfessorInexistenteException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
			
		}
		this.setVisible(false);
		this.menu.setVisible(true);
		this.nomeProfessor.setText("");
	}
	public void setMenu(Menu menu){
		this.menu = menu;
	}
	public void setGerente(Gerente gerente){
		this.gerente = gerente;
	}
}
