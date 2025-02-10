package org.example;

import org.example.config.Configuration;
import org.example.services.CommandGenerator;
import org.example.services.ReportGeneratorBulk;

import java.io.IOException;

/**
 * Application to compare consecutive OpenAPI YAML files and generate diffs.
 */
public class App {
    public static void main(String[] args) throws IOException {

        Configuration configuration = new Configuration();
        ReportGeneratorBulk reportGeneratorBulk = new ReportGeneratorBulk();

        CommandGenerator commandGenerator = new CommandGenerator();
//        uncomment the below function call if you want to generate the commands to get diff files in txt format.
//        commandGenerator.processAllFiles();
        reportGeneratorBulk.generateHTMLReport();
    }
}
