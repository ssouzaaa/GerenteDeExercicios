package Interfce_Grafica;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
		super("Cadastra Exercício");
		
		this.menu = menu;
		this.gerente = gerente;
		this.ok = new JButton("OK");
		this.ok.addActionListener(this);
		this.cancela = new JButton("Cancela");
		this.cancela.addActionListener(this);
		this.inicializandoJTextField();
		
		container = this.getContentPane();
		container.setLayout(new GridLayout(14,2,0,4));
		
		container.add(new JLabel("Nome do professor;"));
		container.add(this.nome);
		container.add(new JLabel("Nome do Exercicio;"));
		container.add(this.nomeExercicio);
		
		container.add(new JLabel("Resposta;"));
		container.add(this.resposta);
		container.add(new JLabel("Nova Resposta;"));
		container.add(this.novaResposta);
		
		container.add(new JLabel("Informe todos os campos acima."));
		container.add(new JLabel(""));

		Container c = new JPanel();
		c.setLayout(new FlowLayout());
		c.add(this.ok);
		c.add(this.cancela);
		container.add(c);
		for(int i = 0; i < 14; i++){
			container.add(new JLabel(""));
		}
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
			if(this.novaResposta.getText().equalsIgnoreCase("") ||this.resposta.getText().equalsIgnoreCase("") || this.nome.getText().equalsIgnoreCase("") || this.nomeExercicio.getText().equalsIgnoreCase("")){
				JOptionPane.showMessageDialog(null, "Informe o campo que falta!");
				return;
			}
			try {
				this.gerente.setResposta(nome.getText(), nomeExercicio.getText(), novaResposta.getText(), resposta.getText());
				this.gerente.gravarExercicio();
				JOptionPane.showMessageDialog(null, "Respostar alterada com sucesso");
			} catch (ProfessorInexistenteException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			} catch (QuestaoInexistenteException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
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
