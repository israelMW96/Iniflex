package utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;

public class Calculo {

	private static final BigDecimal SALARIO_MINIMO = BigDecimal.valueOf(1212.00);
	
	public static int calcularIdade(LocalDate dataNascimento) {
		LocalDate hoje = LocalDate.now();
		return Period.between(dataNascimento, hoje).getYears();
	}
	
	public static BigDecimal calcularQtdSalariosMinimos(BigDecimal salario) {
		return salario.divide(SALARIO_MINIMO, 2, RoundingMode.HALF_UP);
	}
}
