package Teste;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Exception.*;
import Gerente.Gerente;

public class GerenteDeExerciciosTest {

	private Gerente gerente;
	
	@Before
	public void setUp() {
		this.gerente = new Gerente();
	}
	@Test
	public void verificaQuestaoNaoCadastradaTest(){
		try {
			assertTrue(this.gerente.existeQuestaoDeExercicio("Italo", "Quanto é 1+1?", "Dissertativa"));
			fail("deveria lança exceção");
		} catch (ProfessorInexistenteException e) {
			
		}
	}
	@Test
	public void cadastrasQuestaoTest(){
		this.gerente.cadastrasQuestao("Italo", "Quanto é 1+1?", "2", "Dissertativa");
		try {
			assertTrue(this.gerente.existeQuestaoDeExercicio("Italo", "Quanto é 1+1?", "Dissertativa"));
		} catch (ProfessorInexistenteException e) {
			fail("não deveria lança exceção");
		}
	}
	@Test
	public void cadastraMesmaQuestaoDuasVezesTest(){
		this.gerente.cadastrasQuestao("Italo", "Quanto é 1+1?", "2", "Dissertativa");
		this.gerente.cadastrasQuestao("Italo", "Quanto é 1+1?", "2", "Dissertativa");
		try {
			assertEquals(1, this.gerente.getListaExercicioDoprofessor("Italo").size());
		} catch (ProfessorInexistenteException e) {
			fail("não deveria lança exceção");
		}
	}
	@Test
	public void cadastraMesmaQuestaoProfessoresDiferentesTest(){
		this.gerente.cadastrasQuestao("Italo", "Quanto é 1+1?", "2", "Dissertativa");
		this.gerente.cadastrasQuestao("Raimundo", "Quanto é 1+1?", "2", "Dissertativa");
		try {
			assertEquals(1, this.gerente.getListaExercicioDoprofessor("Italo").size());
			assertEquals(1, this.gerente.getListaExercicioDoprofessor("Raimundo").size());
		} catch (ProfessorInexistenteException e) {
			fail("não deveria lança exceção");
		}
	}
	@Test
	public void verificaQuestaoComProfessorErradoTest(){
		this.gerente.cadastrasQuestao("Italo", "Quanto é 1+1?", "2", "Dissertativa");
		try {
			assertTrue(this.gerente.existeQuestaoDeExercicio("Raimundo", "Quanto é 1+1?", "Dissertativa"));
			fail("deveria lança exceção");
		} catch (ProfessorInexistenteException e) {
		}
	}
	@Test
	public void removeQuestaoNaoCadastradaTest(){
		this.gerente.cadastrasQuestao("Italo", "Quanto é X em x + 1 = 0?", "-1", "Dissertativa");
		try {
			this.gerente.removeQuestao("Italo", "Quanto é 1+1?", "Dissertativa");
			fail("deveria lança exceção");
		} catch (ProfessorInexistenteException e){ 
		} catch (QuestaoInexistenteException e1){	
		}
	}
	@Test
	public void removeQuestaoCadastradaTest(){
		this.cadastrasQuestaoTest();
		try {
			this.gerente.removeQuestao("Italo", "Quanto é 1+1?", "Dissertativa");
		} catch (ProfessorInexistenteException | QuestaoInexistenteException e) {
			fail("não deveria lança exceção");
		}
	}
	@Test
	public void removeQuestaoCadastradaDeProfessorErradoTest(){
		this.cadastrasQuestaoTest();
		try {
			this.gerente.removeQuestao("Raimundo", "Quanto é 1+1?", "Dissertativa");
			fail("deveria lança exceção");
		} catch (ProfessorInexistenteException | QuestaoInexistenteException e) {
			
		}
	}
	@Test
	public void removeQuestaoCadastradaDuasVezesTest(){
		this.cadastraMesmaQuestaoDuasVezesTest();
		try {
			this.gerente.removeQuestao("Italo", "Quanto é 1+1?", "Dissertativa");
		} catch (ProfessorInexistenteException | QuestaoInexistenteException e) {
			fail("não deveria lança exceção");
		}
	}
	@Test
	public void questaoNaoCadastradaVerificaRespostaTest(){
		this.cadastrasQuestaoTest(); // nesse caso a questão cadastrada é diferente da que é verificada.
		try {
			this.gerente.getResposta("Italo", "verdade é igual a verdade?", "Dissertativa");
			fail("deveria lança a exceção QuestaoInexistenteException");
		} catch (ProfessorInexistenteException e) {
			fail("não deveria lança exceção");
		} catch (QuestaoInexistenteException e) {
			
		}
	}
	@Test
	public void questaoCadastradaVerificaRespostaTest(){
		this.cadastrasQuestaoTest();
		try {
			assertEquals("2",this.gerente.getResposta("Italo", "Quanto é 1+1?", "Dissertativa"));
		} catch (ProfessorInexistenteException e) {
			fail("não deveria lança exceção");
		} catch (QuestaoInexistenteException e) {
			fail("não deveria lança exceção");
		}
	}
	@Test
	public void questaoNaoCadastradaVerificaPerguntaTest(){
		this.cadastrasQuestaoTest();
		try {
			this.gerente.getPergunta("Italo", "verdade", "Dissertativa");
			fail("deveria lança a exceção QuestaoInexistenteException");
		} catch (ProfessorInexistenteException e) {
			fail("não deveria lança exceção");
		} catch (QuestaoInexistenteException e) {
			
		}
	}
	@Test
	public void questaoCadastradaVerificaPerguntaTest(){
		this.cadastrasQuestaoTest();
		try {
			assertEquals("Quanto é 1+1?", this.gerente.getPergunta("Italo", "2", "Dissertativa"));
		} catch (ProfessorInexistenteException e) {
			fail("não deveria lança exceção");
		} catch (QuestaoInexistenteException e) {
			fail("não deveria lança exceção");
		}
	}
	@Test
	public void existeQuestaoNãoCadastradaTest(){
		this.cadastrasQuestaoTest();
		try {
			assertFalse(this.gerente.existeQuestaoDeExercicio("Italo", "verdade é igual a verdade?", "Dissertativa"));
		} catch (ProfessorInexistenteException e) {
			fail("não deveria lança exceção");
		}
	}
	@Test
	public void listaDeProfessorNãoCadastradoTest(){
		try {
			this.gerente.getListaExercicioDoprofessor("Italo");
			fail("deveria lança exceção");
		} catch (ProfessorInexistenteException e) {
			
		}
	}
	@Test
	public void listaDeProfessorCadastradoComQuestaoTest(){
		this.cadastrasQuestaoTest();
		try {
			assertEquals(1, this.gerente.getListaExercicioDoprofessor("Italo").size());
		} catch (ProfessorInexistenteException e) {
			fail("não deveria lança exceção");
		}
	}
}