package org.demo.mathematics;

import org.demo.mathematics.controller.*;
import org.demo.mathematics.exception.MathematicsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {
    static final Logger logger = LoggerFactory.getLogger(Application.class);

    @Autowired
    private CalculateSumController calculateSumController;
    @Autowired
    private CalculateMeanController calculateMeanController;
    @Autowired
    private CalculateStdController calculateStdController;
    @Autowired
    private CalculateOutlierController calculateOutlierController;

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.setLogStartupInfo(false);
        app.run(args);
    }

    @Override
    public void run(String... args) {
        try {
            calculateSumController.run();
            calculateMeanController.run();
            calculateStdController.run();
            calculateOutlierController.run();
        } catch(MathematicsException e) {
            logger.warn(e.getMessage());
        }
    }
}
