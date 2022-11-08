import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SQLService sql = new SQLService();
		
		boolean continuar = true;

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
				continuar = false;
				System.out.print("\nDesconectando...");
			} else {
				System.out.print("\nDigite uma opcao valida!");
			}
		} while (continuar);
	}
}
