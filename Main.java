import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    private static SessionFactory sessionFactory = null;

    public static void main(String args[]){
        Supplier supplier1 = new Supplier("Coffee Deliver", "Krakowska", "Kraków");
        Supplier supplier2 = new Supplier("Czarka", "Zielona", "Warszawa");
        Product product1 = new Product("Kawa", 15);
        Product product2 = new Product("Herbata zielona", 10);
        Product product3 = new Product("Herbata czarna", 20);
        Category categoryWarm = new Category("napoje ciepłe");

        supplier1.addProduct(product1);
        supplier2.addProduct(product2);
        supplier2.addProduct(product3);

        product1.setCategory(categoryWarm);
        product2.setCategory(categoryWarm);
        product3.setCategory(categoryWarm);
        sessionFactory = getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(supplier1);
        session.save(supplier2);
        session.save(product1);
        session.save(product2);
        session.save(product3);
        session.save(categoryWarm);

        transaction.commit();
        session.close();
    }

    private static SessionFactory getSessionFactory(){
        if(sessionFactory == null){
            Configuration config = new Configuration();
            sessionFactory = config.configure().buildSessionFactory();
        }
        return sessionFactory;
    }
}
