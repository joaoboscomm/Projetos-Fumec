package Dados;

import java.util.GregorianCalendar;
import utilitarios.LtpUtil;

public class CelularCartao extends Celular {
	
	//Atributos
	private double creditos;

	//Metodo Construtor - Inicializar Atributos
	
	public CelularCartao(String numero, GregorianCalendar data, double creditos) {
		super(numero, data);
		this.creditos = creditos;
	}

	//Metodos Get e Set - Obter e Alterar Atributos
	
	public double getCreditos() {
		return creditos;
	}

	public void setCreditos(double creditos) {
		this.creditos = creditos;
	}
	
	//Metodo ToString - Retornar Atributos em String
	
	public String toString() {
		return
			super.toString() +
			"\n \tCreditos: " + LtpUtil.formatarValor(creditos, "R$#,##0.00");
	}
	
	
	//Metodo getTipo - Retornar valor CELULARCARTAO
	
	public int getTipo() {
		return CELULARCARTAO;
	}
}
