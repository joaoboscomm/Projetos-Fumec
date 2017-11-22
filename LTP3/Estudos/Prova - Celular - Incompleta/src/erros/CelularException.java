package erros;

public class CelularException extends Exception {
	private static final long serialVersionUID = 1L;

	public CelularException(String erro){
		super(erro);
	}
}