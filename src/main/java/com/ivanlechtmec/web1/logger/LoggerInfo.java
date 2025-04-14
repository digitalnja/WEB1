package com.ivanlechtmec.web1.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class LoggerInfo {

    private final Logger logger = LoggerFactory.getLogger(LoggerInfo.class);
    @Transactional(propagation = Propagation.MANDATORY)
    public void info(String mes){
        logger.info(mes);
    }



}
