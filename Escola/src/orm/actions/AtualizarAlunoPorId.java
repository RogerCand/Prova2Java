package orm.actions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import orm.model.Aluno;
import orm.model.Tarefa;

public class AtualizarAlunoPorId {
	public static void main(String[] args) {
		//1.
		Aluno tarefa = new Aluno();
		tarefa.setId(2L);
		tarefa.setDescricao("Estudar Java até o fim!!!");
		tarefa.setFinalizada(false);
		tarefa.setDataFinalizacao(null);
		
		//2.
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		EntityManager manager = factory.createEntityManager();
		
		//3. operar com "merge"
		manager.getTransaction().begin();
		manager.merge(tarefa);
		manager.getTransaction().commit();
		
		System.out.println("Tarefa atualizada, ID: "+tarefa.getId());
		
		manager.close();
		factory.close();
		
		
	}

}
