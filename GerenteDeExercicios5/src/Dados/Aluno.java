package Dados;

import java.io.Serializable;

public class Aluno implements Serializable{

	private String prova;
	
	private String nome;
	private String matricula;
	
	public Aluno(String nome, String matricula){
		this.nome = nome;
		this.matricula = matricula;
		this.prova = new String();
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
	public void setExercicio(String prova){
		String s = " Nome: " + this.nome + "\n" + " Matricula: " + this.matricula + "\n" + prova + "\n";
		this.prova += s;
	}
	public String getExercicio(){
		return this.prova;
	}
	public String toString() {
		return "Pessoa [nome = " + nome + ", matricula = " + matricula + "]";
	}
}