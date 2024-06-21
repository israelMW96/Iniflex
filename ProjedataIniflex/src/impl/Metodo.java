package impl;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import model.Funcionario;
import utils.Calculo;
import utils.Formatador;

public class Metodo {

	public static void removerFuncionario(List<Funcionario> funcionarios, String nome) {
		Iterator<Funcionario> iterator = funcionarios.iterator();
		while (iterator.hasNext()) {
			Funcionario funcionario = iterator.next();
			if (funcionario.getNome().equals(nome)) {
				iterator.remove();
				System.out.println("Funcionário " + nome + " removido com sucesso!");
				return;
			}
		}
		System.out.println("Funcionário " + nome + " não encontrado!");
	}

	public static void imprimirFuncionarios(List<Funcionario> funcionarios) {
		System.out.println("\nLista de Funcionários:");
		for (Funcionario funcionario : funcionarios) {
			System.out.println("Nome: " + funcionario.getNome() + " | Data de Nascimento: "
					+ Formatador.formatarDataNascimento(funcionario.getDataNascimento()) + " | Salário: "
					+ Formatador.formatarSalario(funcionario.getSalario()) + " | Função: " + funcionario.getFuncao());
		}
	}

	public static void aumentoSalario(List<Funcionario> funcionarios, BigDecimal percentualAumento) {
		for (Funcionario funcionario : funcionarios) {
			BigDecimal salarioAtual = funcionario.getSalario();
			BigDecimal aumento = salarioAtual.multiply(percentualAumento);
			BigDecimal salarioComAumento = salarioAtual.add(aumento);
			funcionario.setSalario(salarioComAumento);
		}
	}

	public static Map<String, List<Funcionario>> agruparFuncionariosPorFuncao(List<Funcionario> funcionarios) {
		return funcionarios.stream().collect(Collectors.groupingBy(Funcionario::getFuncao));
	}

	public static void imprimirFuncionariosPorFuncao(Map<String, List<Funcionario>> funcionariosPorFuncao) {
		funcionariosPorFuncao.forEach((funcao, listaFuncionarios) -> {
			System.out.println("\nFunção: " + funcao);
			System.out.println("Funcionários:");
			listaFuncionarios.forEach(funcionario -> {
				System.out.println("\tNome: " + funcionario.getNome() + " | Data de Nascimento: "
						+ Formatador.formatarDataNascimento(funcionario.getDataNascimento()) + " | Salário: "
						+ Formatador.formatarSalario(funcionario.getSalario()));
			});
		});
	}

	public static void imprimirAniversariantes(List<Funcionario> funcionarios, int mesAniversario) {
		System.out.println("\nAniversariantes do mês " + mesAniversario);
		for (Funcionario funcionario : funcionarios) {
			if (funcionario.getDataNascimento().getMonthValue() == mesAniversario) {
				System.out.println("Nome: " + funcionario.getNome() + " | Data de Nascimento: "
						+ Formatador.formatarDataNascimento(funcionario.getDataNascimento()));
			}
		}
	}

	public static void imprimirFuncionarioMaisVelho(List<Funcionario> funcionarios) {
		Funcionario funcionarioMaisVelho = null;
		int maiorIdade = 0;
		for (Funcionario funcionario : funcionarios) {
			int idade = Calculo.calcularIdade(funcionario.getDataNascimento());
			if (idade > maiorIdade) {
				maiorIdade = idade;
				funcionarioMaisVelho = funcionario;
			}
		}
		System.out.println("\nFuncionário Mais Velho:");
		System.out.println("Nome: " + funcionarioMaisVelho.getNome() + " | Idade: "
				+ Calculo.calcularIdade(funcionarioMaisVelho.getDataNascimento()));
	}

	public static void imprimirFuncionariosOrdemAlfabetica(List<Funcionario> funcionarios) {
		Collections.sort(funcionarios, Comparator.comparing(Funcionario::getNome));
		System.out.println("\nLista de Funcionários em ordem Alfabética:");
		for (Funcionario funcionario : funcionarios) {
			System.out.println("Nome: " + funcionario.getNome() + " | Data de Nascimento: "
					+ Formatador.formatarDataNascimento(funcionario.getDataNascimento()) + " | Salário: "
					+ Formatador.formatarSalario(funcionario.getSalario()) + " | Função: " + funcionario.getFuncao());
		}
	}

	public static void imprimirTotalDosSalarios(List<Funcionario> funcionarios) {
		BigDecimal totalSalarios = BigDecimal.ZERO;
		for (Funcionario funcionario : funcionarios) {
			totalSalarios = totalSalarios.add(funcionario.getSalario());
		}
		System.out.println("\nTotal dos salários dos funcionários: " + Formatador.formatarSalario(totalSalarios));
	}

	public static void imprimirQtdSalariosMinimosPorFuncionario(List<Funcionario> funcionarios) {
		System.out.println("\nQuantidade de salários mínimos por funcionário: ");
		for (Funcionario funcionario : funcionarios) {
			BigDecimal qtdSalariosMinimos = Calculo.calcularQtdSalariosMinimos(funcionario.getSalario());
			System.out.println("Funcionário: " + funcionario.getNome() + " | Salário: "
					+ Formatador.formatarSalario(funcionario.getSalario()) + " | Quantidade de salários mínimos: "
					+ qtdSalariosMinimos);

		}
	}
}
