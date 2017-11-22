package dados;

import java.io.Serializable;
import java.util.GregorianCalendar;

import utilitarios.LtpUtil;

public class Celular implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final int CELULAR = 1;
	
	public static final int CELULARCARTAO = 2;
	
	protected String numero;
	
	protected GregorianCalendar data;

	public Celular(String numero, GregorianCalendar data) {
		super();
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
	
	public int getTipo(){
		return CELULAR;
	}

	@Override
	public String toString() {
		return "\n \tNumero do Celular: " + numero + "\n \t Data: " + LtpUtil.formatarData(data, "dd/MM/yyyy");
	}
}