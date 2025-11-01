package Entidade;

public class Aluno {

	private int Matricula;
	private String Nome;
	private double[][] Notas;
	
	public Aluno(int matricula, String nome, double[][] notas) {
		this.Matricula = matricula;
		this.Nome = nome;
		this.Notas = notas;
	}
	
	public double calcularMedia() {
		double soma = 0;
		double totalNotas = 0;
		
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < this.Notas[i].length; j++) {
				soma += this.Notas[i][j];
				totalNotas++;
			}
		}
		return soma/totalNotas;
	}
	
	public int getMatricula() {
		return Matricula;
	}

	public void setMatricula(int matricula) {
		Matricula = matricula;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}
	
	public double getNota(int bimestre, int nota) {
        return this.Notas[bimestre][nota];
    }
    
    public void setNota(int bimestre, int nota, double valor) {
        this.Notas[bimestre][nota] = valor;
    }
    
	public double[][] getNotas() {
		return Notas;
	}

	public void setNotas(double[][] notas) {
		Notas = notas;
	}
}


