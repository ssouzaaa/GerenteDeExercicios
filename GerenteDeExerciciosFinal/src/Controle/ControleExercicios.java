package Controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import Dados.Questao;
import Exception.ListaVaziaExeception;
import Exception.ProfessorInexistenteException;
import Exception.QuestaoInexistenteException;


public class ControleExercicios implements Serializable{

	private Map<String, Map<String, List<Questao>>> m;
	private String exerAtul;
	
	public ControleExercicios(){
		this.m = new HashMap<>();
		this.exerAtul = new String();
	}
	
	public void cadastrarExercicios(String nomeProfessor, String nomeExercicio, List<Questao> exercicios){
		if(!m.containsKey(nomeProfessor)){
			Map<String, List<Questao>> prof = new HashMap<>();
			m.put(nomeProfessor, prof);
		}
		Map<String, List<Questao>> mapNomeprof = m.get(nomeProfessor);
		if(!mapNomeprof.containsKey(nomeExercicio)){
			List<Questao> exer = new ArrayList<>();
			mapNomeprof.put(nomeExercicio, exer);
		}
		List<Questao> listNomeExer = mapNomeprof.get(nomeExercicio);
		listNomeExer = exercicios;
		m.put(nomeProfessor, mapNomeprof).put(nomeExercicio, listNomeExer);
	}
	
	public void cadastrarQuestao(String nomeProfessor, String nomeExercicio, String tipoQuestao, String pergunta, String resposta){
		Questao questao = new Questao(pergunta, resposta, tipoQuestao);
		if(!m.containsKey(nomeProfessor)){
			Map<String, List<Questao>> prof = new HashMap<>();
			m.put(nomeProfessor, prof);
		}
		Map<String, List<Questao>> mapNomeprof = m.get(nomeProfessor);
		if(!mapNomeprof.containsKey(nomeExercicio)){
			List<Questao> exer = new ArrayList<>();
			mapNomeprof.put(nomeExercicio, exer);
		}
		List<Questao> listNomeExer = mapNomeprof.get(nomeExercicio);
		for(Questao q : listNomeExer){
			if(q.equals(questao)){
				return;
			}
		}
		listNomeExer.add(questao);
		m.put(nomeProfessor, mapNomeprof).put(nomeExercicio, listNomeExer);
	}
	
	public void setPergunta(String nomeProfessor, String nomeExercicio, String NovaPergunta, String pergunta) throws ProfessorInexistenteException, QuestaoInexistenteException{
		if(m.containsKey(nomeProfessor)){
			Map<String, List<Questao>> mapNomeprof = m.get(nomeProfessor);
			if(mapNomeprof.containsKey(nomeExercicio)){
				List<Questao> listNomeExer = mapNomeprof.get(nomeExercicio);
				if(listNomeExer != null){
					for(Questao q : listNomeExer){
						if(q.getPergunta().equalsIgnoreCase(pergunta)){
							q.setPergunta(NovaPergunta);
						}
					}
				}
			}else{
				throw new QuestaoInexistenteException("Questão não existe");
			}
		}else{
			throw new ProfessorInexistenteException(nomeProfessor + " não existe");
		}
	}
	
	public void setResposta(String nomeProfessor, String nomeExercicio, String novaResposta, String resposta) throws ProfessorInexistenteException, QuestaoInexistenteException{
		if(m.containsKey(nomeProfessor)){
			Map<String, List<Questao>> mapNomeprof = m.get(nomeProfessor);
			if(mapNomeprof.containsKey(nomeExercicio)){
				List<Questao> listNomeExer = mapNomeprof.get(nomeExercicio);
				if(listNomeExer != null){
					for(Questao q : listNomeExer){
						for(String s : q.getResposta().split("\n")){
							if(s.equalsIgnoreCase(resposta)){
								q.setResposta(novaResposta);
							}
						}
					}
				}
			}else{
				throw new QuestaoInexistenteException("Questão não existe");
			}
		}else{
			throw new ProfessorInexistenteException(nomeProfessor + " não existe");
		}
	}
	
	public void removerQuestao(String nomeProfessor, String nomeExercicio, String pergunta) throws ProfessorInexistenteException, QuestaoInexistenteException{
		if(m.containsKey(nomeProfessor)){
			Map<String, List<Questao>> mapNomeprof = m.get(nomeProfessor);
			if(mapNomeprof.containsKey(nomeExercicio)){
				List<Questao> listNomeExer = mapNomeprof.get(nomeExercicio);
				if(mapNomeprof != null){
					for(Questao q : listNomeExer){
						if(q.getPergunta().equals(pergunta)){
							listNomeExer.remove(q);
							m.put(nomeProfessor, mapNomeprof).put(nomeExercicio, listNomeExer);
							return;
						}
					}
					throw new QuestaoInexistenteException("Questão não existe");
				}
			}
		}
		throw new ProfessorInexistenteException(nomeProfessor + " não existe");
	}

	public boolean existeQuestaoDeExercicio(String nomeProfessor, String nomeExercicio, String pergunta) throws ProfessorInexistenteException{
		if(m.containsKey(nomeProfessor)){
			Map<String, List<Questao>> mapNomeprof = m.get(nomeProfessor);
			if(mapNomeprof.containsKey(nomeExercicio)){
				List<Questao> listNomeExer = mapNomeprof.get(nomeExercicio);
				if(mapNomeprof != null){
					if(listNomeExer != null){
						for(Questao q : listNomeExer){
							if(q.getPergunta().equals(pergunta)){
								return true;
							}
						}
					}
				}
			}
			return false;
		}
		throw new ProfessorInexistenteException(nomeProfessor + " não existe");
	}
	
	public String getResposta(String nomeProfessor, String nomeExercicio, String pergunta) throws ProfessorInexistenteException, QuestaoInexistenteException{
		if(m.containsKey(nomeProfessor)){
			Map<String, List<Questao>> mapNomeprof = m.get(nomeProfessor);
			if(mapNomeprof.containsKey(nomeExercicio)){
				List<Questao> listNomeExer = mapNomeprof.get(nomeExercicio);
				if(mapNomeprof != null){
					for(Questao q : listNomeExer){
						if(q.getPergunta().equals(pergunta)){
							return q.getResposta();
						}
					}
				}
				throw new QuestaoInexistenteException("Questão não existe");
			}
		}
		throw new ProfessorInexistenteException(nomeProfessor + " não existe");
	}
	
	public String getPergunta(String nomeProfessor, String nomeExercicio, String resposta) throws ProfessorInexistenteException, QuestaoInexistenteException{
		if(m.containsKey(nomeProfessor)){
			Map<String, List<Questao>> mapNomeprof = m.get(nomeProfessor);
			if(mapNomeprof.containsKey(nomeExercicio)){
				List<Questao> listNomeExer = mapNomeprof.get(nomeExercicio);
				if(mapNomeprof != null){
					for(Questao q : listNomeExer){
						if(q.getResposta().equals(resposta)){
							return q.getPergunta();
						}
					}
				}
				throw new QuestaoInexistenteException("Questão não existe");
			}
		}
		throw new ProfessorInexistenteException(nomeProfessor + " não existe");
	}
	
	public String getListaExercicio(String nomeProfessor, String nomeExercicio) throws ProfessorInexistenteException{
		if(m.containsKey(nomeProfessor)){
			Map<String, List<Questao>> mapNomeprof = m.get(nomeProfessor);
			if(mapNomeprof.containsKey(nomeExercicio)){
				List<Questao> listNomeExer = mapNomeprof.get(nomeExercicio);
				String toString = "Professor: " + nomeProfessor + "\n" + "Exercicio: " + nomeExercicio + "\n";
				for(Questao q : listNomeExer){
					toString += q.toString();
				}
				return toString;
			}
		}
		throw new ProfessorInexistenteException(nomeProfessor + " não existe");
	}
	
	public String getListaDosNomesExerc(String nomeProfessor) throws ProfessorInexistenteException{
		if(this.m.containsKey(nomeProfessor)){
			String toString = "Lista de Exercicios do professor: " + nomeProfessor + ". \n";
			Set<String> nomesExer = this.m.get(nomeProfessor).keySet();
			for(String nome : nomesExer){
				toString += nome + "\n";
			}
			return toString;
		}
		throw new ProfessorInexistenteException(nomeProfessor + " não existe");
	}
	
	public String getListExerciciosCadastrado(){
		String toString = new String();
		Set<String> listprof = this.m.keySet();
		for(String s : listprof){
			toString += "Nome Professor: " + s + "\n \n";
			Set<String> listExer = this.m.get(s).keySet();
			for(String s1 : listExer){
				toString += "Nome Exercicio: " + s1 + "\n \n";
				for(Questao q : this.m.get(s).get(s1)){
					toString += q.toString();
				}
			}
		}
		return toString;
	}
	
	public List<List<String>> getSortearExercicio() throws ListaVaziaExeception{
		try {
			List<String> pergunta = new ArrayList<>(), resposta = new ArrayList<>();
			Set<String> listNomesprof = this.m.keySet();
			List<String> list = new ArrayList<>(), list2 = new ArrayList<>();
			for(String s : listNomesprof){
				list.add(s);
			}
			int i = Math.round(list.size() - 1);
			listNomesprof = this.m.get(list.get(i)).keySet();
			for(String s2 : listNomesprof){
				list2.add(s2);
			}
			
			List<Questao> listQuestao = this.m.get(list.get(i)).get(list2.get(i));
			this.exerAtul = list2.get(i);
			List<List<String>> toString = new ArrayList<>();
			for(int j = 0; j <listQuestao.size(); j++){
				pergunta.add(j, listQuestao.get(j).getPergunta());
				resposta.add(j, listQuestao.get(j).getResposta());
			}
			toString.add(pergunta);
			toString.add(resposta);
			return toString;
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new ListaVaziaExeception("Lista vazia");
		}
		
	}
	
	public String getCorrecaoExercicio(List<String> perguntas, List<String> resposta, List<String> respostaAluno){
		String toString = new String();
		int cont = 0;
		for(int i = 0; i < perguntas.size(); i++){
			String[] split = resposta.get(i).split("\n");
			for(String s : split){
				if(s.equalsIgnoreCase(respostaAluno.get(i))){
					toString += "CORRETO \n";
					cont++;
				}else{
					toString += "ERRADO \n";
				}
				toString += perguntas.get(i) + "\n";
				toString += "Resposta do Aluno. \n";
				toString += respostaAluno.get(i) + "\n";
				toString += "Resposta correta. \n";
				toString += resposta.get(i) + "\n \n";
			}
			
		}
		toString += "NOTA: " + cont;
		return toString;
	}
	
	public String getExercicioAtual(){
		return this.exerAtul;
	}
}