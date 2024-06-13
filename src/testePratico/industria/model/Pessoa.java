package testePratico.industria.model;

import java.time.LocalDate;

//Classe pessoas
public abstract class Pessoa {
	
	//Atributos
	private String nome; 
	
	private LocalDate dataNascimento;
	
	//Construtor
	public Pessoa(String nome, LocalDate dataNascimento) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}

	//Getters e Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
