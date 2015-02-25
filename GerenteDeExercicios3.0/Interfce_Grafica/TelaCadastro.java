package Interfce_Grafica;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import Gerente.Gerente;

public class TelaCadastro extends JFrame implements ActionListener{

	private JButton ok, cancelar;
	private JTextField nome, pergunta, resposta, tipo;
	private Menu menu;
	private Gerente gerente;
	
	public TelaCadastro(){
		super("Cadastrar Questão");
		
		this.ok = new JButton("OK");
		this.ok.addActionListener(this);
		this.cancelar = new JButton("Cancelar");
		this.cancelar.addActionListener(this);
		
		this.nome = new JTextField();
		this.pergunta = new JTextField();
		this.resposta = new JTextField();
		this.tipo = new JTextField();
		
		Container c = this.getContentPane();
		
		c.setLayout(new GridLayout(5,2,0,4));
		
		c.add(new JLabel("Nome do professor:"));
		c.add(this.nome);
		c.add(new JLabel("Pergunta:"));
		c.add(this.pergunta);
		c.add(new JLabel("Resposta:"));
		c.add(this.resposta);
		c.add(new JLabel("Tipo questão:"));
		c.add(this.tipo);
		c.add(this.ok);
		c.add(this.cancelar);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(300,160);
		setVisible(false);
	}
	public void setMenu(Menu menu){
		this.menu = menu;
	}
	public void setGerente(Gerente gerente){
		this.gerente = gerente;
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.ok){
			this.gerente.cadastrasQuestao(this.nome.getText(), this.pergunta.getText(), this.resposta.getText(), this.tipo.getText());
			this.setVisible(false);
			this.menu.setVisible(true);
		}else{
			this.setVisible(false);
			this.menu.setVisible(true);
			this.nome.setText("");
			this.pergunta.setText("");
			this.resposta.setText("");
			this.tipo.setText("");
		}
	}
}
