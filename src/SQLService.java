import java.sql.SQLException;
import java.util.List;

import DAO.CamisaDAO;
import model.Camisa;

public class SQLService {

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
}
