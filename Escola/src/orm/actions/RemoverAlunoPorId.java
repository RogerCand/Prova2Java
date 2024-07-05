package orm.actions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import orm.model.Aluno;

public class RemoverAlunoPorId {
	public static void main(String[] args) {
		// 1. Conectar ao operador do ORM/JPA
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("aluno");
		EntityManager manager = factory.createEntityManager();
		
		//2.Buscar o objeto a ser excluído
		Aluno aluno = new Aluno();
		aluno.setId(1L);
		aluno = manager.find(Aluno.class, aluno.getId());
		//ou tarefa = manager.find(Tarefa.class, 1L);
		
		//3. operar com "remove"
		manager.getTransaction().begin();
		manager.remove(aluno);
		manager.getTransaction().commit();
		
		System.out.println("Aluno Excluido!!!");
		
		manager.close();
		factory.close();
		
	}

}
