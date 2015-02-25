package Controle;

import java.util.ArrayList;
import java.util.List;

import Dados.Professor;
import Exception.ProfessorJaExisteException;

public class ControleProfessor {

	private List<Professor> professores;
	
	public ControleProfessor(){
		this.professores = new ArrayList<Professor>();
	}

	public void cadastraProfessor(String nome, String matricula)throws ProfessorJaExisteException{
		boolean existe = false;
		for(Professor a: professores){
			if(a.getMatricula().equals(matricula)){
				existe = true;
				break;
			}
		}
		if(existe == true){
			throw new ProfessorJaExisteException("Já existe professor com essa matrícula:"+matricula);
		}else{
			Professor pro = new Professor(nome,matricula);
			professores.add(pro);
		}
	}
	
	public String toString() {
		String toString = new String();
		for(Professor p : professores){
			toString += "Professor [nome = " + p.getNome() + ", matricula = " + p.getMatricula() + "]";
		}
		return toString;
	}

	

}
