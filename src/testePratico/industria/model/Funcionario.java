package testePratico.industria.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import testePratico.industria.util.Formatadores;

//Classe funcionário estendendo classe pessoa
public class Funcionario extends Pessoa{

	//atributos
	private BigDecimal salario;

	private String funcao;

	// Construtor
	public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
		super(nome, dataNascimento);
		this.salario = salario;
		this.funcao = funcao;
	}

	// Getters e Setters
	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	@Override
	public String toString() {
	    return "Nome: " + this.getNome() + "\n" +
	           "Data de Nascimento: " + this.getDataNascimento().format(Formatadores.FORMATTER_DATA) + "\n" +
	           "Salário: " + Formatadores.DECIMAL_FORMAT_SALARIO.format(this.getSalario()) + "\n" +
	           "Função: " + this.getFuncao() + "\n" +
	           "-----------------------------------";
	}

}
