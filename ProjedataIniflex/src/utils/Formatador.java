package utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Formatador {

	public static String formatarSalario(BigDecimal salario) {
		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator(',');
		simbolos.setGroupingSeparator('.');

		DecimalFormat df = new DecimalFormat("#,##0.00", simbolos);
		return df.format(salario);
	}

	public static String formatarDataNascimento(LocalDate data) {
		DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return data.format(dataFormatada);
	}
}
