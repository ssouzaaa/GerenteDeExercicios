package Interfce_Grafica;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import Exception.AlunoNaoExisteException;
import Gerente.Gerente;

public class TelaExercicio extends JFrame implements ActionListener{

	private List<List<String>> exercicio;
	private List<JTextField> respostaAluno;
	private Container c;
	private JTextField matricula;
	private JButton ok;
	private Gerente gerente;
	private Menu menu;
	
	public TelaExercicio(Gerente gerente, Menu menu){
		super("Exercício");
		this.respostaAluno = new ArrayList<>();
		
		this.gerente = gerente;
		this.menu = menu;
		this.ok = new JButton("Ok");
		this.matricula = new JTextField();
		this.ok.addActionListener(this);
		
		c = this.getContentPane();
		this.c.add(new JPanel());
		this.setSize(600, 500);
	}
	
	public void criarExercicio( List<List<String>> exercicio){
		this.c.removeAll();
		this.c.repaint();
		this.exercicio = exercicio;
		JPanel painel = new JPanel();
		painel.setSize(400, 500);
		painel.setPreferredSize(new Dimension(0,(this.exercicio.size() + 2) * 75));  
		  
		painel.setLayout(new GridLayout((this.exercicio.size()*2)+3,1));
		JScrollPane scroll = new JScrollPane();
		//scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);  
		//scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);  
		scroll.setViewportBorder(BorderFactory.createLoweredBevelBorder());  
		scroll.setAutoscrolls(true);  
		scroll.setViewportView(painel);  
		c.add(scroll);
		List<String> list = this.exercicio.get(0);
		for(int i = 0; i < list.size(); i++){
			painel.add(new JLabel(list.get(i)));
			
			JTextField resposta = new JTextField();
			painel.add(resposta);
			this.respostaAluno.add(i, resposta);
		}
		painel.add(new JLabel("Matricula: "));
		painel.add(this.matricula);
		
		Container c1 = new JPanel();
		c1.setLayout(new FlowLayout());
		c1.add(this.ok);
		painel.add(c1);
		
	}

	public void actionPerformed(ActionEvent e) {
		if(this.gerente.isMatricula(this.matricula.getText())){
			this.menu.setMenu(this.menu.getTelaPesquisa());
			List<String> respostaAluno = new ArrayList<>();
			for(JTextField j : this.respostaAluno){
				respostaAluno.add(j.getText());
			}
			String prova = this.gerente.getCorrecaoExercicio(this.exercicio.get(0), this.exercicio.get(1), respostaAluno);
			try {
				this.gerente.setProvaAluno(matricula.getText(), prova);
				this.menu.setTextoPesquisa(prova);
				this.setVisible(false);
				this.menu.setVisible(true);
				try {
					this.gerente.gravarAluno();
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			} catch (AlunoNaoExisteException e2) {
			}
		}else{
			JOptionPane.showMessageDialog(null, "Matricla não existe " + this.matricula.getText());
		}
	}
}