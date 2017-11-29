package ru.cbr.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.cbr.model.TNP;

public interface TNPRepository extends CrudRepository<TNP, Long> {
    @Query("SELECT t FROM TNP t WHERE t.tnp = ?1")
    TNP findOneBy(String tnp);

    @Query("SELECT t FROM TNP t WHERE t.vkey = ?1")
    TNP findOneByVkey(String vkey);
}
