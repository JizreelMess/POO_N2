package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class BancoDados {

	private Connection con = null;
	private Statement stm  = null;
	private ResultSet result = null;
	Produto produto = new Produto();
        int numero;
	public void conecta() {
		String servidor = "jdbc:mysql://localhost:3306/Loja_POO";
		String usuario = "root";
		String senha = "";
		String driver = "com.mysql.jdbc.Driver";
		try {
			Class.forName(driver);
			this.con = DriverManager.getConnection(servidor, usuario, senha);
			this.stm = this.con.createStatement();
		} catch (Exception e) {
			System.out.println("erro na conex�o : " + e.getMessage());
		}
	}
	public boolean estaConecatdo() {
		if (this.con != null) {
			return true;
		}
		else {
			return false;
		}
	}
	public void listar() {
		try {
			String minhaQuery = "SELECT * FROM produtos ORDER BY nomeProduto";
			this.result = this.stm.executeQuery(minhaQuery);
			
			while (this.result.next()) {
				System.out.println("ID: "+this.result.getString("idProduto") + " # Nome: "+this.result.getString("nomeProduto") + " # Preço:  "+this.result.getString("valorUnitario") + " #");
			}
		} catch(Exception e) {
			System.out.println("Erro na lista: "+ e.getMessage());
		}
	}
	public void inserir(String nome) {
		try {
			String query = "INSERT INTO produtos (nome) VALUES('"+ nome +"');";
			this.stm.executeUpdate(query);
			System.out.println("cliente " +nome + "Incuido com SUCESSO" );
			
		} catch(Exception e) {
			System.out.println("Erro na Inclusao: "+ e.getMessage());
		}
	}
	public void editar(int id, int qtdEstoque) {
		try {
			String query = "UPDATE produtos SET qtdEstoque ='"+ qtdEstoque +"'  WHERE idProduto = " + id + ";";
			this.stm.executeUpdate(query);
			System.out.println("ID: "+ id + " alterado com sucesso" );
		} catch(Exception e) {
			System.out.println("Erro na Alteracao: "+ e.getMessage());
		}
	}
    public void excluir(String id) {
    	try {
			String query = "DELETE FROM cliente WHERE id = " + id + ";";
			this.stm.executeUpdate(query);
			System.out.println("ID: "+ id + "EXCLUIDO COM SUCESSO");
			
		} catch(Exception e) {
			System.out.println("Erro na Exclusao: "+ e.getMessage());
		}
	}

}
