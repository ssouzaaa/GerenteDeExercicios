package GerenteDeExercicios;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Pessoa {

	List<Aluno> alunos;
	
	public Aluno(String nome, String matricula) {
		super(nome, matricula);
		this.alunos = new ArrayList<>();
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
		return "Aluno [nome = " + super.getNome() + ", matricula = " + super.getMatricula() + "]";
	}
}


