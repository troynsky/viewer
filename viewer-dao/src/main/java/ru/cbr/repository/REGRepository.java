package ru.cbr.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.cbr.model.REG;

public interface REGRepository extends CrudRepository<REG, Long> {
    @Query("SELECT r FROM REG r WHERE r.rgn = ?1")
    REG findOneBy(String rgn);

    @Query("SELECT r FROM REG r WHERE r.vkey = ?1")
    REG findOneByVkey(String vkey);
}
