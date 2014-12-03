package GerenteDeExercicios;


public class GerenteDeExercicios {

	Exercicios exe;
	
	public GerenteDeExercicios (){
		this.exe = new Exercicios();
	}
	
	public void cadastrarQuestaoDeVouF(Questao questao){
		this.exe.cadastrarQuestaoDeVouF(questao);
	}
	public void cadastrarQuestaoMultiplaEscolha(Questao questao){
		this.exe.cadastrarQuestaoMultiplaEscolha(questao);;
	}
	public void cadastrarQuestaoDissertativa(Questao questao){
		this.exe.cadastrarQuestaoDissertativa(questao);
	}


}
