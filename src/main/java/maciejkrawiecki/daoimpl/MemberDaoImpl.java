package maciejkrawiecki.daoimpl;

import maciejkrawiecki.dao.MemberDao;
import maciejkrawiecki.entity.Member;
import maciejkrawiecki.utils.HibernateUtils;
import org.hibernate.Session;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

public class MemberDaoImpl implements MemberDao {

    @Override
    public Long save(Member saveMember) {
        Session session = HibernateUtils.getSession();
        Long memberId = (Long) session.save(saveMember);
        session.getTransaction().commit();
        session.close();

        return memberId;
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
    public Optional<Member> getBy(Long id) {

        Session session = HibernateUtils.getSession();
        Optional<Member> optionalMember;
        Member member;
        try {
            member = (Member) session.createQuery("from Member where id=:id")
                    .setParameter("id", id)
                    .getSingleResult();
            optionalMember = Optional.of(member);
            session.getTransaction().commit();
        } catch (NoResultException e) {
            optionalMember = Optional.empty();
        } finally {
            session.close();
        }

        return optionalMember;
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
