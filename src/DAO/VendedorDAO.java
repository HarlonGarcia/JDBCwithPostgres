package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import connectjdbc.ConnectJDBC;
import model.Venda;
import model.Vendedor;

public class VendedorDAO {
	private Connection con;
	
	public VendedorDAO() throws SQLException, ClassNotFoundException {
		con = ConnectJDBC.connectToDB();
	}
	
	public void cadastrarVendedor(Vendedor vendedor) {
		String sql = "INSERT INTO tb_vendedor(id, nome, cpf, salario) VALUES(?,?,?,?)";
		
		try {
            PreparedStatement preparador = con.prepareStatement(sql);
            preparador.setInt(1, vendedor.getId());
            preparador.setString(2, vendedor.getNome());
            preparador.setString(3, vendedor.getCpf());
            preparador.setDouble(4, vendedor.getSalario());
            preparador.execute();
            preparador.close();
            System.out.println("Vendedor cadastrado com sucesso!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	}
	
	public void atualizarVendedor(Vendedor vendedor) {
        String sql = "UPDATE tb_vendedor SET salario = ? WHERE id = ?";

        try {
            PreparedStatement preparador = con.prepareStatement(sql);
            preparador.setDouble(1, vendedor.getSalario());
            preparador.setInt(2, vendedor.getId());
            preparador.execute();
            preparador.close();

            System.out.println("Vendedor atualizado com sucesso!");
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
	
	public void deletarVendedor(int id) {
        String sql = "DELETE FROM tb_vendedor WHERE id = ?";
        try {
            PreparedStatement preparador = con.prepareStatement(sql);
            preparador.setInt(1, id);
            preparador.execute();
            preparador.close();
            System.out.println("Vendedor deletado com sucesso!");
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
	
	public List<Vendedor> getVendedores(){
        String sql = "SELECT * FROM tb_vendedor";
        List<Vendedor> vendedores = new ArrayList<Vendedor>();
        
        try {
            PreparedStatement preaparador = con.prepareStatement(sql);
            ResultSet resultados = preaparador.executeQuery();
            while (resultados.next()) {
                Vendedor vendedor = new Vendedor();
                vendedor.setId(resultados.getInt("id"));
                vendedor.setNome(resultados.getString("nome"));
                vendedor.setCpf(resultados.getString("cpf"));
                vendedor.setSalario(resultados.getDouble("salario"));
                vendedores.add(vendedor);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return vendedores;
    }
}
