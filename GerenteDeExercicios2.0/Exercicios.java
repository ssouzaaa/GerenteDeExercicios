package GerenteDeExercicios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exercicios {

	Map<String, List<Questao>> m = new HashMap<>(); 
	
public Exercicios(){
	
	m.put("V/F", new ArrayList<Questao>());
	m.put("MultiEscolha", new ArrayList<Questao>());
	m.put("Dissertativa", new ArrayList<Questao>());
}

public void cadastrarQuestaoDeVouF(String pergunta, String resposta){
	Questao questao = new Questao(pergunta, resposta);
	List<Questao> v = m.get("V/F");
	v.add(questao);
	m.put("V/F", v);
	
}

public void cadastrarQuestaoMultiplaEscolha(String pergunta, String resposta){
	Questao questao = new Questao(pergunta, resposta);
	List<Questao> v = m.get("MultiEscolha");
	v.add(questao);
	m.put("MultiEscolha", v);
	
}
public void cadastrarQuestaoDissertativa(String pergunta, String resposta){
	Questao questao = new Questao(pergunta, resposta);
	List<Questao> v = m.get("Dissertativa");
	v.add(questao);
	m.put("Dissertativa", v);
	
}
public boolean pesquisaQuestaoDeExercicio(String tipo,String pergunta, String resposta){
	Questao questao = new Questao(pergunta, resposta);
	List<Questao> n = m.get(tipo);
	for( Questao x: n){
		if(x.equals(questao)){
			return true;
		}
	}
	return false;
}
public List<Questao> pesquisaQuestaoDeExercicio1(String tipo){
	return this.m.get(tipo);
}
	
}
