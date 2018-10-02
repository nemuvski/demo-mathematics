package org.demo.mathematics.controller;

import org.demo.mathematics.exception.MathematicsException;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CalculateOutlierController extends AbstractCalculateController {
    public void run() throws MathematicsException {
        List<Double> list = numListRepositoryImp.findAll();
        logger.info("[OUT]: {}", mathematicsService.outlier(list));
    }
}
