package br.com.caelum.tarefas.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GeraTabelas {
	
	public static void main(String[] args) {
		
		// cria tabelas conforme entidades mapeadas em persistence.xml
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas"); // unidade persistencia mapeada em persistence.xml
		
		factory.close();
		
		
	}

}

