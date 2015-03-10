package Interfce_Grafica;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Exception.ProfessorInexistenteException;
import Exception.QuestaoInexistenteException;
import Gerente.Gerente;

public class TelaAlteraResposta extends JFrame implements ActionListener{

	private JButton ok, cancela;
	private JTextField nome, resposta, novaResposta, nomeExercicio;
	private JTextField a, b, c , d, e, f;
	private Menu menu;
	private Gerente gerente;
	private Container container;
	
	public TelaAlteraResposta(Menu menu, Gerente gerente){
		super("Cadastrar Exercício");
		
		this.menu = menu;
		this.gerente = gerente;
		this.ok = new JButton("OK");
		this.ok.addActionListener(this);
		this.cancela = new JButton("Cancela");
		this.cancela.addActionListener(this);
		this.inicializandoJTextField();
		
		container = this.getContentPane();
		container.setLayout(new GridLayout(14,2,0,4));
		
		container.add(new JLabel("Nome do professor:"));
		container.add(this.nome);
		container.add(new JLabel("Nome do Exercicio:"));
		container.add(this.nomeExercicio);
		
		container.add(new JLabel("Resposta:"));
		container.add(this.resposta);
		container.add(new JLabel("Nova Resposta:"));
		container.add(this.novaResposta);
		
		container.add(new JLabel("Letras (Se a questao for dissetativa basta"));
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
		
		container.add(new JLabel(""));
		container.add(new JLabel(""));
		
		Container c = new JPanel();
		c.setLayout(new FlowLayout());
		c.add(this.ok);
		c.add(this.cancela);
		container.add(c);
	}
	
	public void inicializandoJTextField(){
		this.nome = new JTextField();
		this.resposta = new JTextField();
		this.nomeExercicio = new JTextField();
		this.novaResposta = new JTextField();
		
		this.a = new JTextField();
		this.b = new JTextField();
		this.c = new JTextField();
		this.d = new JTextField();
		this.e = new JTextField();
		this.f = new JTextField();
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.ok){
			try {
				this.gerente.setPergunta(nome.getText(), nomeExercicio.getText(), novaResposta.getText(), resposta.getText());
			} catch (ProfessorInexistenteException e1) {
				
			} catch (QuestaoInexistenteException e1) {
				
			}
		}else{
			this.menu.setMenu(this.menu.getTelaPesquisa());
		}
		this.nome.setText("");
		this.resposta.setText("");
		this.novaResposta.setText("");
		this.nomeExercicio.setText("");
		this.a.setText("");
		this.b.setText("");
		this.c.setText("");
		this.d.setText("");
		this.e.setText("");
		this.f.setText("");
	}

	public Container getTelaAlteraPergunta() {
		return this.container;
	}
}
