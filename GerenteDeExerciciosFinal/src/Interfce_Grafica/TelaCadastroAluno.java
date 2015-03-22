package Interfce_Grafica;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Exception.AlunoJaExisteException;
import Gerente.Gerente;

public class TelaCadastroAluno extends JFrame implements ActionListener{

	private JButton ok, cancela;
	private JTextField nome, matricula;
	private Gerente gerente;
	private Container container;
	private Menu menu;
	
	public TelaCadastroAluno(Menu menu, Gerente gerente){
		super("Cadastrar Aluno");
		this.gerente = gerente;
		this.menu = menu;
		this.container = this.getContentPane();
		this.container.setLayout(new GridLayout(14,2,2,4));
		
		this.nome = new JTextField();
		this.matricula = new JTextField();
		this.ok = new JButton("Cadastrar");
		this.ok.addActionListener(this);
		this.cancela = new JButton("Cancelar");
		this.cancela.addActionListener(this);
		
		container.add(new JLabel("Nome do Aluno:"));
		container.add(this.nome);
		container.add(new JLabel(""));
		container.add(new JLabel(""));
		container.add(new JLabel("Matricula:"));
		container.add(this.matricula);
		container.add(new JLabel(""));
		container.add(new JLabel(""));
		
		container.add(this.ok);
		container.add(this.cancela);
		container.add(new JLabel(""));
		container.add(new JLabel(""));
		
		for(int i = 0; i < 43; i++){
			container.add(new JLabel(""));
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 300);
	}
	
	public Container getTelaCadastroAluno(){
		return this.container;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.ok){
			if(this.nome.getText().equalsIgnoreCase("") || this.matricula.getText().equalsIgnoreCase("")){
				JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos!");
				return;
			}
			try {
				this.gerente.cadastrarAluno(nome.getText(), matricula.getText());
				this.gerente.gravarAluno();
				JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso!  " + nome.getText());
			} catch (AlunoJaExisteException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
			this.nome.setText("");
			this.matricula.setText("");
		}else{
			this.nome.setText("");
			this.matricula.setText("");
			this.menu.setMenu(this.menu.getTelaPesquisa());
		}
	}
}
