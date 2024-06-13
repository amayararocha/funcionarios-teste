package testePratico.industria;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

import testePratico.industria.controller.IndustriaController;
import testePratico.industria.util.IndustriaCores;

//Classe principal
public class Main {
	public static void main(String[] args) {

		IndustriaController industria = new IndustriaController();

		Scanner leia = new Scanner(System.in);

		int opcao;

		// Adicionando funcionários à lista
		industria.cadastrar("Maria", LocalDate.parse("2000-10-18"), new BigDecimal("2009.44").setScale(2, RoundingMode.HALF_EVEN), "Operador");
		industria.cadastrar("João", LocalDate.parse("1990-05-12"), new BigDecimal("2284.38").setScale(2, RoundingMode.HALF_EVEN), "Operador");
		industria.cadastrar("Caio", LocalDate.parse("1961-05-02"), new BigDecimal("9836.14").setScale(2, RoundingMode.HALF_EVEN), "Coordenador");
		industria.cadastrar("Miguel", LocalDate.parse("1988-10-14"), new BigDecimal("19119.88").setScale(2, RoundingMode.HALF_EVEN), "Diretor");
		industria.cadastrar("Alice", LocalDate.parse("1995-01-05"), new BigDecimal("2234.68").setScale(2, RoundingMode.HALF_EVEN), "Recepcionista");
		industria.cadastrar("Heitor", LocalDate.parse("1999-11-19"), new BigDecimal("1582.72").setScale(2, RoundingMode.HALF_EVEN), "Operador");
		industria.cadastrar("Arthur", LocalDate.parse("1993-03-31"), new BigDecimal("4071.84").setScale(2, RoundingMode.HALF_EVEN), "Contador");
		industria.cadastrar("Laura", LocalDate.parse("1994-07-08"), new BigDecimal("3017.45").setScale(2, RoundingMode.HALF_EVEN), "Gerente");
		industria.cadastrar("Heloísa", LocalDate.parse("2003-05-24"), new BigDecimal("1606.85").setScale(2, RoundingMode.HALF_EVEN), "Eletricista");
		industria.cadastrar("Helena", LocalDate.parse("1996-09-02"), new BigDecimal("2799.93").setScale(2, RoundingMode.HALF_EVEN), "Gerente");

		while (true) {

			System.out.println(IndustriaCores.TEXT_YELLOW + IndustriaCores.ANSI_BLACK_BACKGROUND
					          +"***************************************************** ");
			System.out.println("                                                      ");
			System.out.println("                        PROTHERA                      ");
			System.out.println("                                                      ");
			System.out.println("***************************************************** ");
			System.out.println("                                                      ");
			System.out.println("         1 - Cadastrar funcionário                    ");
			System.out.println("         2 - Listar todos os funcionários             ");
			System.out.println("         3 - Procurar funcionário por nome            ");
			System.out.println("         4 - Deletar funcionário                      ");
			System.out.println("         5 - Aplicar aumento de salário               ");
			System.out.println("         6 - Listar funcionários por função           ");
			System.out.println("         7 - Listar funcionários por ordem alfabética ");
			System.out.println("         8 - Calcular total de salários               ");
			System.out.println("         9 - Calcular salários em mínimos             ");
			System.out.println("         10 - Sair                                    ");
			System.out.println("                                                      ");
			System.out.println("***************************************************** ");
			System.out.println("Entre com a opção desejada:                           " + IndustriaCores.TEXT_RESET);

			try {
				opcao = leia.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				leia.nextLine();
				opcao = 0;
			}

			if (opcao == 10) {
				System.out.println(IndustriaCores.TEXT_WHITE_BOLD + "\nProthera - Software para gestão de riscos");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch(opcao) {

			case 1: 
			    System.out.println("Digite o nome do funcionário:");
			    String nome = leia.next();
			    System.out.println("Digite a data de nascimento do funcionário no formato yyyy-mm-dd:");
			    LocalDate dataNascimento = LocalDate.parse(leia.next());
			    System.out.println("Digite o salário do funcionário:");
			    BigDecimal salario = leia.nextBigDecimal();
			    System.out.println("Digite a função do funcionário:");
			    String funcao = leia.next();

			    // Chamar o método cadastrarNovoFuncionario
			    industria.cadastrar(nome, dataNascimento, salario, funcao);

			    keyPress();
			    break;

			case 2: 
				// Chamar o método imprimirFuncionarios
				industria.imprimirFuncionarios();
				keyPress();
				break;

			case 3: 
				// Pedir ao usuário para digitar o nome do funcionário
				System.out.println("Digite o nome do funcionário:");
				String nomeProcurado = leia.next();
				System.out.println("------------------------------");
				// Chamar o método procurarEImprimirPorNome
				industria.procurarEImprimirPorNome(nomeProcurado);

				keyPress();
				break;

			case 4: 
				// Pedir ao usuário para digitar o nome do funcionário
				System.out.println("Digite o nome do funcionário que você deseja deletar:");
				String nomeDeletar = leia.next();

				// Tentar deletar o funcionário
				boolean deletado = industria.deletar(nomeDeletar);
				if (deletado) {
					System.out.println("Funcionário deletado com sucesso.");
				} else {
					System.out.println("Funcionário não encontrado.");
				}

				keyPress();
				break;

			case 5: 

				System.out.println("Aplicando aumento de salário: ");
				// Aumentando o salário dos funcionários em 10%
				industria.aplicarAumento(new BigDecimal("0.10"));

				// Listando todos os funcionários após o aumento
				industria.imprimirFuncionarios();
				keyPress();
				break;

			case 6: 
				// Listando funcionários por função
				industria.listarFuncionariosPorFuncao();
				keyPress();
				break;

			case 7: 
				// Listando funcionários por ordem alfabética
				industria.listarFuncionariosAlfabetica();
				keyPress();
				break;

			case 8: 
				// Calcular total de salários
				BigDecimal totalSalarios = industria.calcularTotalSalarios();
				System.out.println("O total de salários é: " + totalSalarios);
				keyPress();
				break;  

			case 9: 
				// Calcular salários em mínimos
				industria.calcularSalariosMinimos();
				keyPress();
				break;

			default:
				System.out.println(IndustriaCores.TEXT_RED_BOLD + "\nOpção inválida!\n" + IndustriaCores.TEXT_RESET);
				keyPress();
				break;

			}	
		}
	}

	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto desenvolvido por: Mayara Rocha");
		System.out.println("mayara_rocha.pej@hotmail.com");
		System.out.println("github.com/amayararocha");
		System.out.println("*********************************************************");
	}

	public static void keyPress() {
		System.out.println(IndustriaCores.TEXT_RESET + "\n\nPressione enter para continuar...");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		try {
			reader.readLine();
		} catch (IOException e) {
			System.out.println("Ocorreu um erro ao ler a entrada do usuário.");
		}
	}
}