package Gerente;

import java.util.List;

import Controle.*;
import Dados.Questao;
import Exception.*;

public class Gerente {

	private ControleAluno aluno;
	private ControleExercicios exercicios;
	private ControleProfessor professor;
	
	public Gerente(){
		this.aluno = new ControleAluno();
		this.exercicios = new ControleExercicios();
		this.professor = new ControleProfessor();
	}
	
	public void cadastrasQuestao(String nomeProfessor, String pergunta, String resposta, String tipo){
		this.exercicios.cadastrasQuestao(nomeProfessor, pergunta, resposta, tipo);
	}
	
	public void removeQuestao(String nomeProfessor, String pergunta, String tipo) throws ProfessorInexistenteException, QuestaoInexistenteException{
		this.exercicios.removeQuestao(nomeProfessor, pergunta, tipo);
	}

	public boolean existeQuestaoDeExercicio(String nomeProfessor, String pergunta, String tipo) throws ProfessorInexistenteException{
		return this.exercicios.existeQuestaoDeExercicio(nomeProfessor, pergunta, tipo);
	}
	
	public String getResposta(String nomeProfessor, String pergunta, String tipo) throws ProfessorInexistenteException, QuestaoInexistenteException{
		return this.exercicios.getResposta(nomeProfessor, pergunta, tipo);
	}
	
	public String getPergunta(String nomeProfessor, String resposta, String tipo) throws ProfessorInexistenteException, QuestaoInexistenteException{
		return this.exercicios.getPergunta(nomeProfessor, resposta, tipo);
	}
	
	public List<Questao> getListaExercicioDoprofessor(String nomeProfessor) throws ProfessorInexistenteException{
		return this.exercicios.getListaExercicioDoprofessor(nomeProfessor);
	}
	
}
