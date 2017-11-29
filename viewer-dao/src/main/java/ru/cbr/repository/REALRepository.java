package ru.cbr.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.cbr.model.REAL;

public interface REALRepository extends CrudRepository<REAL, Long> {
    @Query("SELECT r FROM REAL r WHERE r.real = ?1")
    REAL findOneBy(String real);

    @Query("SELECT r FROM REAL r WHERE r.vkey = ?1")
    REAL findOneByVkey(String vkey);
}
