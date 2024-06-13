package testePratico.industria.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import testePratico.industria.model.Funcionario;
import testePratico.industria.repository.IndustriaRepository;
import testePratico.industria.util.Formatadores;

public class IndustriaController implements IndustriaRepository {

	private List<Funcionario> funcionarios = new ArrayList<>();

	@Override
	public Funcionario procurarPorNome(String nome) {
		return funcionarios.stream()
				.filter(funcionario -> funcionario.getNome().equalsIgnoreCase(nome))
				.findFirst()
				.orElse(null);
	}

	@Override
	public List<Funcionario> listarTodos() {
		return new ArrayList<>(funcionarios);
	}

	@Override
	public void cadastrar(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
	    Funcionario novoFuncionario = new Funcionario(nome, dataNascimento, salario, funcao);
	    funcionarios.add(novoFuncionario);
	    System.out.println("Funcionário cadastrado com sucesso!");
	}

	@Override
	public boolean deletar(String nome) {
		Funcionario funcionario = procurarPorNome(nome);
		if (funcionario != null) {
			funcionarios.removeIf(f -> f.getNome().equals(nome));
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void aplicarAumento(BigDecimal porcentagem) {
		funcionarios = funcionarios.stream()
				.peek(funcionario -> {
					BigDecimal salarioAtual = funcionario.getSalario();
					BigDecimal aumento = salarioAtual.multiply(porcentagem);
					funcionario.setSalario(salarioAtual.add(aumento));
				})
				.collect(Collectors.toList());
	}

	@Override
	public void listarFuncionariosPorFuncao() {
		Map<String, List<Funcionario>> funcionariosPorFuncao = funcionarios.stream()
				.collect(Collectors.groupingBy(Funcionario::getFuncao));

		funcionariosPorFuncao.forEach((funcao, funcionarios) -> {
			System.out.println("Função: " + funcao);
			funcionarios.forEach(funcionario -> System.out.println("Nome: " + funcionario.getNome()));
			System.out.println("-----------------------------------");
		});
	}

	@Override
	public void listarFuncionariosAlfabetica() {
		List<Funcionario> funcionariosOrdenados = funcionarios.stream()
				.sorted(Comparator.comparing(Funcionario::getNome))
				.collect(Collectors.toList());

		funcionariosOrdenados.forEach(funcionario -> {
			System.out.println("Nome: " + funcionario.getNome());
			System.out.println("Função: " + funcionario.getFuncao());
			System.out.println("-----------------------------------");
		});
	}

	@Override
	public BigDecimal calcularTotalSalarios() {
		BigDecimal totalSalarios = funcionarios.stream()
				.map(Funcionario::getSalario)
				.reduce(BigDecimal.ZERO, BigDecimal::add);

		return totalSalarios;
	}

	@Override
	public void calcularSalariosMinimos() {
		BigDecimal salarioMinimo = new BigDecimal("1212.00");

		for (Funcionario funcionario : funcionarios) {
			BigDecimal salarioFuncionario = funcionario.getSalario();
			BigDecimal salariosMinimos = salarioFuncionario.divide(salarioMinimo, 2, RoundingMode.HALF_UP);

			System.out.println("Nome: " + funcionario.getNome());
			System.out.println("Salários em mínimos: " + salariosMinimos);
			System.out.println("-----------------------------------");
		}
	}

	@Override
	public void procurarEImprimirPorNome(String nome) {
		Funcionario funcionario = procurarPorNome(nome);
		if (funcionario != null) {
			System.out.println(funcionario.toString());
		} else {
			System.out.println("Funcionário não encontrado.");
		}
	}

	public void imprimirFuncionarios() {
		for (Funcionario funcionario : funcionarios) {
			System.out.println("Nome: " + funcionario.getNome());
			System.out.println("Data de Nascimento: " + funcionario.getDataNascimento().format(Formatadores.FORMATTER_DATA));
			System.out.println("Salário: " + Formatadores.DECIMAL_FORMAT_SALARIO.format(funcionario.getSalario()));
			System.out.println("Função: " + funcionario.getFuncao());
			System.out.println("-----------------------------------");
		}
	}
}
