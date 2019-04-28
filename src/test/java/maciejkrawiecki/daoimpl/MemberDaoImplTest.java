package maciejkrawiecki.daoimpl;

import maciejkrawiecki.dao.MemberDao;
import maciejkrawiecki.entity.Member;
import org.junit.Test;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class MemberDaoImplTest {


    @Test
    public void save() {

        // given

        MemberDao memberDao = new MemberDaoImpl();

        Member member = new Member();

        member.setStartNumber(1);
        member.setLastName("lastname");
        member.setName("name");

        // when

        memberDao.save(member);

        Member retrievedMember = memberDao.getBy(1L);

        // then

        assertEquals("name", retrievedMember.getName());
        assertEquals("lastname", retrievedMember.getLastName());
    }

    @Test
    public void delete() {

        // given

        MemberDao memberDao = new MemberDaoImpl();

        Member member = new Member();

        member.setStartNumber(1);
        member.setLastName("lastname");
        member.setName("name");
        memberDao.save(member);

        // when

        memberDao.delete(1L);

        // then

        assertThrows(NoResultException.class, () -> memberDao.getBy(1L));
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

        memberDao.save(member);

        Member retrievedMember = memberDao.getBy(1L);

        // then

        assertEquals("name", retrievedMember.getName());
        assertEquals("lastname", retrievedMember.getLastName());

    }

    @Test
    public void getAll() {

        // given

        MemberDao memberDao = new MemberDaoImpl();

        Member member1 = new Member();
        Member member2 = new Member();

        member1.setStartNumber(1);
        member1.setLastName("lastname1");
        member1.setName("name1");

        member2.setStartNumber(2);
        member2.setLastName("lastname2");
        member2.setName("name2");

        memberDao.save(member1);
        memberDao.save(member2);

        List<Member> members = new ArrayList<>();
        Member firstMember = new Member();
        Member secondMember = new Member();

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