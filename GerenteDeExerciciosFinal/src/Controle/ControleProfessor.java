package Controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import Dados.Professor;
import Exception.ProfessorJaExisteException;

public class ControleProfessor implements Serializable{

	private List<Professor> professores;
	private Map<String, List<String>> feedback;
	
	public ControleProfessor(){
		this.professores = new ArrayList<Professor>();
		this.feedback = new HashMap<>();
	}

	public void cadastrarProfessor(String nome, String matricula)throws ProfessorJaExisteException{
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
	
	public List<Professor> getListProf(){
		return this.professores;
	}
	public String toString() {
		String toString = new String();
		for(Professor p : professores){
			toString += "Professor [nome = " + p.getNome() + ", matricula = " + p.getMatricula() + "]";
		}
		return toString;
	}
	
	public void addFeedback(String exercicio, List<String> perguntas, List<String> resposta, List<String> respostaAluno, String nomeAluno, String matricula){
		if(this.feedback.containsKey(exercicio)){
			String toString = new String();
			List<String> list = this.feedback.get(exercicio);
			for(int i = 0; i < perguntas.size(); i++){
				String[] split = resposta.get(i).split("\n");
				for(String s : split){
					if(s.equalsIgnoreCase(respostaAluno.get(i))){
						toString = list.get(i);
						toString += "Nome: " + nomeAluno + " Matricula: " + matricula + "\n";
						list.remove(list.get(i));
						list.add(toString);
					}
				}	
			}
			this.feedback.put(exercicio, list);
		}else{
			List<String> list = new ArrayList<>();
			String toString = "Nome Execício: " + exercicio + "\n";
			for(int i = 0; i < perguntas.size(); i++){
				String[] split = resposta.get(i).split("\n");
				for(String s : split){
					toString += perguntas.get(i) + "\n";
					toString += "Alunos que responderam correto; \n";
					if(s.equalsIgnoreCase(respostaAluno.get(i))){
						toString += "Nome: " + nomeAluno + " Matricula: " + matricula + "\n";
						list.add(toString);
					}
				}
			}
			this.feedback.put(exercicio, list);
		}
	}
	
	public String getFeedback(){
		String toString = new String();
		Set<String> list = this.feedback.keySet();
		for(String s : list){
			for(String exer : this.feedback.get(s)){
				toString += exer + "\n";
			}
		}
		return toString;
	}
}
