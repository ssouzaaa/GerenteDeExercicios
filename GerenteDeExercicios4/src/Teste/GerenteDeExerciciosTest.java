package Teste;

import static org.junit.Assert.*;

import java.util.List;

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
			assertTrue(this.gerente.existeQuestaoDeExercicio("Italo", "Teste", "Quanto é 2+1?"));
			fail("deveria lança exceção");
		} catch (ProfessorInexistenteException e) {
		}
	}
	@Test
	public void cadastrasQuestaoTest(){
		this.gerente.cadastrasQuestao("Italo", "Teste", "MultiEscolha", "Quanto é 1+1?", "2");
		try {
			assertTrue(this.gerente.existeQuestaoDeExercicio("Italo", "Teste", "Quanto é 1+1?"));
		} catch (ProfessorInexistenteException e) {
			fail("não deveria lança exceção");
		}
	}
	@Test
	public void cadastraMesmaQuestaoDuasVezesTest(){
		this.gerente.cadastrasQuestao("Italo", "Teste", "MultiEscolha", "Quanto é 1+1?", "2");
		this.gerente.cadastrasQuestao("Italo", "Teste", "MultiEscolha", "Quanto é 1+1?", "2");
		try {
			assertEquals("Professor: Italo\nExercicio: Teste\nQuanto é 1+1?\n2\n", this.gerente.getListaExercicio("Italo", "Teste"));
		} catch (ProfessorInexistenteException e) {
			fail("não deveria lança exceção");
		}
	}
	@Test
	public void cadastraMesmaQuestaoProfessoresDiferentesTest(){
		this.gerente.cadastrasQuestao("Italo", "Teste", "MultiEscolha", "Quanto é 1+1?", "2");
		this.gerente.cadastrasQuestao("Raimundo", "Teste", "MultiEscolha", "Quanto é 1+1?", "2");
		try {
			assertEquals("Professor: Italo\nExercicio: Teste\nQuanto é 1+1?\n2\n", this.gerente.getListaExercicio("Italo", "Teste"));
			assertEquals("Professor: Raimundo\nExercicio: Teste\nQuanto é 1+1?\n2\n", this.gerente.getListaExercicio("Raimundo", "Teste"));
		} catch (ProfessorInexistenteException e) {
			fail("não deveria lança exceção");
		}
	}
	@Test
	public void cadastraAlunoTest(){
		try {
			this.gerente.cadastraAluno("Italo", "01");
		} catch (AlunoJaExisteException e) {
			fail("não deveria lança execeção" + e.getMessage());
		}
	}
	@Test
	public void cadastraAlunoDuasVezesTest(){
		try {
			this.gerente.cadastraAluno("Italo", "01");
			this.gerente.cadastraAluno("Italo", "01");
			fail("Deveria lança execeção");
		} catch (AlunoJaExisteException e) {
		}
	}
	@Test
	public void cadastraAlunoDuasVezesComNomesIguaisTest(){
		try {
			this.gerente.cadastraAluno("Italo", "01");
			this.gerente.cadastraAluno("Italo", "02");
		} catch (AlunoJaExisteException e) {
			fail("não deveria lança execeção" + e.getMessage());
		}
	}
	@Test
	public void cadastraAlunoDuasVezesComMatriculasIguaisTest(){
		try {
			this.gerente.cadastraAluno("Italo", "01");
			this.gerente.cadastraAluno("Raimundo", "01");
			fail("Deveria lança execeção");
		} catch (AlunoJaExisteException e) {
		}
	}
	@Test
	public void verificaQuestaoComProfessorErradoTest(){
		this.gerente.cadastrasQuestao("Italo", "Teste", "MultiEscolha", "Quanto é 1+1?", "2");
		try {
			assertTrue(this.gerente.existeQuestaoDeExercicio("Raimundo", "Teste", "Quanto é 1+1?"));
			fail("deveria lança exceção");
		} catch (ProfessorInexistenteException e) {
		}
	}
	@Test
	public void removeQuestaoNaoCadastradaTest(){
		this.gerente.cadastrasQuestao("Italo", "Teste", "MultiEscolha", "Quanto é X em x + 1 = 0?", "-1");
		try {
			this.gerente.removeQuestao("Italo", "Teste", "Quanto é 1+1?");
			fail("deveria lança exceção");
		} catch (ProfessorInexistenteException e){ 
		} catch (QuestaoInexistenteException e1){	
		}
	}
	@Test
	public void removeQuestaoCadastradaTest(){
		this.cadastrasQuestaoTest();
		try {
			this.gerente.removeQuestao("Italo", "Teste", "Quanto é 1+1?");
		} catch (ProfessorInexistenteException | QuestaoInexistenteException e) {
			fail("não deveria lança exceção");
		}
	}
	@Test
	public void removeQuestaoCadastradaDeProfessorErradoTest(){
		this.cadastrasQuestaoTest();
		try {
			this.gerente.removeQuestao("Raimundo", "Teste", "Quanto é 1+1?");
			fail("deveria lança exceção");
		} catch (ProfessorInexistenteException | QuestaoInexistenteException e) {
			
		}
	}
	@Test
	public void removeQuestaoCadastradaDuasVezesTest(){
		this.cadastraMesmaQuestaoDuasVezesTest();
		try {
			this.gerente.removeQuestao("Italo", "Teste", "Quanto é 1+1?");
		} catch (ProfessorInexistenteException | QuestaoInexistenteException e) {
			fail("não deveria lança exceção");
		}
	}
	@Test
	public void questaoNaoCadastradaVerificaRespostaTest(){
		this.cadastrasQuestaoTest(); // nesse caso a questão cadastrada é diferente da que é verificada.
		try {
			this.gerente.getResposta("Italo", "Teste", "verdade é igual a verdade?");
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
			assertEquals("2",this.gerente.getResposta("Italo", "Teste", "Quanto é 1+1?"));
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
			this.gerente.getPergunta("Italo", "Teste", "verdade");
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
			assertEquals("Quanto é 1+1?", this.gerente.getPergunta("Italo", "Teste", "2"));
		} catch (ProfessorInexistenteException e) {
			fail("não deveria lança exceção: " + e.getMessage());
		} catch (QuestaoInexistenteException e) {
			fail("não deveria lança exceção: " + e.getMessage());
		}
	}
	@Test
	public void existeQuestaoNãoCadastradaTest(){
		this.cadastrasQuestaoTest();
		try {
			assertFalse(this.gerente.existeQuestaoDeExercicio("Italo", "Teste", "verdade é igual a verdade?"));
		} catch (ProfessorInexistenteException e) {
			fail("não deveria lança exceção");
		}
	}
	@Test
	public void listaDeProfessorNãoCadastradoTest(){
		try {
			this.gerente.getListaExercicio("Italo", "Teste");
			fail("deveria lança exceção");
		} catch (ProfessorInexistenteException e) {
			
		}
	}
	@Test
	public void listaExercicioTest(){
		this.cadastrasQuestaoTest();
		try {
			assertEquals("Professor: Italo\nExercicio: Teste\nQuanto é 1+1?\n2\n",this.gerente.getListaExercicio("Italo", "Teste"));
		} catch (ProfessorInexistenteException e) {
			fail("Não deveria lança execeção " + e.getMessage());
		}
	}
	@Test
	public void listaExercicioInexistenteTest(){
		try {
			this.gerente.getListaExercicio("Italo", "Teste");
			fail("Deveria lança execeção");
		} catch (ProfessorInexistenteException e) {
		}
	}
	@Test
	public void listaDosNomesExercicioTest(){
		this.cadastrasQuestaoTest();
		try {
			this.gerente.getListaDosNomesExerc("Italo");
		} catch (ProfessorInexistenteException e) {
			fail("Não deveria lança execeção " + e.getMessage());
		}
	}
	@Test
	public void listaDosNomesExercicioInexistenteTest(){
		try {
			this.gerente.getListaDosNomesExerc("Italo");
			fail("Deveria lança execeção");
		} catch (ProfessorInexistenteException e) {
		}
	}
	@Test
	public void listaTodosExercicioTest(){
		this.cadastrasQuestaoTest();
		assertEquals("Nome Professor: Italo\n \nNome Exercicio: Teste\n \nQuanto é 1+1?\n2\n",this.gerente.getListaTodosExercicio());
	}
	@Test
	public void listaTodosExercicioVazioTest(){
		assertEquals("",this.gerente.getListaTodosExercicio());
	}
	@Test
	public void sorteaExercicioTeste(){
		this.cadastrasQuestaoTest();
		try {
			List<List<String>> list = this.gerente.getSorteaExercicio();
		} catch (ListaVaziaExeception e) {
			fail(e.getMessage());
		}
	}
	@Test
	public void notaExercicioTest(){
		this.cadastrasQuestaoTest();
		List<List<String>> list;
		try {
			list = this.gerente.getSorteaExercicio();
			assertEquals("Quantidade de questões certas: 0",this.gerente.getNotaExercicio(list.get(0), list.get(1)));
		} catch (ListaVaziaExeception e) {
			fail(e.getMessage());
		}
	}
}