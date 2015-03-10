package Dados;

public class Questao{

	private String pergunta;
	private String resposta;
	private String tipo;
	

	public Questao(String pertunta, String resposta, String tipo){
		this.cadastrarQuestao(pertunta, resposta, tipo);
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
		return this.pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public String getResposta() {
		return this.resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	
	public void cadastrarQuestao(String pergunta, String resposta, String tipo) {
		this.setPergunta(pergunta);
		this.setResposta(resposta);
		this.setTipo(tipo);
	}
	
	public String getTipo(){
		return this.tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String toString(){
		return this.pergunta + "\n" + this.resposta + "\n";
	}
}