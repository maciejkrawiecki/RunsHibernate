package maciejkrawiecki.dao;

import maciejkrawiecki.entity.Member;

import java.util.List;
import java.util.Optional;

public interface MemberDao {

    Long save(Member run);

    void delete(Long id);

    Optional<Member> getBy(Long id);

    List<Member> getAll();
}
