package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import connectjdbc.ConnectJDBC;
import model.Camisa;

public class CamisaDAO {
	private Connection con;

	public CamisaDAO() throws SQLException, ClassNotFoundException {
		con = ConnectJDBC.connectToDB();
	}

	public void adicionarCamisa(Camisa camisa) {
		String sql = "INSERT INTO tb_camisa(codigo, tamanho, marca, preco, descricao) VALUES(?,?,?,?,?)";
		try {
			PreparedStatement preaparador = con.prepareStatement(sql);
			preaparador.setInt(1, camisa.getCodigo());
			preaparador.setString(2, camisa.getTamanho());
			preaparador.setString(3, camisa.getMarca());
			preaparador.setDouble(4, camisa.getPreco());
			preaparador.setString(5, camisa.getDescricao());
			preaparador.execute();
			preaparador.close();
			System.out.println("Camisa adicionada com sucesso!");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void atualizarCamisa(Camisa camisa) {
		String sql = "UPDATE tb_camisa SET preco = ? WHERE codigo = ?";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setDouble(1, camisa.getPreco());
			preparador.setInt(2, camisa.getCodigo());
			preparador.execute();
			preparador.close();

			System.out.println("Camisa atualizada com sucesso!");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void deletarCamisa(int codigo) {
		String sql = "DELETE FROM tb_camisa WHERE codigo = ?";
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, codigo);
			preparador.execute();
			preparador.close();
			System.out.println("Camisa deletada com sucesso!");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public List<Camisa> getCamisas() {
		String sql = "SELECT * FROM tb_camisa";
		List<Camisa> camisas = new ArrayList<Camisa>();
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			ResultSet resultados = preparador.executeQuery();
			while (resultados.next()) {
				Camisa camisa = new Camisa();
				camisa.setCodigo(resultados.getInt("codigo"));
				camisa.setMarca(resultados.getString("marca"));
				camisa.setPreco(resultados.getDouble("preco"));
				camisa.setDescricao(resultados.getString("descricao"));
				camisas.add(camisa);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return camisas;
	}
}
