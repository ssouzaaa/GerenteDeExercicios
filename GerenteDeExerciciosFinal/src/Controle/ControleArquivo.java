package Controle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ControleArquivo {

	public ControleAluno lerControleAluno() throws IOException {
		ObjectInputStream object = null;
		try {
			object = new ObjectInputStream(new FileInputStream("controleAluno.txt"));
			return (ControleAluno) object.readObject();
		} catch (FileNotFoundException e) {
			throw new IOException("Arquivos não encontado " + e.getMessage());
		}catch (ClassNotFoundException e) {
			throw new IOException("Classe dos objetos não foram encontados",e);
		}finally{
			if(object != null){
				object.close();
			}
		}
	}
	
	public void gravarControleAluno(ControleAluno controleAluno) throws IOException{
		ObjectOutputStream out = null;
		try{
			out = new ObjectOutputStream(new FileOutputStream("controleAluno.txt"));
			out.writeObject(controleAluno);
		}catch(FileNotFoundException e){
			throw new IOException("Arquivo não encontado");
		}catch(IOException e){
			throw e;
		}finally{
			if(out != null){
				out.close();
			}
		}
	}
	
	public ControleExercicios lerControleExercicio() throws IOException {
		ObjectInputStream object = null;
		try {
			object = new ObjectInputStream(new FileInputStream("controleExercicios.txt"));
			return (ControleExercicios) object.readObject();
		} catch (FileNotFoundException e) {
			throw new IOException("Arquivos não encontado " + e.getMessage());
		}catch (ClassNotFoundException e) {
			throw new IOException("Classe dos objetos não foram encontados",e);
		}finally{
			if(object != null){
				object.close();
			}
		}
	}
	
	public void gravaControleExercicio(ControleExercicios controleExercicios) throws IOException{
		ObjectOutputStream out = null;
		try{
			out = new ObjectOutputStream(new FileOutputStream("controleExercicios.txt"));
			out.writeObject(controleExercicios);
		}catch(FileNotFoundException e){
			throw new IOException("Arquivo não encontado");
		}catch(IOException e){
			throw e;
		}finally{
			if(out != null){
				out.close();
			}
		}
	}
	
	public ControleProfessor lerControleProfessor() throws IOException {
		ObjectInputStream object = null;
		try {
			object = new ObjectInputStream(new FileInputStream("controleprofessor.txt"));
			return (ControleProfessor) object.readObject();
		} catch (FileNotFoundException e) {
			throw new IOException("Arquivos não encontado " + e.getMessage());
		}catch (ClassNotFoundException e) {
			throw new IOException("Classe dos objetos não foram encontados",e);
		}finally{
			if(object != null){
				object.close();
			}
		}
	}
	
	public void gravaControleprofessor(ControleProfessor controleprofessor) throws IOException{
		ObjectOutputStream out = null;
		try{
			out = new ObjectOutputStream(new FileOutputStream("controleprofessor.txt"));
			out.writeObject(controleprofessor);
		}catch(FileNotFoundException e){
			throw new IOException("Arquivo não encontado");
		}catch(IOException e){
			throw e;
		}finally{
			if(out != null){
				out.close();
			}
		}
	}
}
