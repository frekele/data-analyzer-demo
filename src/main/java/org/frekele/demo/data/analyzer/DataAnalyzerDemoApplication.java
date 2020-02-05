package org.frekele.demo.data.analyzer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
@SpringBootApplication
public class DataAnalyzerDemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(DataAnalyzerDemoApplication.class, args);
        if (applicationContext.isRunning()) {
            showAppVersionInfo();
        }
    }

    static void showAppVersionInfo() {
        log.info("");
        log.info("########################################################################################");
        log.info("## |  java.version  |   " + System.getProperty("java.version"));
        log.info("## |  java.home     |   " + System.getProperty("java.home"));
        log.info("## |  java.vendor   |   " + System.getProperty("java.vendor"));
        log.info("## |  os.arch       |   " + System.getProperty("os.arch"));
        log.info("## |  os.name       |   " + System.getProperty("os.name"));
        log.info("## |  os.version    |   " + System.getProperty("os.version"));
        log.info("## |  spring-boot   |   " + SpringBootApplication.class.getPackage().getImplementationVersion());
        log.info("########################################################################################");
        log.info("");
    }

}
