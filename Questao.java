package GerenteDeExercicios;

import java.util.ArrayList;
import java.util.List;

public class Questao implements QuestaoIF {

	private String pergunta;
	private String resposta;
	
	List<String> questoes;

	public Questao(){
		this.questoes = new ArrayList<>();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Questao other = (Questao) obj;
		if (pergunta == null) {
			if (other.pergunta != null)
				return false;
		} else if (!pergunta.equals(other.pergunta))
			return false;
		if (resposta == null) {
			if (other.resposta != null)
				return false;
		} else if (!resposta.equals(other.resposta))
			return false;
		return true;
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	@Override
	public void cadastrarQuestao(String questao) {
		this.questoes.add(questao);

	}
	

	@Override
	public String getQuestao() {
		return this.questoes.get(0);
	}

	@Override
	public String getResposta() {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public void cadastrarResposta(String questao) {
		// TODO Auto-generated method stub

	}
	 */
	
	/*
	@Override
	public String getResposta() {
		// TODO Auto-generated method stub
		return null;
	}
*/
}
