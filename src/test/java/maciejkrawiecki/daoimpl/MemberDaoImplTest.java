package maciejkrawiecki.daoimpl;

import maciejkrawiecki.dao.MemberDao;
import maciejkrawiecki.entity.Member;
import maciejkrawiecki.utils.HibernateUtils;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MemberDaoImplTest {

    @Before
    public void clearDatabase() {

        Session session = HibernateUtils.getSession();
        session.createQuery("delete from Member").executeUpdate();
        session.getTransaction().commit();

        session.close();
    }

    @Test
    public void save() {

        // given
        MemberDao memberDao = new MemberDaoImpl();
        Member member = new Member();
        member.setStartNumber(1);
        member.setLastName("lastname");
        member.setName("name");

        // when
        Long savedId = memberDao.save(member);
        Optional<Member> optionalMember = memberDao.getBy(savedId);

        // then
        assertTrue(optionalMember.isPresent());
        assertEquals("name", optionalMember.get().getName());
        assertEquals("lastname", optionalMember.get().getLastName());
    }

    @Test
    public void delete() {

        // given
        MemberDao memberDao = new MemberDaoImpl();
        Member member = new Member();
        member.setStartNumber(1);
        member.setLastName("lastname");
        member.setName("name");
        Long savedId = memberDao.save(member);

        // when
        memberDao.delete(savedId);

        // then
        assertEquals(memberDao.getBy(savedId), Optional.empty());
    }

    @Test
    public void getBy() {

        // given
        MemberDao memberDao = new MemberDaoImpl();
        Member member = new Member();
        member.setStartNumber(1);
        member.setLastName("lastname");
        member.setName("name");

        // when
        Long savedId = memberDao.save(member);
        Optional<Member> optionalMember = memberDao.getBy(savedId);

        // then
        assertTrue(optionalMember.isPresent());
        assertEquals("name", optionalMember.get().getName());
        assertEquals("lastname", optionalMember.get().getLastName());

    }

    @Test
    public void getAll() {

        // given
        MemberDao memberDao = new MemberDaoImpl();

        Member member1 = new Member()
                .setStartNumber(1)
                .setLastName("lastname1")
                .setName("name1");

        Member member2 = new Member()
                .setStartNumber(2)
                .setLastName("lastname2")
                .setName("name2");

        List<Member> members;
        Member firstMember;
        Member secondMember;

        memberDao.save(member1);
        memberDao.save(member2);

        // when
        members = memberDao.getAll();
        firstMember = members.get(0);
        secondMember = members.get(1);

        // then
        assertEquals("lastname1", firstMember.getLastName());
        assertEquals("name1", firstMember.getName());
        assertEquals(1, firstMember.getStartNumber());

        assertEquals("lastname2", secondMember.getLastName());
        assertEquals("name2", secondMember.getName());
        assertEquals(2, secondMember.getStartNumber());
    }
}