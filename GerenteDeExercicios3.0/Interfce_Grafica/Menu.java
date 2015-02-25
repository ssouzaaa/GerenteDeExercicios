package Interfce_Grafica;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Gerente.Gerente;

public class Menu extends JFrame implements ActionListener{

	private Container container;
	private JButton cadastrar,pesquisar,sair;
	
	private TelaCadastro telaCadastro;
	private TelaPesquisa telaPesquisa;
	
	private Gerente gerente;
	
	public Menu(){
		super("MENU");
		
		this.telaCadastro = new TelaCadastro();
		this.telaPesquisa = new TelaPesquisa();
		this.gerente = new Gerente();
		this.telaCadastro.setMenu(this);
		this.telaCadastro.setGerente(this.gerente);
		this.telaPesquisa.setMenu(this);
		this.telaPesquisa.setGerente(this.gerente);
	}
	public void setMenu(){
		this.cadastrar = new JButton("Cadastrar");
		this.pesquisar = new JButton("Pesquisar");
		this.sair = new JButton("Sair");
		
		this.container = new JPanel();
		
		this.container.setLayout(new GridLayout(3,1,0,3));
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		this.container.add(this.cadastrar);
		this.container.add(this.pesquisar);
		this.container.add(this.sair);
		
		c.add(this.container);
		// ADICIONANDO O EVENTO AO BOTÃO.
		this.cadastrar.addActionListener(this);
		this.pesquisar.addActionListener(this);
		this.sair.addActionListener(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(200,160);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.cadastrar){
			this.setVisible(false);
			this.telaCadastro.setVisible(true);
		}else if(e.getSource() == this.pesquisar){
			this.setVisible(false);
			this.telaPesquisa.setVisible(true);
		}else{
			System.exit(0);
		}
	}
	public static void main(String[] args){
		Menu m = new Menu();
		m.setMenu();
	}
}


