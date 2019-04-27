package maciejkrawiecki.dao;

import maciejkrawiecki.entity.Member;

import java.util.List;

public interface MemberDao {

    void save(Member run);

    void delete(Long id);

    Member getBy(Long id);

    List<Member> getAll();
}
