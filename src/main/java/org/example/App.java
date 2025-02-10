package org.example;

import org.example.DAO.YAMLfilesHashMap;
import org.example.config.Configuration;
import org.example.services.CommandGenerator;
import org.example.services.ReportGenerator;

import java.io.IOException;

/**
 * Application to compare consecutive OpenAPI YAML files and generate diffs.
 */
public class App {
    public static void main(String[] args) throws IOException {
        String OPENAPI_DOC_OLD;
        String OPENAPI_DOC_NEW;

        Configuration configuration = new Configuration();

        ReportGenerator reportGenerator = new ReportGenerator();
        YAMLfilesHashMap getOldestAndNewestYAML = new YAMLfilesHashMap();
        OPENAPI_DOC_OLD = getOldestAndNewestYAML.getOldestAndNewestYAML().get("OPENAPI_DOC_OLD");
        OPENAPI_DOC_NEW = getOldestAndNewestYAML.getOldestAndNewestYAML().get("OPENAPI_DOC_NEW");

        CommandGenerator commandGenerator = new CommandGenerator();
        commandGenerator.processAllFiles();
//        reportGenerator.generateReport(OPENAPI_DOC_OLD,OPENAPI_DOC_NEW,configuration,"diff_old_and_new.html");
//        cleanYamlFile(OPENAPI_DOC_OLD);
//        cleanYamlFile(OPENAPI_DOC_NEW);

//        // Compare the cleaned YAML files
//        ChangedOpenApi diff = OpenApiCompare.fromLocations(OPENAPI_DOC_OLD, OPENAPI_DOC_NEW);
//        System.out.println(diff);
//        String html = new HtmlRender("Changelog",
//                "http://deepoove.com/swagger-diff/stylesheets/demo.css")
//                .render(diff);
//
//
////              save the file in the API_DOCS_DIFF_OUTPUT_FOLDER
//            FileWriter fw = new FileWriter(
//                    configuration.getAPI_DOCS_DIFF_OUTPUT_FOLDER()+"\\"+"differnce.html");
//            fw.write(html);
//            fw.close();



    }


}
