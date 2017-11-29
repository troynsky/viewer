package ru.cbr.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.cbr.model.PZN;

public interface PZNRepository extends CrudRepository<PZN, Long> {
    @Query("SELECT p FROM PZN p WHERE p.pzn = ?1")
    PZN findOneBy(String pzn);

    @Query("SELECT p FROM PZN p WHERE p.vkey = ?1")
    PZN findOneByVkey(String vkey);
}
