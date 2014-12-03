package GerenteDeExercicios;

import java.util.ArrayList;
import java.util.List;

public class Professor extends Pessoa {

	List<Professor> professores;
	
	public Professor(String nome, String matricula) {
		super(nome, matricula);
		this.professores = new ArrayList<>();
		
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
			throw new ProfessorJaExisteException("Já existe aluno com essa matrícula:"+matricula);
		}else{
			Professor pro = new Professor(nome,matricula);
			professores.add(pro);
		}
	}
	
	public String toString() {
		return "Professor [nome = " + super.getNome() + ", matricula = " + super.getMatricula() + "]";
	}

	

}
