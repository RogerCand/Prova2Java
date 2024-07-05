package orm.actions;

import orm.model.Aluno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;

public class BuscarUmaAlunoPorId {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite uma letra!! : ");
        String letra = sc.nextLine();

        List<Aluno> listaAlunos = BuscarUmaAlunoPorId.buscarPorLetra(letra);

        if (!listaAlunos.isEmpty()) {
            System.out.println("");
            for (Aluno aluno : listaAlunos) {
                System.out.println(aluno.getNome());
                System.out.println(aluno.getEmail());
                System.out.println(aluno.getCpf());
                System.out.println(aluno.getDataNascimento());
                System.out.println(aluno.getNaturalidade());
                System.out.println(aluno.getEndereco());
                System.out.println("");
            }
        } else {
            System.out.println("Aluno não existente!!: " + letra);
        }
    }

    public static List<Aluno> buscarPorLetra(String letra) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("aluno");
        EntityManager manager = factory.createEntityManager();

        Query query = manager.createQuery("select a from Aluno as a where a.nome like :parametro");
        query.setParameter("parametro", letra + "%");

        @SuppressWarnings("unchecked")
        List<Aluno> alunos = query.getResultList();

        manager.close();
        factory.close();

        return alunos;
    }


}