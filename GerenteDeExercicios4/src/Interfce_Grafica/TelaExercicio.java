package Interfce_Grafica;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Gerente.Gerente;

public class TelaExercicio extends JFrame implements ActionListener{

	private List<List<String>> exercicio;
	private List<JTextField> resposta;
	private Container container, c;
	private int cont;
	private JButton ok;
	private Gerente gerente;
	
	public TelaExercicio(Gerente gerente){
		super("Exercício");
		this.resposta = new ArrayList<>();
		this.container = new JPanel();
		this.cont = 0;
		
		this.gerente = gerente;
		this.ok = new JButton("Ok");
		this.ok.addActionListener(this);
		
		c = this.getContentPane();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		setVisible(false);
	}
	
	public void motandoExercicio(List<List<String>> exercicio){
		this.container.removeAll();
		this.container.repaint();
		this.exercicio = exercicio;
		List<String> list = this.exercicio.get(0);
		for(int i = 0; i < list.size(); i++){
			this.container.setLayout(new GridLayout(list.size()+2,1));
			this.container.add(new JLabel(list.get(i)));
			JTextField resposta = new JTextField();
			this.container.add(resposta);
			this.resposta.add(this.cont, resposta);
			this.cont++;
		}
		this.c.add(container);
		Container c1 = new JPanel();
		c1.setLayout(new FlowLayout());
		c1.add(this.ok);
		this.c.add(c1);
	}

	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, this.gerente.getNotaExercicio(this.exercicio.get(0), this.exercicio.get(1)));
	}

	public Container getTelaExercicio() {
		return this.container;
	}
}