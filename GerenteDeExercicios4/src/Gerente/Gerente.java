package Gerente;

import java.util.List;

import Controle.*;
import Dados.Questao;
import Exception.*;

public class Gerente {

	private ControleAluno aluno;
	private ControleExercicios exercicios;
//	private ControleProfessor professor;
	
	public Gerente(){
		this.aluno = new ControleAluno();
		this.exercicios = new ControleExercicios();
//		this.professor = new ControleProfessor();
	}
	
	public void cadastrasQuestao(String nomeProfessor, String nomeExercicio, String tipoQuestao, String pergunta, String resposta){
		this.exercicios.cadastrasQuestao(nomeProfessor, nomeExercicio, tipoQuestao, pergunta, resposta);
	}
	
	public void removeQuestao(String nomeProfessor, String nomeExercicio, String pergunta) throws ProfessorInexistenteException, QuestaoInexistenteException{
		this.exercicios.removeQuestao(nomeProfessor, nomeExercicio, pergunta);
	}

	public boolean existeQuestaoDeExercicio(String nomeProfessor, String nomeExercicio, String pergunta) throws ProfessorInexistenteException{
		return this.exercicios.existeQuestaoDeExercicio(nomeProfessor, nomeExercicio, pergunta);
	}
	
	public void setResposta(String nomeProfessor, String nomeExercicio, String novaResposta, String resposta) throws ProfessorInexistenteException, QuestaoInexistenteException{
		this.exercicios.setResposta(nomeProfessor, nomeExercicio, novaResposta, resposta);
	}
	
	public String getResposta(String nomeProfessor, String nomeExercicio, String pergunta) throws ProfessorInexistenteException, QuestaoInexistenteException{
		return this.exercicios.getResposta(nomeProfessor, nomeExercicio, pergunta);
	}
	
	public void setPergunta(String nomeProfessor, String nomeExercicio, String NovaPergunta, String pergunta) throws ProfessorInexistenteException, QuestaoInexistenteException{
		this.exercicios.setPergunta(nomeProfessor, nomeExercicio, NovaPergunta, pergunta);
	}
	
	public String getPergunta(String nomeProfessor, String nomeExercicio, String resposta) throws ProfessorInexistenteException, QuestaoInexistenteException{
		return this.exercicios.getPergunta(nomeProfessor, nomeExercicio, resposta);
	}
	
	public String getListaExercicio(String nomeProfessor, String nomeExercicio) throws ProfessorInexistenteException{
		return this.exercicios.getListaExercicio(nomeProfessor, nomeExercicio);
	}
	
	public String getListaTodosExercicio() {
		return this.exercicios.getListExerciciosCadastrado();
	}
	
	public List<List<String>> getSorteaExercicio() throws ListaVaziaExeception{
		return this.exercicios.getSorteaExercicio();
	}
	
	public String getListaDosNomesExerc(String nomeProfessor) throws ProfessorInexistenteException{
		return this.exercicios.getListaDosNomesExerc(nomeProfessor);
	}
	
	public void cadastraAluno(String nome, String matricula) throws AlunoJaExisteException{
		this.aluno.cadastraAluno(nome, matricula);
	}

	public String getNotaExercicio(List<String> exer, List<String> resposta) {
		return this.exercicios.getNotaExercicio(exer, resposta);
	}
}
