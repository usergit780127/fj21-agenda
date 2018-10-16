package br.com.caelum.tarefas.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// classe usada nos exercicios iniciais
// substituida pelo datasource configurado em spring-context.xml
public class ConnectionFactory {
	
	// sera chamado pelo construtor das classes Dao
	public	Connection	getConnection() throws ClassNotFoundException {
		try	{
			Class.forName("com.mysql.jdbc.Driver"); // necessario para projetos web
			return DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/fj21_20180904","root","");
		}catch(SQLException	e){
			throw new RuntimeException(e);
			}
		}
}
