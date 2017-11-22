package Dados;

import java.util.GregorianCalendar;
import utilitarios.LtpUtil;

public class Celular {
	public static int CELULAR = 1;
	public static int CELULARCARTAO = 2;
	
	protected String numero;
	protected GregorianCalendar data;
	
	public Celular(String numero, GregorianCalendar data) {
		this.numero = numero;
		this.data = data;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public GregorianCalendar getData() {
		return data;
	}

	public void setData(GregorianCalendar data) {
		this.data = data;
	}
	
	public String toString() {
		return
			"\n \t Celular: " + numero + 
			"\n \t Data: " + LtpUtil.formatarData(data, "dd/MM/yyyy");
	}
	
	public int getTipo() {
		return CELULAR;
	}
}
