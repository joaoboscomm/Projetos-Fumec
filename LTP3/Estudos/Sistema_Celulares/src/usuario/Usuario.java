package usuario;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import cadastro.CadClientesCelular;
import dados.Celular;
import dados.ClienteCelular;
import erros.CelularException;
import utilitarios.Console;

public class Usuario {
	
	private static CadClientesCelular objClientes = new CadClientesCelular();

	public static void main(String[] args) {
		menu();					
		
		System.out.println("\n \t \t --> Programa Sera Encerrado! <--");
		System.exit(0);
	}

	
	private static void menu() {
		int opcao;
		do {
			System.out.print("\n \t \t \t \t  ---- SISTEMA CONTROLE DE CLIENTES DE CELULARES ---- ");
			System.out.print("\n \t 1 - Cadastro de Cliente. \n");
			System.out.print("\n \t 2 - Exclusao de Cliente. \n");
			System.out.print("\n \t 3 - Consulta Cliente por CPF. \n");
			System.out.print("\n \t 4 - Consulta Cliente por Numero. \n");
			System.out.print("\n \t 5 - Consulta Cliente por Nome. \n");
			System.out.print("\n \t 6 - Inclusao de Celular. \n");
			System.out.print("\n \t 7 - Exclusao de Celular. \n");
			System.out.print("\n \t 0 - Finalizar Programa. \n");
			opcao = Console.readInt("\n \t Selecione uma opcao: ");
			switch (opcao) {
			case 1:
				cadastrarCliente();
				break;
			case 2:
				excluirCliente();
				break;
			case 3:
				consultarClienteCPF();
				break;
			case 4:
				consultaClienteNum();
				break;
			case 5:
				consultarClienteNome();
				break;
			case 6:
				incluirCelularCliente();
				break;
			case 7:
				excluirCelularCliente();
				break;
			case 0:
				break;
			default:
				System.out.println("\n \t Opcao Inserida é Invalida!");
				break;
			}
		} while (opcao != 0);
	}
	
	
	private static void cadastrarCliente() {
		String cpf = Console.readLine("CPF: ");
		String nome = Console.readLine("NOME: ");
		GregorianCalendar data = new GregorianCalendar();
		ArrayList<Celular> listaCelulares = new ArrayList<Celular>();
				
		try {
			objClientes.incluirCliente(new ClienteCelular(cpf, nome, data, listaCelulares));
			System.out.println("CLIENTE CADASTRADO COM SUCESSO!");
		} catch (CelularException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	private static void excluirCliente() {		
		try {
			objClientes.excluirClienteCpf(Console.readLine("CPF: "));
			System.out.println("CLIENTE EXCLUIDO COM SUCESSO!");
		} catch (CelularException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void consultarClienteCPF() {
		ClienteCelular cliente;
		try {
			cliente = objClientes.consultarClienteCPF(Console.readLine("CPF: "));
			System.out.println(cliente.toString());
			if(!cliente.getListaCelulares().isEmpty())
				for (Celular obj : cliente.getListaCelulares()) {
					System.out.println(obj.toString());
				}
		} catch (CelularException e) {
			System.out.println(e.getMessage());
		}
	}

	
	private static void consultaClienteNum() {
		ClienteCelular cliente;
		try {
			cliente = objClientes.consultarClienteNumero(Console.readLine("Nº CELULAR: "));
			System.out.println(cliente.toString());
			if(!cliente.getListaCelulares().isEmpty())
				for (Celular obj : cliente.getListaCelulares()) {
					System.out.println(obj.toString());
				}
		} catch (CelularException e) {
			System.out.println(e.getMessage());
		}
	}
	

	private static void consultarClienteNome() {
		ArrayList<ClienteCelular> lista = new ArrayList<ClienteCelular>();
		try {
			lista = objClientes.consultarClienteNome(Console.readLine("NOME: "));
			for (ClienteCelular obj : lista) {
				System.out.println(obj.toString());
				if (!obj.getListaCelulares().isEmpty()) {
					for (Celular objCel : obj.getListaCelulares()) {
						System.out.println(objCel.toString());
					}
				}
				System.out.println("------------");
			}
		} catch (CelularException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Método para incluir um nº celular para um cliente já
	 * cadastrado no sistema.
	 */
	private static void incluirCelularCliente() {
		String cpf = Console.readLine("CPF [CLIENTE]: ");
		String numero = Console.readLine("Nº CELULAR:: ");
		try {
			objClientes.incluirCelular(objClientes.consultarClienteCPF(cpf), 
					new Celular(numero, new GregorianCalendar()));
			System.out.println("CELULAR INCLUIDO COM SUCESSO.");
		} catch (CelularException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Método para excluir um nº celular de um cliente já
	 * cadastrado no sistema.
	 */
	private static void excluirCelularCliente() {
		String confirma;
		
		String cpf = Console.readLine("CPF [CLIENTE]: ");
		String numero = Console.readLine("Nº CELULAR: ");
		
		
		confirma = Console.readLine("TEM CERTEZA QUE DESEJA EXCLUIR ESTE Nº? [S/N]: ").toUpperCase();
	
		if(confirma.equals("S")) {
			try {
				objClientes.excluirCelular(objClientes.consultarClienteCPF(cpf), numero);
				System.out.println("Nº CELULAR RETIRADO COM SUCESSO.");
			} catch (CelularException e) {
				System.out.println(e.getMessage());
			}	
		}		
	}

}
