package ru.cbr.config;

import com.github.fluent.hibernate.cfg.strategy.hibernate5.adapter.Hibernate4To5NamingStrategyAdapter;
import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.ImplicitPrimaryKeyJoinColumnNameSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hibernate4BasedNamingStrategy extends Hibernate4To5NamingStrategyAdapter {
    static final Logger log = LoggerFactory.getLogger(Hibernate4BasedNamingStrategy.class);

    public Hibernate4BasedNamingStrategy() {
        super(new CustomImprovedNamingStrategy());
    }

    public Identifier determinePrimaryKeyJoinColumnName(ImplicitPrimaryKeyJoinColumnNameSource source) {
        return source.getReferencedPrimaryKeyColumnName();
    }
}