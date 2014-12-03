package GerenteDeExercicios;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GerenteDeExerciciosTest {

	GerenteDeExercicios gerente;
	Questao questao;
	
	
	@Before
	public void setUp() throws Exception {
		
		this.gerente = new GerenteDeExercicios();
		this.questao = new Questao();
		
	}

	@Test
	public void VerificarListaVaziatest() {
		
		questao.cadastrarQuestao("1+1");
		gerente.cadastrarQuestaoDeVouF(questao);
		
		
		assertTrue(gerente.exe.pesquisaQuestaoDeExercicio("V/F", questao));
		
	
		
		
		
	}

}
