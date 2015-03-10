package Controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Dados.Aluno;
import Exception.AlunoJaExisteException;
import Exception.AlunoNaoExisteException;

public class ControleAluno implements Serializable{

	private List<Aluno> alunos;
	
	public ControleAluno(){
		this.alunos = new ArrayList<Aluno>();
	}
	
	public void cadastraAluno(String nome, String matricula)throws AlunoJaExisteException{
		boolean existe = false;
		for(Aluno a: alunos){
			if(a.getMatricula().equals(matricula)){
				existe = true;
				break;
			}
		}
		if(existe == true){
			throw new AlunoJaExisteException("Já existe aluno com essa matrícula:"+matricula);
		}else{
			Aluno alu = new Aluno(nome,matricula);
			alunos.add(alu);
		}
	}
	
	public void setProvaAluno(String matricula, String prova) throws AlunoNaoExisteException{
		boolean entrou = true;
		for(Aluno a : this.alunos){
			if(a.getMatricula().equalsIgnoreCase(matricula)){
				a.setExercicio(prova);
				entrou = false;
			}
		}
		if(entrou){
			throw new AlunoNaoExisteException("Aluno não existe: "+matricula);
		}
	}
	public String getProvaAluno(String matricula) throws AlunoNaoExisteException{
		for(Aluno a : this.alunos){
			if(a.getMatricula().equalsIgnoreCase(matricula)){
				return a.getExercicio();
			}
		}
		throw new AlunoNaoExisteException("Aluno não existe: "+matricula);
	}

	public String toString() {
		String toString = new String();
		for(Aluno p : alunos){
			toString += "Professor [nome = " + p.getNome() + ", matricula = " + p.getMatricula() + "]";
		}
		return toString;
	}

	public boolean isMatricula(String matricula) {
		for(Aluno a : alunos){
			if(a.getMatricula().equalsIgnoreCase(matricula)){
				return true;
			}
		}
		return false;
	}
}
