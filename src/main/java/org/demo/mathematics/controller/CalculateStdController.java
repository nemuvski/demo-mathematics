package org.demo.mathematics.controller;

import org.demo.mathematics.exception.MathematicsException;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CalculateStdController extends AbstractCalculateController {
    public void run() throws MathematicsException {
        List<Double> list = numListRepositoryImp.findAll();
        logger.info("[STD]: {}", mathematicsService.std(list, 1));
    }
}
