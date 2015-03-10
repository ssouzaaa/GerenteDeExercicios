package Interfce_Grafica;

import java.awt.*;

import javax.swing.*;

import Eventos.*;
import Exception.ListaVaziaExeception;
import Gerente.Gerente;

public class Menu extends JFrame {

	private Container container, c;
	private JButton cadastraExercicio, cadastraQuestao, cadastraAluno, alteraPergunta, alteraResposta;
	private JButton listaExerCasda, sorteaExecicio, verprova, sair;
	
	private EventoCadastraExercicio eventoCadastraExercicio; 
	private EventoCadastraQuestao eventoCadastraQuestao;
	private EventoCadastraAluno eventoCadastraAluno;
	private EventoAlteraPergunta eventoAlteraPergunta;
	private EventoAlteraResposta eventoAlteraResposta;
	private EventoListatodosExercicios eventoListaExerCasda;
	private EventoSorteaExercicio eventoSorteaExecicio;
	private EventoVerprova eventoVerProva;
	private EventoSair eventoSair;
	
	private JFrame telaCadastro;
	private JFrame telaPesquisa;
	private JFrame telaAlteraPergunata;
	private JFrame telaAlteraResposta;
	private JFrame telaExercicio;
	private JFrame telaCadastroAluno;
	
	private Gerente gerente;
	
	public Menu(){
		super("MENU");
		this.gerente = new Gerente();
		this.telaCadastro = new TelaCadastroQuestao(this, this.gerente);
		this.telaPesquisa = new TelaPesquisa(this.gerente);
		this.telaAlteraPergunata = new TelaAlteraPergunta(this, this.gerente);
		this.telaAlteraResposta = new TelaAlteraResposta(this, this.gerente);
		this.telaExercicio = new TelaExercicio(this.gerente, this);
		this.telaCadastroAluno = new TelaCadastroAluno(this, this.gerente);
		this.inicializandoButao();
		this.inicializaEvento();
		this.addEventoAoBotao();
		this.container = new JPanel();
		this.container.setLayout(new GridLayout(17,1,0,3));
		this.c = getContentPane(); 
		this.addAoAoContainer();
		this.c.add(BorderLayout.WEST, this.container);
		
		TelaPesquisa t = (TelaPesquisa) this.telaPesquisa;
		this.c.add(BorderLayout.EAST, t.getTelaPesquisa());
	}
	
	public void setMenu(JFrame tela){
		this.c.remove(1);
		this.c.repaint();
		if(tela instanceof TelaCadastroQuestao){
			TelaCadastroQuestao t = (TelaCadastroQuestao) tela;
			this.c.add(BorderLayout.EAST, t.getTelaCadastro());
		}else if(tela instanceof TelaPesquisa){
			TelaPesquisa t = (TelaPesquisa) tela;
			this.c.add(BorderLayout.EAST, t.getTelaPesquisa());
		}else if(tela instanceof TelaAlteraPergunta){
			TelaAlteraPergunta t = (TelaAlteraPergunta) tela;
			this.c.add(BorderLayout.EAST, t.getTelaAlteraPergunta());
		}else if(tela instanceof TelaAlteraResposta){
			TelaAlteraResposta t = (TelaAlteraResposta) tela;
			this.c.add(BorderLayout.EAST, t.getTelaAlteraPergunta());
		}else if(tela instanceof TelaCadastroAluno){
			TelaCadastroAluno t = (TelaCadastroAluno) tela;
			this.c.add(BorderLayout.EAST, t.getTelaCadastroAluno());
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(635,600);
		setVisible(true);
	}
	
	private void inicializandoButao(){
		this.cadastraExercicio = new JButton("Cadastra Exercicio");
		this.cadastraQuestao = new JButton("Cadastra Questão");
		this.cadastraAluno = new JButton("Cadastra Aluno");
		this.alteraPergunta = new JButton("Altera Pergunta");
		this.alteraResposta = new JButton("Altera Resposta");
		this.listaExerCasda = new JButton("Totos Exercicios");
		this.sorteaExecicio = new JButton("Sortea Exercicio");
		this.verprova = new JButton("Ver prova");
		this.sair = new JButton("Sair");
	}
	
	private void inicializaEvento(){
		this.eventoCadastraExercicio = new EventoCadastraExercicio(this);
		this.eventoCadastraQuestao = new EventoCadastraQuestao(this);
		this.eventoCadastraAluno = new EventoCadastraAluno(this);
		this.eventoAlteraPergunta = new EventoAlteraPergunta(this);
		this.eventoAlteraResposta = new EventoAlteraResposta(this);
		this.eventoListaExerCasda = new EventoListatodosExercicios(this, this.gerente);
		this.eventoSorteaExecicio = new EventoSorteaExercicio(this, (TelaExercicio) this.telaExercicio);
		this.eventoVerProva = new EventoVerprova(this, this.gerente);
		this.eventoSair = new EventoSair();
	}
	
	private void addAoAoContainer(){
		this.container.add(this.cadastraExercicio);
		this.container.add(this.cadastraQuestao);
		this.container.add(this.cadastraAluno);
		this.container.add(this.alteraPergunta);
		this.container.add(this.alteraResposta);
		this.container.add(this.listaExerCasda);
		this.container.add(this.sorteaExecicio);
		this.container.add(this.verprova);
		this.container.add(this.sair);
		
		Font f = new Font("serif", Font.CENTER_BASELINE | Font.ITALIC, 16);
		JLabel poo = new JLabel("    Projeto de POO");
		JLabel versao = new JLabel("        Versão 1.0");
		JLabel desen = new JLabel("   Desenvolvedores");
		JLabel nome = new JLabel("            Italo"), nome2 = new JLabel("       Raimundo");
		
		poo.setToolTipText("UFPB");
		versao.setToolTipText("Beta");
		desen.setToolTipText("Java");
		nome.setToolTipText("É DEZ");
		nome2.setToolTipText("É DEZ");
		
		poo.setFont(f);
		versao.setFont(f);
		desen.setFont(f);
		nome.setFont(f);
		nome2.setFont(f);
		
		this.container.add(new JLabel(""));
		this.container.add(new JLabel(""));
		this.container.add(poo);
		this.container.add(versao);
		this.container.add(desen);
		this.container.add(nome);
		this.container.add(nome2);
	}
	
	private void addEventoAoBotao(){
		this.cadastraExercicio.addActionListener(this.eventoCadastraExercicio);
		this.cadastraQuestao.addActionListener(this.eventoCadastraQuestao);
		this.cadastraAluno.addActionListener(this.eventoCadastraAluno);
		this.alteraPergunta.addActionListener(this.eventoAlteraPergunta);
		this.alteraResposta.addActionListener(this.eventoAlteraResposta);
		this.listaExerCasda.addActionListener(this.eventoListaExerCasda);
		this.sorteaExecicio.addActionListener(this.eventoSorteaExecicio);
		this.verprova.addActionListener(this.eventoVerProva);
		this.sair.addActionListener(this.eventoSair);
	}
	
	public JFrame getTelaCadastro() {
		return this.telaCadastro;
	}

	public JFrame getTelaPesquisa() {
		return this.telaPesquisa;
	}
	
	public JFrame getTelaAlteraPergunta() {
		return this.telaAlteraPergunata;
	}
	
	public JFrame getTelaAlteraResposta(){
		return this.telaAlteraResposta;
	}
	
	public JFrame getTelaExercicio(){
		return this.telaExercicio;
	}
	
	public JFrame getTelaCadastroAluno(){
		return this.telaCadastroAluno;
	}
	
	public void setTextoPesquisa(String texto){
		TelaPesquisa t = (TelaPesquisa) this.telaPesquisa;
		t.setTexto(texto);
	}
	
	public void criarExercicio(){
		TelaExercicio t = (TelaExercicio) this.telaExercicio;
		try {
			t.criarExercicio(this.gerente.getSorteaExercicio());
			this.setMenu(this.telaPesquisa);
			this.setVisible(false);
			this.telaExercicio.setVisible(true);
		} catch (ListaVaziaExeception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}