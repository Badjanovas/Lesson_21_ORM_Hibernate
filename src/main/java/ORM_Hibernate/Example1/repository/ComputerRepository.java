package ORM_Hibernate.Example1.repository;

import ORM_Hibernate.Example1.model.Computer;
import ORM_Hibernate.Example1.service.ComputerHibernateService;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ComputerRepository {

    public void save(Computer computer) {
        Session session = ComputerHibernateService.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(computer);
        System.out.println("Object was saved successfully! " + computer);
        transaction.commit();
        session.close();
    }

    public void saveAll(List<Computer> computers){
        Session session = ComputerHibernateService.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        computers.forEach(session::saveOrUpdate); // tas pats kas forEach loopas
        /*
        * for (Computer computer : computers){
        *   session.saveOrUpdate(computer);
        * }
        *
        * lamda expresion:
        * computers.forEach(computer -> session.saveOrUpdate(computer));
        *
          */
        System.out.println("Computer were saved successfully!");
        transaction.commit();
        session.close();
    }

    public void delete(Computer computer) {
        Session session = ComputerHibernateService.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(computer);
        System.out.println("Computer was deleted!");
        transaction.commit();
        session.close();
    }
}
