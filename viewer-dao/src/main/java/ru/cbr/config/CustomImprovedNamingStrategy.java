package ru.cbr.config;

import org.hibernate.cfg.ImprovedNamingStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class CustomImprovedNamingStrategy extends ImprovedNamingStrategy {
    static final Logger log = LoggerFactory.getLogger(CustomImprovedNamingStrategy.class);
    private Properties keywordColumns = new Properties();

    public String foreignKeyColumnName(String propertyName, String propertyEntityName, String propertyTableName, String referencedColumnName) {
        return (propertyName != null ? this.columnName(propertyName) : "") + '_' + referencedColumnName;
    }

    public CustomImprovedNamingStrategy() {
        try {
            InputStream keywordsRes = CustomImprovedNamingStrategy.class.getResourceAsStream("keywords.properties");
            if (keywordsRes != null) {
                this.keywordColumns.load(keywordsRes);
            }
        } catch (IOException var2) {
            log.warn("", var2);
        }

    }

    public String propertyToColumnName(String propertyName) {
        String s = super.propertyToColumnName(propertyName);
        String s1 = this.keywordColumns.getProperty(s);
        return s1 == null ? s : s1;
    }
}