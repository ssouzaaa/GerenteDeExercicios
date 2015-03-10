package Interfce_Grafica;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import Gerente.Gerente;

public class TelaCadastroQuestao extends JFrame implements ActionListener{

	private JButton ok, cancela;
	private JTextField nome, pergunta, resposta, nomeExercicio, tipoQuestao;
	private JTextField a, b, c , d, e, f;
	private JTextField aR, bR, cR , dR, eR, fR;
	private Gerente gerente;
	private Container container;
	private Menu menu;
	
	public TelaCadastroQuestao(Menu menu, Gerente gerente){
		super("Cadastrar Questão");
		
		this.menu = menu;
		this.gerente = gerente;
		this.ok = new JButton("Cadastrar");
		this.ok.addActionListener(this);
		this.cancela = new JButton("Cancela");
		this.cancela.addActionListener(this);
		
		this.inicializandoJTextField();
		
		this.container = this.getContentPane();
		this.container.setLayout(new GridLayout(20,2,0,4));
		this.addAoContainer();
		
		setSize(500,600);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.ok){
			String pergunta = this.pergunta.getText() + "\n" + this.a.getText() + "\n" + this.b.getText() + "\n" + this.c.getText() + "\n" + this.d.getText() + "\n" + this.e.getText() + "\n" + this.f.getText() + "\n";
			String resposta = this.resposta.getText() + "\n" + this.aR.getText() + "\n" + this.bR.getText() + "\n" + this.cR.getText() + "\n" + this.dR.getText() + "\n" + this.eR.getText() + "\n" + this.fR.getText() + "\n";
			this.gerente.cadastrasQuestao(this.nome.getText(), nomeExercicio.getText(), tipoQuestao.getText(), pergunta, resposta);
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
		this.aR.setText("");
		this.bR.setText("");
		this.cR.setText("");
		this.dR.setText("");
		this.eR.setText("");
		this.fR.setText("");
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
		
		this.aR = new JTextField();
		this.bR = new JTextField();
		this.cR = new JTextField();
		this.dR = new JTextField();
		this.eR = new JTextField();
		this.fR = new JTextField();
	}
	
	public void addAoContainer(){
		container.add(new JLabel("Nome do professor:"));
		container.add(this.nome);
		container.add(new JLabel("Nome do Exercicio:"));
		container.add(this.nomeExercicio);
		container.add(new JLabel("Tipo de Questão:"));
		container.add(this.tipoQuestao);
		
		container.add(new JLabel("Pergunta:"));
		container.add(this.pergunta);
		container.add(new JLabel("Letras (Se a questao for dissertativa basta"));
		container.add(new JLabel("deixar em branco.)"));
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
		container.add(new JLabel("Respostar;"));
		container.add(new JLabel(""));
		container.add(new JLabel("Letras (Se a questao for dissertativa basta"));
		container.add(new JLabel("deixar em branco.)"));
		container.add(this.aR);
		container.add(new JLabel(""));
		container.add(this.bR);
		container.add(new JLabel(""));
		container.add(this.cR);
		container.add(new JLabel(""));
		container.add(this.dR);
		container.add(new JLabel(""));
		container.add(this.eR);
		container.add(new JLabel(""));
		container.add(this.fR);
		container.add(new JLabel(""));
		container.add(this.ok);
		container.add(this.cancela);
	}
}