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
		this.questao = new Questao("A", "B");
		
	}

	@Test
	public void test() {
		
		gerente.cadastrarQuestaoDeVouF("Quanto é 1+1? ","2");
		
		
		assertTrue(gerente.exe.pesquisaQuestaoDeExercicio("V/F", "Quanto é 1+1? ","2"));
		int i = this.gerente.exe.pesquisaQuestaoDeExercicio1("V/F").size();
		assertEquals(1, i);
	
		assertFalse(gerente.exe.pesquisaQuestaoDeExercicio("Dissertativa", "Quanto é 1+1? ","2"));
		
		
	}

}
