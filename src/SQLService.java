import java.sql.SQLException;
import java.util.List;

import DAO.CamisaDAO;
import DAO.VendaDAO;
import DAO.VendedorDAO;
import model.Camisa;
import model.Venda;
import model.Vendedor;

public class SQLService {
	// CAMISA
	public void inserirCamisa(int codigo, String tamanho, String marca, double preco, String descricao) {
		Camisa camisa = new Camisa();
		camisa.setCodigo(codigo);
		camisa.setTamanho(tamanho);
		camisa.setMarca(marca);
		camisa.setPreco(preco);
		camisa.setDescricao(descricao);
		
		try {
			CamisaDAO camisaDAO = new CamisaDAO();
			camisaDAO.adicionarCamisa(camisa);
		} catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
	}
	
	public void atualizarCamisa(int codigo, double preco) {
		Camisa camisa = new Camisa();
		camisa.setCodigo(codigo);
		camisa.setPreco(preco);
		
		try {
			CamisaDAO camisaDAO = new CamisaDAO();
			camisaDAO.atualizarCamisa(camisa);
		} catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
	}
	
	public void deletarCamisa(int codigo) {
		try {
			CamisaDAO camisaDAO = new CamisaDAO();
			camisaDAO.deletarCamisa(codigo);
		} catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
	}
	
	public void listarCamisas() {
		CamisaDAO camisaDAO = null;
        try {
        	camisaDAO = new CamisaDAO();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        List<Camisa> camisas = camisaDAO.getCamisas();
   
        System.out.println();
        System.out.print("-------------------------------------------");
        for(Camisa camisa: camisas) {
            System.out.print("\nCodigo: " + camisa.getCodigo());
            System.out.print("\nMarca: " + camisa.getMarca());
            System.out.print("\nPreco: " + camisa.getPreco());
            System.out.print("\nDescricao: " + camisa.getDescricao());
            System.out.print("\n-------------------------------------------");
        }
        System.out.println();
	}
	
	// VENDA
	public void inserirVenda(int id, int id_vendedor, int codigo_camisa, double valor, int quantidade) {
		Venda venda = new Venda();
		venda.setId(id);
		venda.setId_vendedor(id_vendedor);
		venda.setCodigo_camisa(codigo_camisa);
		venda.setValor(valor);
		venda.setQuantidade(quantidade);
		
		try {
			VendaDAO vendaDAO = new VendaDAO();
			vendaDAO.cadastrarVenda(venda);
		} catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
	}
	
	public void atualizarVenda(int quantidade, int id) {
		Venda venda = new Venda();
		venda.setQuantidade(quantidade);
		venda.setId(id);
		
		try {
			VendaDAO vendaDAO = new VendaDAO();
			vendaDAO.atualizarVenda(venda);
		} catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
	}
	
	public void deletarVenda(int id) {
		try {
			VendaDAO vendaDAO = new VendaDAO();
			vendaDAO.deletarVenda(id);
		} catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
	}
	
	public void listarVendas() {
		VendaDAO vendaDAO = null;
        try {
        	vendaDAO = new VendaDAO();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        List<Venda> vendas = vendaDAO.getVendas();
   
        System.out.println();
        System.out.print("-------------------------------------------");
        for(Venda venda: vendas) {
            System.out.print("\nID: " + venda.getId());
            System.out.print("\nID do Vendedor: " + venda.getId_vendedor());
            System.out.print("\nCodigo da camisa: " + venda.getCodigo_camisa());
            System.out.print("\nValor: " + venda.getValor());
            System.out.print("\nQuantidade: " + venda.getQuantidade());
            System.out.print("\n-------------------------------------------");
        }
        System.out.println();
	}
	
	// VENDEDOR
	public void inserirVendedor(int id, String nome, String cpf, double salario) {
		Vendedor vendedor = new Vendedor();
		vendedor.setId(id);
		vendedor.setNome(nome);
		vendedor.setCpf(cpf);
		vendedor.setSalario(salario);
		
		try {
			VendedorDAO vendedorDAO = new VendedorDAO();
			vendedorDAO.cadastrarVendedor(vendedor);
		} catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
	}
	
	public void atualizarVendedor(int id, double salario) {
		Vendedor vendedor = new Vendedor();
		vendedor.setId(id);
	    vendedor.setSalario(salario);
		
		try {
			VendedorDAO vendedorDAO = new VendedorDAO();
			vendedorDAO.atualizarVendedor(vendedor);
		} catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
	}
	
	public void deletarVendedor(int id) {
		try {
			VendedorDAO vendedorDAO = new VendedorDAO();
			vendedorDAO.deletarVendedor(id);
		} catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
	}
	
	public void listarVendedores() {
		VendedorDAO vendedorDAO = null;
        try {
        	vendedorDAO = new VendedorDAO();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        List<Vendedor> vendedores = vendedorDAO.getVendedores();
   
        System.out.println();
        System.out.print("-------------------------------------------");
        for(Vendedor vendedor: vendedores) {
            System.out.print("\nId: " + vendedor.getId());
            System.out.print("\nNome: " + vendedor.getNome());
            System.out.print("\nCpf: " + vendedor.getCpf());
            System.out.print("\nSalario: " + vendedor.getSalario());
            System.out.print("\n-------------------------------------------");
        }
        System.out.println();
	}
}
