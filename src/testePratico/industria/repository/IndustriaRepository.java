package testePratico.industria.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import testePratico.industria.model.Funcionario;

public interface IndustriaRepository {

    // CRUD do Funcionario
    public Funcionario procurarPorNome(String nome);
    public List<Funcionario> listarTodos();
    void cadastrar(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao);
    public boolean deletar(String nome);

    // Métodos da Industria
    public void aplicarAumento(BigDecimal porcentagem);
    public void listarFuncionariosPorFuncao();
    public void listarFuncionariosAlfabetica();
    public BigDecimal calcularTotalSalarios();
    public void calcularSalariosMinimos();
    public void procurarEImprimirPorNome(String nome);
	
}
