package GerenteDeExercicios;


public class GerenteDeExercicios {

	Exercicios exe;
	
	public GerenteDeExercicios (){
		this.exe = new Exercicios();
	}
	
	public void cadastrarQuestaoDeVouF(String pergunta, String resposta){
		this.exe.cadastrarQuestaoDeVouF(pergunta, resposta);
	}
	public void cadastrarQuestaoMultiplaEscolha(String pergunta, String resposta){
		this.exe.cadastrarQuestaoMultiplaEscolha(pergunta, resposta);
	}
	public void cadastrarQuestaoDissertativa(String pergunta, String resposta){
		this.exe.cadastrarQuestaoDissertativa(pergunta, resposta);
	}
	


}
