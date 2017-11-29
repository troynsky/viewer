package ru.cbr.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.cbr.model.UER;

public interface UERRepository extends CrudRepository<UER, Long> {
    @Query("SELECT u FROM UER u WHERE u.uer = ?1")
    UER findOneBy(String uer);

    @Query("SELECT u FROM UER u WHERE u.vkey = ?1")
    UER findOneByVkey(String vkey);
}
