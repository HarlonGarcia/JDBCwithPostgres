import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SQLService sql = new SQLService();
		
		boolean continuar = true;
		
		do {
			System.out.print("\n1- Camisas"
					+ "\n2- Vendas"
					+ "\n3- Vendedores"
					+ "\n4- Sair");
			System.out.print("\nDigite qualquer coisa: ");
			int opcao_tabela = Integer.parseInt(sc.nextLine());
			
			if (opcao_tabela == 1) {
				boolean continuar_camisas = false;
				
				do {
					System.out.print("\n1- Listar camisas"
							+ "\n2- Inserir camisa"
							+ "\n3- Atualizar preco da camisa"
							+ "\n4- Remover camisa");
					System.out.print("\nDigite qualquer coisa: ");
					int opcao = Integer.parseInt(sc.nextLine());
					
					if (opcao == 1) {
						sql.listarCamisas();
						System.out.println();
					} else if (opcao == 2) {
						System.out.println("\nDigite o codigo da camisa: ");
						int codigo = Integer.parseInt(sc.nextLine());
						System.out.println("Digite o tamanho da camisa (P / M / G): ");
						String tamanho = Character.toString(sc.nextLine().charAt(0)).toUpperCase();
						System.out.println("Digite a marca da camisa: ");
						String marca = sc.nextLine();
						System.out.println("Digite o preco da camisa: ");
						double preco = Double.parseDouble(sc.nextLine());
						System.out.println("Digite uma descricao para a camisa: ");
						String descricao = sc.nextLine();
						sql.inserirCamisa(codigo, tamanho, marca, preco, descricao);
					} else if (opcao == 3) {
						System.out.println("\nDigite o codigo da camisa: ");
						int codigo = Integer.parseInt(sc.nextLine());
						System.out.println("Digite o preco da camisa: ");
						double preco = Double.parseDouble(sc.nextLine());
						sql.atualizarCamisa(codigo, preco);
					} else if (opcao == 4) {
						System.out.println("\nDigite o codigo da camisa: ");
						int codigo = Integer.parseInt(sc.nextLine());
						sql.deletarCamisa(codigo);
					} else if (opcao == 5) {
						continuar_camisas = false;
					} else {
						System.out.print("\nDigite uma opcao valida!");
					}
				} while (continuar_camisas);
			} else if (opcao_tabela == 2) {
				boolean continuar_vendas = false;
				
				do {
					System.out.print("\n1- Listar vendas"
							+ "\n2- Cadastrar vendas"
							+ "\n3- Atualizar quantidade de vendas"
							+ "\n4- Deletar venda");
					System.out.print("\nDigite qualquer coisa: ");
					int opcao = Integer.parseInt(sc.nextLine());
					
					if (opcao == 1) {
						sql.listarVendas();
						System.out.println();
					} else if (opcao == 2) {
						System.out.println("\nDigite o id da venda: ");
						int id = Integer.parseInt(sc.nextLine());
						System.out.println("Digite o id do vendedor: ");
						int idVendedor = Integer.parseInt(sc.nextLine());
						System.out.println("Digite o codigo da camisa: ");
						int codigoCamisa = Integer.parseInt(sc.nextLine());
						System.out.println("Digite o valor total da venda: ");
						double valor = Double.parseDouble(sc.nextLine());
						System.out.println("Digite a quantidade de camisas: ");
						int quantidade = Integer.parseInt(sc.nextLine());
						sql.inserirVenda(id, idVendedor, codigoCamisa, valor, quantidade);
					} else if (opcao == 3) {
						System.out.println("\nDigite o id da venda: ");
						int id = Integer.parseInt(sc.nextLine());
						System.out.println("Digite a quantidade de camisas: ");
						int quantidade = Integer.parseInt(sc.nextLine());
						sql.atualizarVenda(id, quantidade);
					} else if (opcao == 4) {
						System.out.println("\nDigite o id da venda: ");
						int id = Integer.parseInt(sc.nextLine());
						sql.deletarVenda(id);
					} else if (opcao == 5) {
						continuar_vendas = false;
					} else {
						System.out.print("\nDigite uma opcao valida!");
					}
				} while (continuar_vendas);
			} else if (opcao_tabela == 3) {
				boolean continuar_vendedores = false;
				
				do {
					System.out.print("\n1- Listar vendedores"
							+ "\n2- Cadastrar vendedor"
							+ "\n3- Atualizar vendedor"
							+ "\n4- Deletar vendedor");
					System.out.print("\nDigite qualquer coisa: ");
					int opcao = Integer.parseInt(sc.nextLine());
					
					if (opcao == 1) {
						sql.listarVendedores();
						System.out.println();
					} else if (opcao == 2) {
						System.out.println("\nDigite o id da vendedor: ");
						int id = Integer.parseInt(sc.nextLine());
						System.out.println("Digite o nome do vendedor: ");
						String nome = sc.nextLine();
						System.out.println("Digite o cpf do vendedor: ");
						String cpf = sc.nextLine();
						System.out.println("Digite o salario do vendedor: ");
						double salario = Double.parseDouble(sc.nextLine());
						sql.inserirVendedor(id, nome, cpf, salario);
					} else if (opcao == 3) {
						System.out.println("\nDigite o id do vendedor: ");
						int id = Integer.parseInt(sc.nextLine());
						System.out.println("Digite o salario do vendedor: ");
						double salario = Double.parseDouble(sc.nextLine());
						sql.atualizarVendedor(id, salario);
					} else if (opcao == 4) {
						System.out.println("\nDigite o id do vendedor: ");
						int id = Integer.parseInt(sc.nextLine());
						sql.deletarVendedor(id);
					} else if (opcao == 5) {
						continuar_vendedores = false;
					} else {
						System.out.print("\nDigite uma opcao valida!");
					}
				} while (continuar_vendedores);
			} else if (opcao_tabela == 4) {
				System.out.println("\nDesconectando...");
				continuar = false;
			} else {
				System.out.println("\nDigite uma opcao valida!");
			}
		} while (continuar);
	}
}
