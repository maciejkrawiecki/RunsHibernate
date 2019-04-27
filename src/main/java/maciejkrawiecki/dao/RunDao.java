package maciejkrawiecki.dao;

import maciejkrawiecki.entity.Run;

import java.util.List;

public interface RunDao {

    void save(Run run);

    void delete(Long id);

    Run getBy(Long id);

    List<Run> getAll();
}
