package Dados;

import java.util.ArrayList;
import java.util.List;

import Exception.AlunoJaExisteException;

public class Aluno {

	List<Aluno> alunos;
	
	private String nome;
	private String matricula;
	
	public Aluno(String nome, String matricula){
		this.nome = nome;
		this.matricula = matricula;
		
	}
	
	public String getNome(){
		return this.nome;		
	}
	public String getMatricula(){
		return this.matricula;
	}
	public void setNome(String nome){
		this.nome = nome;
	}
	public void setMatricula(String matricula){
		this.matricula = matricula;
	}

	public String toString() {
		return "Pessoa [nome = " + nome + ", matricula = " + matricula + "]";
	}
}