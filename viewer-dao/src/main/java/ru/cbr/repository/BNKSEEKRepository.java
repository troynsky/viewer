package ru.cbr.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.cbr.model.BNKSEEK;

public interface BNKSEEKRepository extends CrudRepository<BNKSEEK, Long>, BNKSEEKRepositoryCustom {

    @Query("SELECT b FROM BNKSEEK b WHERE b.vkey = ?1")
    BNKSEEK findOneBy(String vkey);

}
