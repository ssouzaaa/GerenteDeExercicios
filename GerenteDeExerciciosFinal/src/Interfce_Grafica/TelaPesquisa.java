package Interfce_Grafica;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Exception.ProfessorInexistenteException;
import Gerente.Gerente;

public class TelaPesquisa extends JFrame implements ActionListener{

	private JButton pesquisaButao, cancela;
	private JTextField nome, nomeExercicio;
	private JTextArea texto;
	private Gerente gerente;
	private Container c;
	
	public TelaPesquisa(Gerente gerente){
		super("Resultados da Pesquisa");
		this.gerente = gerente;
		this.pesquisaButao = new JButton("Pesquisar");
		this.pesquisaButao.addActionListener(this);
		this.cancela = new JButton("Cancelar");
		this.cancela.addActionListener(this);
		
		this.nome = new JTextField();
		this.nomeExercicio = new JTextField();
		
		this.texto = new JTextArea();
		JScrollPane barraRolagem = new JScrollPane(texto);
		this.texto.setText("  Informe os campos acima para pesquisar \n as questões do exercício ou apenas o \n nome do professor e pesquise todos exercícios dele. \n ");
		c = getContentPane();
		
		Container c1 = new Container();
		c1.setLayout(new GridLayout(3,2));
		
		c1.add(new JLabel("Nome do Professor:"));
		c1.add(this.nome);
		c1.add(new JLabel("Nome do Exercicio:"));
		c1.add(this.nomeExercicio);
		
		Container c2 = new Container();
		c2.setLayout(new FlowLayout());
		c2.add(this.pesquisaButao);
		c2.add(this.cancela);
		c1.add(c2);
		
		c.add(BorderLayout.NORTH, c1);
		c.add(BorderLayout.CENTER, barraRolagem);
	}
	
	public Container getTelaPesquisa(){
		return this.c;
	}
	
	public void setTexto(String texto){
		this.texto.setText(texto);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.pesquisaButao){
			this.texto.setText("");
			if(this.nomeExercicio.getText().equals("")){
				try {
					this.texto.setText(this.gerente.getListaDosNomesExerc(this.nome.getText()));
				} catch (ProfessorInexistenteException e1) {
					this.texto.setText(e1.getMessage());
				}
			}else{
				try {
					String toString = " Nome Exercicio: " + this.nomeExercicio.getText() + "\n \n";
					toString += this.gerente.getListaExercicio(nome.getText(), nomeExercicio.getText());
					this.texto.setText(toString);
				} catch (ProfessorInexistenteException e1) {
					this.texto.setText(e1.getMessage());
				}
			}
		}else{
			this.texto.setText("  Informe os campos acima para pesquisar \n as questões do exercício ou apenas o \n nome do professor e pesquise todos exercícios dele. \n ");
		}
		this.nome.setText("");
		this.nomeExercicio.setText("");
	}
}