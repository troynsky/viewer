package ru.cbr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class FillDBTask {

    @Autowired
    private DBFService dbfService;

    @Value("${runTask}")
    private Boolean updateDatabase;

    //we have 3 event - it's just stub - bad practice - use scheduler
    private static volatile Boolean status = false;

    @EventListener(ContextRefreshedEvent.class)
    public void contextRefreshedEvent() {
        if (!status) {
            if (updateDatabase) {
                dbfService.fillDB();
                status = true;
            }
        }

    }
}
