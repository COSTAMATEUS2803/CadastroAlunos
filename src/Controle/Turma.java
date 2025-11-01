package Controle;

import java.util.ArrayList;
import Entidade.Aluno;

public class Turma {
	
	int contador = 0;
	Aluno[] alunos;
	private static int CAPACIDADE_MAXIMA = 40;
	
	public Turma() {
		this.contador = 0;
		this.alunos = new Aluno[CAPACIDADE_MAXIMA];
	}
	
	public void adicionarAluno(Aluno a){
		if(this.contador < 40) {
			this.alunos[this.contador] = a;
			this.contador++;
			System.out.println("Aluno: " + a.getNome() + " adicionado com sucesso à turma!");
		} else {
			System.out.println("Erro! Aluno: " + a.getNome() + " não foi adicionadoà turma! Turma Cheia!");
		}
	}
	
	public ArrayList<String> listarAlunos() {
        ArrayList<String> dadosAluno = new ArrayList<>();
        
        if(this.contador == 0) {
        	return dadosAluno;
        } else {
	        for (int i = 0; i < this.contador; i++) {
	            Aluno a = this.alunos[i];
	            double[][] notasDoAluno = a.getNotas();
	            String dados = "\n\n\nAluno: " + a.getNome() + 
	            			   "\nMatricula: " + a.getMatricula() + 
	            			   "\nSemestre 1:\n" + 
	            			   "Nota 1: " + notasDoAluno[0][0] + 
	                           "; Nota 2: " + notasDoAluno[0][1] + 
	                           "\nSemestre 2:\n" +
	                           "Nota 1: " + notasDoAluno[1][0] + 
	                           "; Nota 2: " + notasDoAluno[1][1] +
	            			   "\nMédia Final: " + a.calcularMedia();
	            dadosAluno.add(dados);
	        }
        }
        
	return dadosAluno;
	}
	
	public Aluno consultarAluno(int Matricula) {
		for(int i = 0; i < this.contador; i++) {
			Aluno a = this.alunos[i];
			if(a.getMatricula() == Matricula) {
				return a;
			}
		}
		return null;
	}
	
	public Aluno consultarAluno(String Nome) {
		for(int i = 0; i < this.contador; i++) {
			Aluno a = this.alunos[i];
			if(a.getNome().equalsIgnoreCase(Nome)) {
				return a;
			}
		}
		return null;
	}
}
