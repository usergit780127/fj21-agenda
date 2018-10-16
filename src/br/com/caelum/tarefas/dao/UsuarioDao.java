package br.com.caelum.tarefas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.caelum.tarefas.conexao.ConnectionFactory;
import br.com.caelum.tarefas.modelo.Usuario;

public class UsuarioDao {
	
private Connection connection;
	
	// cria a conexao com o banco e seta para o atributo
	public UsuarioDao() throws ClassNotFoundException {
		this.setConnection(new ConnectionFactory().getConnection());
	}

	// pesquisa se existe o usuario no banco
	public boolean existeUsuario(Usuario usuario) {
		
		String sql = "select * from usuarios where login=? and senha=?"; 
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, usuario.getLogin());
			stmt.setString(2, usuario.getSenha());
			
			ResultSet rs = stmt.executeQuery();
			boolean achou = rs.first();
			
			if(achou != false) {
				return true;
			}else {
				return false;
			}
			
		} catch (Exception e) {

		}
		return false;
		
	}
		
	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	
	
	
	
	
	
	
	

}
