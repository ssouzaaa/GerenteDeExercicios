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

public class TelaAlteraPergunta extends JFrame implements ActionListener{

	private JButton ok, cancela;
	private JTextField nome, pergunta, novaPergunta, nomeExercicio;
	private JTextField a, b, c, d, e, f;
	private JTextField aN, bN, cN, dN, eN, fN;
	private Menu menu;
	private Gerente gerente;
	private Container container;
	
	public TelaAlteraPergunta(Menu menu, Gerente gerente){
		super("Cadastrar Exercício");
		
		this.menu = menu;
		this.gerente = gerente;
		this.ok = new JButton("OK");
		this.ok.addActionListener(this);
		this.cancela = new JButton("Cancelar");
		this.cancela.addActionListener(this);
		this.inicializandoJTextField();
		
		container = this.getContentPane();
		container.setLayout(new GridLayout(18,2,0,4));
		
		container.add(new JLabel("Nome do professor:"));
		container.add(this.nome);
		container.add(new JLabel("Nome do Exercicio:"));
		container.add(this.nomeExercicio);
		
		container.add(new JLabel("Pergunta:"));
		container.add(this.pergunta);
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
		
		
		container.add(new JLabel("Nova Pergunta:"));
		container.add(this.novaPergunta);
		container.add(this.aN);
		container.add(new JLabel(""));
		container.add(this.bN);
		container.add(new JLabel(""));
		container.add(this.cN);
		container.add(new JLabel(""));
		container.add(this.dN);
		container.add(new JLabel(""));
		container.add(this.eN);
		container.add(new JLabel(""));
		container.add(this.fN);
		container.add(new JLabel(""));
		
		container.add(new JLabel("Letras (Se a questao for dissertativa "));
		container.add(new JLabel("por favor deixar em branco.)"));

		Container c = new JPanel();
		c.setLayout(new FlowLayout());
		c.add(this.ok);
		c.add(this.cancela);
		container.add(c);
		container.add(new JLabel(""));
	}
	
	public void inicializandoJTextField(){
		this.nome = new JTextField();
		this.pergunta = new JTextField();
		this.nomeExercicio = new JTextField();
		this.novaPergunta = new JTextField();
		
		this.a = new JTextField();
		this.b = new JTextField();
		this.c = new JTextField();
		this.d = new JTextField();
		this.e = new JTextField();
		this.f = new JTextField();
		
		this.aN = new JTextField();
		this.bN = new JTextField();
		this.cN = new JTextField();
		this.dN = new JTextField();
		this.eN = new JTextField();
		this.fN = new JTextField();
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.ok){
			if(this.novaPergunta.getText().equalsIgnoreCase("") ||this.pergunta.getText().equalsIgnoreCase("") || this.nome.getText().equalsIgnoreCase("") || this.nomeExercicio.getText().equalsIgnoreCase("")){
				JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos!");
				return;
			}
			try {
				String NovaPergunta = this.novaPergunta.getText() + "\n" + this.aN.getText() + "\n" + this.bN.getText() + "\n" + this.cN.getText() + "\n" + this.dN.getText() + "\n" + this.eN.getText() + "\n" + this.fN.getText() + "\n";
				String pergunta = this.pergunta.getText() + "\n" + this.a.getText() + "\n" + this.b.getText() + "\n" + this.c.getText() + "\n" + this.d.getText() + "\n" + this.e.getText() + "\n" + this.f.getText() + "\n";
				this.gerente.setPergunta(nome.getText(), nomeExercicio.getText(), NovaPergunta, pergunta);
				this.gerente.gravarExercicio();
				JOptionPane.showMessageDialog(null, "Pergunta alterada com sucesso! ");
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
		this.pergunta.setText("");
		this.novaPergunta.setText("");
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
