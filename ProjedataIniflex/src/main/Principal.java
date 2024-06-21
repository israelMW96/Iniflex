package main;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import impl.Metodo;
import model.Funcionario;

public class Principal {

	public static void main(String[] args) {
		
		//Lista para armazenar todos os funcionários
		List<Funcionario> funcionarios = new ArrayList<>();
		
		//3.1 -Inserção dos funcionários conforme tabela disponibilizada
		funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), BigDecimal.valueOf(2009.44), "Operador"));
		funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), BigDecimal.valueOf(2284.38), "Operador"));
		funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), BigDecimal.valueOf(9836.14), "Coordenador"));
		funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), BigDecimal.valueOf(19119.88), "Diretor"));
		funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), BigDecimal.valueOf(2234.68), "Recepcionista"));
		funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), BigDecimal.valueOf(1582.72), "Operador"));
		funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), BigDecimal.valueOf(4071.84), "Contador"));
		funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), BigDecimal.valueOf(3017.45), "Gerente"));
		funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), BigDecimal.valueOf(1606.85), "Eletricista"));
		funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), BigDecimal.valueOf(2799.93), "Gerente"));
		
		//3.2 - Remover o funcionário João da Lista
		Metodo.removerFuncionario(funcionarios, "João");
		
		//3.3 - Imprimir todos os funcionários conforme as especificações destacadas nos itens
		Metodo.imprimirFuncionarios(funcionarios);
		
		//3.4 - Realizar aumento de 10% do salário de todos os funcionários
		Metodo.aumentoSalario(funcionarios, BigDecimal.valueOf(0.10));
		
		//3.5 - Agrupar os funcionários por função usando MAP e Collector.groupingBy
		Map<String, List<Funcionario>> funcionariosPorFuncao = Metodo.agruparFuncionariosPorFuncao(funcionarios);
		
		//3.6 - Imprimir os funcionários agrupados por função
		Metodo.imprimirFuncionariosPorFuncao(funcionariosPorFuncao);
		
		//3.8 - Imprimir os funcionários que fazem aniversário no mês 10 e 12
		Metodo.imprimirAniversariantes(funcionarios, 10);
		Metodo.imprimirAniversariantes(funcionarios, 12);
		
		//3.9 - Imprimir funcionário com maior idade exibindo os atributos: nome e idade
		Metodo.imprimirFuncionarioMaisVelho(funcionarios);
		
		//3.10 - Imprimir lista de funcionários em ordem alfabética
		Metodo.imprimirFuncionariosOrdemAlfabetica(funcionarios);
		
		//3.11 - Imprimir total dos salários dos funcionários
		Metodo.imprimirTotalDosSalarios(funcionarios);
		
		//3.12 Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$ 1212.00
		Metodo.imprimirQtdSalariosMinimosPorFuncionario(funcionarios);
	}

}
