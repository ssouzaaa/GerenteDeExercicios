package Controle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Dados.Questao;
import Exception.ProfessorInexistenteException;
import Exception.QuestaoInexistenteException;

public class ControleExercicios {

	Map<String, List<Questao>> m;
	
	public ControleExercicios(){
		this.m = new HashMap<>(); 
	}
	
	public void cadastrasQuestao(String nomeProfessor, String pergunta, String resposta, String tipo){
		Questao questao = new Questao(pergunta, resposta, tipo);
		List<Questao> v = new ArrayList<Questao>();;
		if(m.containsKey(nomeProfessor)){
			try {
				if(this.existeQuestaoDeExercicio(nomeProfessor, pergunta, tipo)){
					return;
				}
			} catch (ProfessorInexistenteException e) {
				
			}
			v = m.get(nomeProfessor);
		}
		v.add(questao);
		m.put(nomeProfessor, v);
	}
	
	public void removeQuestao(String nomeProfessor, String pergunta, String tipo) throws ProfessorInexistenteException, QuestaoInexistenteException{
		if(m.containsKey(nomeProfessor)){
			if(this.existeQuestaoDeExercicio(nomeProfessor, pergunta, tipo)){
				List<Questao> n = m.get(nomeProfessor);
				for(Questao q : n){
					if(q.getPergunta().equals(pergunta)){
						n.remove(q);
						m.put(nomeProfessor, n);
						return;
					}
				}
			}
			throw new QuestaoInexistenteException("Questão não existe");
		}
		throw new ProfessorInexistenteException(nomeProfessor + " não existe");
	}

	public boolean existeQuestaoDeExercicio(String nomeProfessor, String pergunta, String tipo) throws ProfessorInexistenteException{
		if(m.containsKey(nomeProfessor)){
			List<Questao> n = m.get(nomeProfessor);
			if(n != null){
				for(Questao q : n){
					if(q.getPergunta().equals(pergunta)){
						return true;
					}
				}
			}
			return false;
		}
		throw new ProfessorInexistenteException(nomeProfessor + " não existe");
	}
	
	public String getResposta(String nomeProfessor, String pergunta, String tipo) throws ProfessorInexistenteException, QuestaoInexistenteException{
		if(m.containsKey(nomeProfessor)){
			if(this.existeQuestaoDeExercicio(nomeProfessor, pergunta, tipo)){
				List<Questao> n = m.get(nomeProfessor);
				String resposta = null;
				if(n != null){
					for(Questao q : n){
						if(q.getPergunta().equals(pergunta)){
							resposta = q.getResposta();
						}
					}
				}
				return resposta;
			}
			throw new QuestaoInexistenteException("Questão não existe");
		}
		throw new ProfessorInexistenteException(nomeProfessor + " não existe");
	}
	
	public String getPergunta(String nomeProfessor, String resposta, String tipo) throws ProfessorInexistenteException, QuestaoInexistenteException{
		if(m.containsKey(nomeProfessor)){
			boolean tem = false;
			List<Questao> n = m.get(nomeProfessor);
			String pergunta = null;
			if(n != null){
				for(Questao q : n){
					if(q.getResposta().equals(resposta)){
						pergunta = q.getPergunta();
						tem = true;
					}
				}
			}
			if(!tem){
				throw new QuestaoInexistenteException("Questão não existe");
			}
			return pergunta;
		}
		throw new ProfessorInexistenteException(nomeProfessor + " não existe");
	}
	
	public List<Questao> getListaExercicioDoprofessor(String nomeProfessor) throws ProfessorInexistenteException{
		if(m.containsKey(nomeProfessor)){
			return m.get(nomeProfessor);
		}
		throw new ProfessorInexistenteException(nomeProfessor + " não existe");
	}
}