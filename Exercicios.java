package GerenteDeExercicios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exercicios {

	Map<String, List<QuestaoIF>> m = new HashMap<>(); 
	
public Exercicios(){
	
	m.put("V/F", new ArrayList<QuestaoIF>());
	m.put("MultiEscolha", new ArrayList<QuestaoIF>());
	m.put("Dissertativa", new ArrayList<QuestaoIF>());
}

public void cadastrarQuestaoDeVouF(QuestaoIF questao){
	
	List<QuestaoIF> v = m.get("V/F");
	v.add(questao);
	m.put("V/F", v);
	
}

public void cadastrarQuestaoMultiplaEscolha(QuestaoIF questao){
	
	List<QuestaoIF> v = m.get("MultiEscolha");
	v.add(questao);
	m.put("MultiEscolha", v);
	
}
public void cadastrarQuestaoDissertativa(QuestaoIF questao){
	
	List<QuestaoIF> v = m.get("Dissertativa");
	v.add(questao);
	m.put("Dissertativa", v);
	
}
public boolean pesquisaQuestaoDeExercicio(String tipo, Questao questao){
	List<QuestaoIF> n = m.get(tipo);
	for( QuestaoIF x: n){
		if(x.equals(questao)){
			return true;
		}
	}
	return false;
}
public Questao pesquisaQuestaoDeExercicio1(String tipo, Questao questao){
	List<QuestaoIF> n = m.get(tipo);
	for( QuestaoIF x: n){
		if(x.equals(questao)){
			return (Questao) x;
		}
	}
	return null;
}
	
}
