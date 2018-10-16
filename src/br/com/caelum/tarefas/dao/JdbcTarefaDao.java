package br.com.caelum.tarefas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.caelum.tarefas.modelo.Tarefa;

@Repository // componente Bean que sera criado pelo spring na injecao de dependencia
public class JdbcTarefaDao implements TarefaDao {
	
	private Connection connection;
	
	/* cria a conexao com o banco e seta para o atributo
	 * usado nos exercicios iniciais
	public TarefaDao() throws ClassNotFoundException {
		this.setConnection(new ConnectionFactory().getConnection());
	}*/
	
	@Autowired // indica ao spring que ele precisa resolver e injetar a dependência
	public JdbcTarefaDao(DataSource	dataSource) { // datasource criado em spring-context
		try	{
			this.connection	= dataSource.getConnection(); // busca a conexao 
		} catch (SQLException e){
				throw new RuntimeException(e);
			}
	}
	
	// adiciona tarefa
	public void adiciona(Tarefa tarefa) {
		
		// parametro dataFinalizacao da classe Tarefa nao foi usado
		String sql = "insert into tarefas (descricao, finalizado) values (?, ?)";
		
		try	{
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1,tarefa.getDescricao());
			stmt.setBoolean(2, tarefa.isFinalizado()); // campo nao foi setado no formulario.jsp, seta 0 por padrao no banco
			
			stmt.execute();
			stmt.close();
		} catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	// lista de tarefas
	public List<Tarefa> lista() {
		try{
			List<Tarefa> tarefas = new ArrayList<Tarefa>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from tarefas");
			
			// executa o select e busca todos os contatos
			ResultSet rs = stmt.executeQuery();
		
			while(rs.next()){
				Tarefa tarefa = new Tarefa();
				tarefa.setId(rs.getLong("id")); // seta os campos conforme colunas no banco
				tarefa.setDescricao(rs.getString("descricao"));
				tarefa.setFinalizado(rs.getBoolean("finalizado"));
				
				tarefas.add(tarefa);
			}
			rs.close();
			stmt.close();
			return	tarefas; // retorna lista de tarefas
		} catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	// remove tarefa
	public void remove(Tarefa tarefa) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from tarefas where id=?");
			stmt.setLong(1, tarefa.getId()); // remove pelo id
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	// busca tarefa por id
	public Tarefa buscaPorId(Long id) {
		String sql = "select * from tarefas where id=" + id;
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			rs.first();
			
			Tarefa tarefa = new Tarefa();
			tarefa.setId(rs.getLong("id"));
			tarefa.setDescricao(rs.getString("descricao"));
			tarefa.setFinalizado(rs.getBoolean("finalizado"));
			
			rs.close();
			stmt.close();
			
			return tarefa;

		} catch (Exception e) {

		}
		return null;
		
	}
	
	// altera tarefa
	public void altera(Tarefa tarefa) {
		String sql = "update tarefas set descricao=?, finalizado=? where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, tarefa.getDescricao());
			stmt.setBoolean(2, tarefa.isFinalizado());
			stmt.setLong(3, tarefa.getId());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	@Override
	public void finaliza(Long id) {
		// TODO Auto-generated method stub
		
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

}
