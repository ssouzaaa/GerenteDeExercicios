package Teste;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.After;
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
	@After
	public void tearDown(){
		File file = new File("controleAluno.txt");
		if(file.exists()){
			file.delete();
		}
		file = new File("controleExercicios.txt");
		if(file.exists()){
			file.delete();
		}
	}
	@Test
	public void verificaQuestaoNaoCadastradaTest(){
		try {
			assertTrue(this.gerente.existeQuestaoDeExercicio("Italo", "Teste", "Quanto � 2+1?"));
			fail("deveria lan�a exce��o");
		} catch (ProfessorInexistenteException e) {
		}
	}
	@Test
	public void cadastrasQuestaoTest(){
		this.gerente.cadastrarQuestao("Italo", "Teste", "MultiEscolha", "Quanto � 1+1?", "2");
		try {
			assertTrue(this.gerente.existeQuestaoDeExercicio("Italo", "Teste", "Quanto � 1+1?"));
		} catch (ProfessorInexistenteException e) {
			fail("n�o deveria lan�a exce��o");
		}
	}
	@Test
	public void cadastraMesmaQuestaoDuasVezesTest(){
		this.gerente.cadastrarQuestao("Italo", "Teste", "MultiEscolha", "Quanto � 1+1?", "2");
		this.gerente.cadastrarQuestao("Italo", "Teste", "MultiEscolha", "Quanto � 1+1?", "2");
		try {
			assertEquals("Professor: Italo\nExercicio: Teste\nQuanto � 1+1?\n2\n", this.gerente.getListaExercicio("Italo", "Teste"));
		} catch (ProfessorInexistenteException e) {
			fail("n�o deveria lan�a exce��o");
		}
	}
	@Test
	public void cadastraMesmaQuestaoProfessoresDiferentesTest(){
		this.gerente.cadastrarQuestao("Italo", "Teste", "MultiEscolha", "Quanto � 1+1?", "2");
		this.gerente.cadastrarQuestao("Raimundo", "Teste", "MultiEscolha", "Quanto � 1+1?", "2");
		try {
			assertEquals("Professor: Italo\nExercicio: Teste\nQuanto � 1+1?\n2\n", this.gerente.getListaExercicio("Italo", "Teste"));
			assertEquals("Professor: Raimundo\nExercicio: Teste\nQuanto � 1+1?\n2\n", this.gerente.getListaExercicio("Raimundo", "Teste"));
		} catch (ProfessorInexistenteException e) {
			fail("n�o deveria lan�a exce��o");
		}
	}
	@Test
	public void cadastraAlunoTest(){
		try {
			this.gerente.cadastrarAluno("Italo", "01");
		} catch (AlunoJaExisteException e) {
			fail("n�o deveria lan�a exece��o" + e.getMessage());
		}
	}
	@Test
	public void cadastraAlunoDuasVezesTest(){
		try {
			this.gerente.cadastrarAluno("Italo", "01");
			this.gerente.cadastrarAluno("Italo", "01");
			fail("Deveria lan�a exece��o");
		} catch (AlunoJaExisteException e) {
		}
	}
	@Test
	public void cadastraAlunoDuasVezesComNomesIguaisTest(){
		try {
			this.gerente.cadastrarAluno("Italo", "01");
			this.gerente.cadastrarAluno("Italo", "02");
		} catch (AlunoJaExisteException e) {
			fail("n�o deveria lan�a exece��o" + e.getMessage());
		}
	}
	@Test
	public void cadastraAlunoDuasVezesComMatriculasIguaisTest(){
		try {
			this.gerente.cadastrarAluno("Italo", "01");
			this.gerente.cadastrarAluno("Raimundo", "01");
			fail("Deveria lan�a exece��o");
		} catch (AlunoJaExisteException e) {
		}
	}
	@Test
	public void verificaQuestaoComProfessorErradoTest(){
		this.gerente.cadastrarQuestao("Italo", "Teste", "MultiEscolha", "Quanto � 1+1?", "2");
		try {
			assertTrue(this.gerente.existeQuestaoDeExercicio("Raimundo", "Teste", "Quanto � 1+1?"));
			fail("deveria lan�a exce��o");
		} catch (ProfessorInexistenteException e) {
		}
	}
	@Test
	public void removeQuestaoNaoCadastradaTest(){
		this.gerente.cadastrarQuestao("Italo", "Teste", "MultiEscolha", "Quanto � X em x + 1 = 0?", "-1");
		try {
			this.gerente.removerQuestao("Italo", "Teste", "Quanto � 1+1?");
			fail("deveria lan�a exce��o");
		} catch (ProfessorInexistenteException e){ 
		} catch (QuestaoInexistenteException e1){	
		}
	}
	@Test
	public void removeQuestaoCadastradaTest(){
		this.cadastrasQuestaoTest();
		try {
			this.gerente.removerQuestao("Italo", "Teste", "Quanto � 1+1?");
		} catch (ProfessorInexistenteException | QuestaoInexistenteException e) {
			fail("n�o deveria lan�a exce��o");
		}
	}
	@Test
	public void removeQuestaoCadastradaDeProfessorErradoTest(){
		this.cadastrasQuestaoTest();
		try {
			this.gerente.removerQuestao("Raimundo", "Teste", "Quanto � 1+1?");
			fail("deveria lan�a exce��o");
		} catch (ProfessorInexistenteException | QuestaoInexistenteException e) {
			
		}
	}
	@Test
	public void removeQuestaoCadastradaDuasVezesTest(){
		this.cadastraMesmaQuestaoDuasVezesTest();
		try {
			this.gerente.removerQuestao("Italo", "Teste", "Quanto � 1+1?");
		} catch (ProfessorInexistenteException | QuestaoInexistenteException e) {
			fail("n�o deveria lan�a exce��o");
		}
	}
	@Test
	public void questaoNaoCadastradaVerificaRespostaTest(){
		this.cadastrasQuestaoTest(); // nesse caso a quest�o cadastrada � diferente da que � verificada.
		try {
			this.gerente.getResposta("Italo", "Teste", "verdade � igual a verdade?");
			fail("deveria lan�a a exce��o QuestaoInexistenteException");
		} catch (ProfessorInexistenteException e) {
			fail("n�o deveria lan�a exce��o");
		} catch (QuestaoInexistenteException e) {
			
		}
	}
	@Test
	public void questaoCadastradaVerificaRespostaTest(){
		this.cadastrasQuestaoTest();
		try {
			assertEquals("2",this.gerente.getResposta("Italo", "Teste", "Quanto � 1+1?"));
		} catch (ProfessorInexistenteException e) {
			fail("n�o deveria lan�a exce��o");
		} catch (QuestaoInexistenteException e) {
			fail("n�o deveria lan�a exce��o");
		}
	}
	@Test
	public void questaoNaoCadastradaVerificaPerguntaTest(){
		this.cadastrasQuestaoTest();
		try {
			this.gerente.getPergunta("Italo", "Teste", "verdade");
			fail("deveria lan�a a exce��o QuestaoInexistenteException");
		} catch (ProfessorInexistenteException e) {
			fail("n�o deveria lan�a exce��o");
		} catch (QuestaoInexistenteException e) {
			
		}
	}
	@Test
	public void questaoCadastradaVerificaPerguntaTest(){
		this.cadastrasQuestaoTest();
		try {
			assertEquals("Quanto � 1+1?", this.gerente.getPergunta("Italo", "Teste", "2"));
		} catch (ProfessorInexistenteException e) {
			fail("n�o deveria lan�a exce��o: " + e.getMessage());
		} catch (QuestaoInexistenteException e) {
			fail("n�o deveria lan�a exce��o: " + e.getMessage());
		}
	}
	@Test
	public void existeQuestaoN�oCadastradaTest(){
		this.cadastrasQuestaoTest();
		try {
			assertFalse(this.gerente.existeQuestaoDeExercicio("Italo", "Teste", "verdade � igual a verdade?"));
		} catch (ProfessorInexistenteException e) {
			fail("n�o deveria lan�a exce��o");
		}
	}
	@Test
	public void listaDeProfessorN�oCadastradoTest(){
		try {
			this.gerente.getListaExercicio("Italo", "Teste");
			fail("deveria lan�a exce��o");
		} catch (ProfessorInexistenteException e) {
			
		}
	}
	@Test
	public void listaExercicioTest(){
		this.cadastrasQuestaoTest();
		try {
			assertEquals("Professor: Italo\nExercicio: Teste\nQuanto � 1+1?\n2\n",this.gerente.getListaExercicio("Italo", "Teste"));
		} catch (ProfessorInexistenteException e) {
			fail("N�o deveria lan�a exece��o " + e.getMessage());
		}
	}
	@Test
	public void listaExercicioInexistenteTest(){
		try {
			this.gerente.getListaExercicio("Italo", "Teste");
			fail("Deveria lan�a exece��o");
		} catch (ProfessorInexistenteException e) {
		}
	}
	@Test
	public void listaDosNomesExercicioTest(){
		this.cadastrasQuestaoTest();
		try {
			this.gerente.getListaDosNomesExerc("Italo");
		} catch (ProfessorInexistenteException e) {
			fail("N�o deveria lan�a exece��o " + e.getMessage());
		}
	}
	@Test
	public void listaDosNomesExercicioInexistenteTest(){
		try {
			this.gerente.getListaDosNomesExerc("Italo");
			fail("Deveria lan�a exece��o");
		} catch (ProfessorInexistenteException e) {
		}
	}
	@Test
	public void listaTodosExercicioTest(){
		this.cadastrasQuestaoTest();
		assertEquals("Nome Professor: Italo\n \nNome Exercicio: Teste\n \nQuanto � 1+1?\n2\n",this.gerente.getListaTodosExercicio());
	}
	@Test
	public void listaTodosExercicioVazioTest(){
		assertEquals("",this.gerente.getListaTodosExercicio());
	}
	@Test
	public void sorteaExercicioTeste(){
		this.cadastrasQuestaoTest();
		try {
			List<List<String>> list = this.gerente.getSortearExercicio();
		} catch (ListaVaziaExeception e) {
			fail(e.getMessage());
		}
	}
	@Test
	public void sorteaExercicioSemTerCadastradoQuestaoTeste(){
		try {
			List<List<String>> list = this.gerente.getSortearExercicio();
			fail("Deveria ter lan�ado exece��o");
		} catch (ListaVaziaExeception e) {
		}
	}
	@Test
	public void alteraProvaAlunoQueN�oExisteTest(){
		try {
			this.gerente.setProvaAluno("00000", "");
			fail("Deveria ter lan�ado exe��o");
		} catch (AlunoNaoExisteException e) {
			
		}
	}
	@Test
	public void alteraProvaAlunoTeste(){
		this.cadastraAlunoTest();
		try {
			this.gerente.setProvaAluno("01", "");
		} catch (AlunoNaoExisteException e) {
			fail(e.getMessage());
		}
	}
	@Test
	public void verificaSeAlunoNaoExisteTest(){
		assertFalse(this.gerente.isMatricula("0000"));
	}
	@Test
	public void verificaSeAlunoExisteTest(){
		this.cadastraAlunoTest();
		assertTrue(this.gerente.isMatricula("01"));
	}
	@Test
	public void gravaAlunoTest(){
		this.cadastraAlunoTest();
		try {
			this.gerente.gravarAluno();
		} catch (IOException e) {
			
		}
		Gerente g = new Gerente();
		assertTrue(g.isMatricula("01"));
	}
}