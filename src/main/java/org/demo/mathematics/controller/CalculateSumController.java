package org.demo.mathematics.controller;

import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CalculateSumController extends AbstractCalculateController {
    public void run() {
        List<Double> list = numListRepositoryImp.findAll();
        logger.info("[SUM]: {}", mathematicsService.sum(list));
    }
}
