package org.demo.mathematics.controller;

import org.demo.mathematics.exception.MathematicsException;
import org.demo.mathematics.repository.NumListRepositoryImp;
import org.demo.mathematics.service.MathematicsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

abstract class AbstractCalculateController {
    static final Logger logger = LoggerFactory.getLogger(AbstractCalculateController.class);

    @Autowired
    MathematicsService mathematicsService;
    @Autowired
    NumListRepositoryImp numListRepositoryImp;

    public abstract void run() throws MathematicsException;
}
