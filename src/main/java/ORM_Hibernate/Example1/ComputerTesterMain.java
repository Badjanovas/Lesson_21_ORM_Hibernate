package ORM_Hibernate.Example1;

import ORM_Hibernate.Example1.model.Computer;
import ORM_Hibernate.Example1.model.Person;
import ORM_Hibernate.Example1.repository.ComputerRepository;
import ORM_Hibernate.Example1.service.ComputerHibernateService;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ComputerTesterMain {
    public static void main(String[] args) {

        Computer asus = new Computer("Asus", "X55LB", 512, 350);
        Computer dell = new Computer("Dell", "Bell", 1024, 670);
        Computer hp = new Computer("HP", "z350", 205, 30);

        ComputerRepository computerRepository = new ComputerRepository();

        Person andrius = new Person();
        andrius.setName("Andrius");

        asus.setPerson(andrius);
        hp.setPerson(andrius);
        dell.setPerson(andrius);

        List<Computer> andriusComputers = new ArrayList<>();
        andriusComputers.add(asus);
        andriusComputers.add(hp);
        andriusComputers.add(dell);

        andrius.setComputers(andriusComputers);

        Session session = ComputerHibernateService.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(andrius);
        transaction.commit();
        session.close();
    }
}
