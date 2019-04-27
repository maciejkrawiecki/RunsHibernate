package maciejkrawiecki.daoimpl;

import maciejkrawiecki.dao.MemberDao;
import maciejkrawiecki.entity.Member;
import org.junit.Test;

import javax.persistence.NoResultException;

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

    }
}