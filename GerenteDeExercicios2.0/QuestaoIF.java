package GerenteDeExercicios;



public interface QuestaoIF {
	
	
	String getPergunta();

	String getResposta();

	void cadastrarQuestao(String pergunta, String resposta);
}

