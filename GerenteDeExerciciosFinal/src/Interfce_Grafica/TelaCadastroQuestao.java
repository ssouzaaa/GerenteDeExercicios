package Interfce_Grafica;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

import Gerente.Gerente;

public class TelaCadastroQuestao extends JFrame implements ActionListener{

	private JButton ok, cancela;
	private JTextField nome, pergunta, resposta, nomeExercicio, tipoQuestao;
	private JTextField a, b, c , d, e, f;
	private Gerente gerente;
	private Container container;
	private Menu menu;
	
	public TelaCadastroQuestao(Menu menu, Gerente gerente){
		super("Cadastrar Questão");
		
		this.menu = menu;
		this.gerente = gerente;
		this.ok = new JButton("Cadastrar");
		this.ok.addActionListener(this);
		this.cancela = new JButton("Cancelar");
		this.cancela.addActionListener(this);
		
		this.inicializandoJTextField();
		
		this.container = this.getContentPane();
		this.container.setLayout(new GridLayout(20,2,2,4));
		this.addAoContainer();
		
		setSize(500,600);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.ok){
			if(this.resposta.getText().equalsIgnoreCase("") || this.pergunta.getText().equalsIgnoreCase("") || this.nome.getText().equalsIgnoreCase("") || this.nomeExercicio.getText().equalsIgnoreCase("")){
				JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos!");
				return;
			}
			String pergunta = this.pergunta.getText() + "\n" + this.a.getText() + "\n" + this.b.getText() + "\n" + this.c.getText() + "\n" + this.d.getText() + "\n" + this.e.getText() + "\n" + this.f.getText() + "\n";
			String resposta = this.resposta.getText() + "\n";
			this.gerente.cadastrarQuestao(this.nome.getText(), nomeExercicio.getText(), tipoQuestao.getText(), pergunta, resposta);
			JOptionPane.showMessageDialog(null, "Questão cadastrada com sucesso!  " + nome.getText());
			try {
				this.gerente.gravarExercicio();
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		}else{
			this.menu.setMenu(this.menu.getTelaPesquisa());
		}
		this.tipoQuestao.setText("");
		this.pergunta.setText("");
		this.a.setText("");
		this.b.setText("");
		this.c.setText("");
		this.d.setText("");
		this.e.setText("");
		this.f.setText("");
		this.resposta.setText("");
	}
	
	public Container getTelaCadastro(){
		return this.container;
	}
	
	public void inicializandoJTextField(){
		this.nome = new JTextField();
		this.pergunta = new JTextField();
		this.resposta = new JTextField();
		this.nomeExercicio = new JTextField();
		this.tipoQuestao = new JTextField();
		
		this.a = new JTextField();
		this.b = new JTextField();
		this.c = new JTextField();
		this.d = new JTextField();
		this.e = new JTextField();
		this.f = new JTextField();
	}
	
	public void addAoContainer(){
		container.add(new JLabel("Nome do professor:"));
		container.add(this.nome);
		container.add(new JLabel("Nome do Exercicio:"));
		container.add(this.nomeExercicio);
		container.add(new JLabel("Tipo Questão:"));
		container.add(this.tipoQuestao);
		
		container.add(new JLabel("Pergunta:"));
		container.add(this.pergunta);
		container.add(new JLabel("Letras (Se a questao for dissertativa "));
		container.add(new JLabel("por favor deixar em branco.)"));
		container.add(this.a);
		container.add(new JLabel(""));
		container.add(this.b);
		container.add(new JLabel(""));
		container.add(this.c);
		container.add(new JLabel(""));
		container.add(this.d);
		container.add(new JLabel(""));
		container.add(this.e);
		container.add(new JLabel(""));
		container.add(this.f);
		container.add(new JLabel(""));
		container.add(new JLabel("Resposta:"));
		
		container.add(this.resposta);
		for(int i = 0; i < 14; i++){
			container.add(new JLabel(""));
		}
		container.add(this.ok);
		container.add(this.cancela);
	}
}