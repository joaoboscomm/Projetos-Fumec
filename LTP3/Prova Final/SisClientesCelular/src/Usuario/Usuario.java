package Usuario;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import Cadastro.CadClientesCelular;
import Dados.Celular;
import Dados.ClienteCelular;
import Erros.CelularException;
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
		String cpf = Console.readLine("\n \t CPF: ");
		String nome = Console.readLine("\n \t Nome: ");
		GregorianCalendar data = new GregorianCalendar();
		ArrayList<Celular> listaCelulares = new ArrayList<Celular>();
				
		try {
			objClientes.incluirCliente(new ClienteCelular(cpf, nome, data, listaCelulares));
			System.out.println("\n \t Cliente Foi Cadastrado com Sucesso!");
		} catch (CelularException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	private static void excluirCliente() {		
		try {
			objClientes.excluirClienteCpf(Console.readLine("\n \t CPF: "));
			System.out.println("\n \t Cliente Foi Excluido com Sucesso!");
		} catch (CelularException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void consultarClienteCPF() {
		ClienteCelular cliente;
		try {
			cliente = objClientes.consultarClienteCPF(Console.readLine("\n \t CPF: "));
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
			cliente = objClientes.consultarClienteNumero(Console.readLine("\n \t Numero do Celular: "));
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
			lista = objClientes.consultarClienteNome(Console.readLine("\n \t Nome: "));
			for (ClienteCelular obj : lista) {
				System.out.println(obj.toString());
				if (!obj.getListaCelulares().isEmpty()) {
					for (Celular objCel : obj.getListaCelulares()) {
						System.out.println(objCel.toString());
					}
				}
				System.out.println("\n \t ------------");
			}
		} catch (CelularException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	private static void incluirCelularCliente() {
		String cpf = Console.readLine("\n \t CPF: ");
		String numero = Console.readLine("\n \t Numero do Celular: ");
		try {
			objClientes.incluirCelular(objClientes.consultarClienteCPF(cpf), 
					new Celular(numero, new GregorianCalendar()));
			System.out.println("\n \t Celular foi Incluido com Sucesso!");
		} catch (CelularException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void excluirCelularCliente() {
		String confirma;
		
		String cpf = Console.readLine("\n \t CPF: ");
		String numero = Console.readLine("\n \t Numero do Celular: ");
		
		
		confirma = Console.readLine("\n \t Selecione: \n \t (S) - CONFIRMAR \n \t (N) - CANCELAR ").toUpperCase();
	
		if(confirma.equals("S")) {
			try {
				objClientes.excluirCelular(objClientes.consultarClienteCPF(cpf), numero);
				System.out.println("\n \t Numero foi retirado com sucesso!");
			} catch (CelularException e) {
				System.out.println(e.getMessage());
			}	
		}		
	}

}
