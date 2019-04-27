package maciejkrawiecki.daoimpl;

import maciejkrawiecki.dao.MemberDao;
import maciejkrawiecki.entity.Member;
import maciejkrawiecki.utils.HibernateUtils;
import org.hibernate.Session;

import java.util.List;

public class MemberDaoImpl implements MemberDao {

    @Override
    public void save(Member run) {

        Session session = HibernateUtils.getSession();
        session.saveOrUpdate(run);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Long id) {

        Session session = HibernateUtils.getSession();

        session.createQuery("delete Member where id=:id")
                .setParameter("id", id)
                .executeUpdate();

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Member getBy(Long id) {

        Session session = HibernateUtils.getSession();


        Member member = (Member) session.createQuery("from Member where id=:id")
                .setParameter("id", id)
                .getSingleResult();

        session.getTransaction().commit();
        session.close();

        return member;
    }

    @Override
    public List<Member> getAll() {

        Session session = HibernateUtils.getSession();

        List members = session.createQuery("from Member").list();

        session.getTransaction().commit();
        session.close();

        return members;
    }
}
