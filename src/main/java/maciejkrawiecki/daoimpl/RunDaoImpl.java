package maciejkrawiecki.daoimpl;

import maciejkrawiecki.dao.RunDao;
import maciejkrawiecki.entity.Run;
import maciejkrawiecki.utils.HibernateUtils;
import org.hibernate.Session;

import java.util.List;

public class RunDaoImpl implements RunDao {


    @Override
    public void save(Run run) {

        Session session = HibernateUtils.getSession();
        session.saveOrUpdate(run);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Long id) {

        Session session = HibernateUtils.getSession();

        session.createQuery("delete Run where id=:id")
                .setParameter("id", id)
                .executeUpdate();

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Run getBy(Long id) {
        Session session = HibernateUtils.getSession();

        Run run = (Run) session.createQuery("from Run where id=:id")
                .setParameter("id", id)
                .getSingleResult();

        session.getTransaction().commit();
        session.close();

        return run;
    }

    @Override
    public List<Run> getAll() {

        Session session = HibernateUtils.getSession();

        List list = session.createQuery("from Run").list();

        session.getTransaction().commit();

        session.close();

        return list;
    }
}
