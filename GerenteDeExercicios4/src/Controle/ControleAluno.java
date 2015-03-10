package Controle;

import java.util.ArrayList;
import java.util.List;

import Dados.Aluno;
import Exception.AlunoJaExisteException;

public class ControleAluno {

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

	public String toString() {
		String toString = new String();
		for(Aluno p : alunos){
			toString += "Professor [nome = " + p.getNome() + ", matricula = " + p.getMatricula() + "]";
		}
		return toString;
	}
}
