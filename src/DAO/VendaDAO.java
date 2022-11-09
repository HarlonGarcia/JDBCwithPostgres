package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import connectjdbc.ConnectJDBC;
import model.Venda;

public class VendaDAO {
	private Connection con;
	
	public VendaDAO() throws SQLException, ClassNotFoundException {
		con = ConnectJDBC.connectToDB();
	}
	
	public void cadastrarVenda(Venda venda) {
		String sql = "INSERT INTO tb_venda(id, id_vend, codigo_camisa, valor, quantidade) VALUES(?,?,?,?,?)";
		
		try {
            PreparedStatement preparador = con.prepareStatement(sql);
            preparador.setInt(1, venda.getId());
            preparador.setInt(2, venda.getId_vendedor());
            preparador.setInt(3, venda.getCodigo_camisa());
            preparador.setDouble(4, venda.getValor());
            preparador.setDouble(5, venda.getQuantidade());
            preparador.execute();
            preparador.close();
            System.out.println("Venda cadastrada com sucesso!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	}
	
	public void atualizarVenda(Venda venda) {
        String sql = "UPDATE tb_venda SET quantidade = ? WHERE id = ?";

        try {
            PreparedStatement preparador = con.prepareStatement(sql);
            preparador.setInt(1, venda.getQuantidade());
            preparador.setInt(2, venda.getId());
            preparador.execute();
            preparador.close();

            System.out.println("Venda atualizada com sucesso!");
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
	
	public void deletarVenda(int id) {
        String sql = "DELETE FROM tb_venda WHERE id = ?";
        try {
            PreparedStatement preparador = con.prepareStatement(sql);
            preparador.setInt(1, id);

            preparador.execute();
            preparador.close();
            System.out.println("Venda deletada com sucesso!");
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
	
    public List<Venda> getVendas(){
        String sql = "SELECT * FROM tb_venda";
        List<Venda> vendas = new ArrayList<Venda>();
        
        try {
            PreparedStatement preaparador = con.prepareStatement(sql);
            ResultSet resultados = preaparador.executeQuery();
            while (resultados.next()) {
                Venda venda = new Venda();
                venda.setId(resultados.getInt("id"));
                venda.setId_vendedor(resultados.getInt("id_vend"));
                venda.setCodigo_camisa(resultados.getInt("codigo_camisa"));
                venda.setValor(resultados.getInt("valor"));
                venda.setQuantidade(resultados.getInt("quantidade"));
                vendas.add(venda);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return vendas;
    }
}
