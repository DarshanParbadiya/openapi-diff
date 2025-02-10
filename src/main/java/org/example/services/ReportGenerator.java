package org.example.services;

import com.github.elibracha.OpenApiCompare;
import com.github.elibracha.model.ChangedOpenApi;
import com.github.elibracha.output.HtmlRender;
import org.example.config.Configuration;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Application to compare OpenAPI YAML files with cleaning.
 */
public class ReportGenerator {

    public void generateReport(String OPENAPI_DOC_OLD, String OPENAPI_DOC_NEW, Configuration configuration,String outputFileName) {

        //DOC1 and DOC2 are consectuive files form the hashmap
        try {
            // Clean the YAML files
            cleanYamlFile(OPENAPI_DOC_OLD);
            cleanYamlFile(OPENAPI_DOC_NEW);

            // Compare the cleaned YAML files
            ChangedOpenApi diff = OpenApiCompare.fromLocations(OPENAPI_DOC_OLD, OPENAPI_DOC_NEW);
            System.out.println(diff);
            String html = new HtmlRender("Changelog",
                    "http://deepoove.com/swagger-diff/stylesheets/demo.css")
                    .render(diff);

            try {
//              save the file in the API_DOCS_DIFF_OUTPUT_FOLDER
                FileWriter fw = new FileWriter(
                        configuration.getAPI_DOCS_DIFF_OUTPUT_FOLDER()+"\\"+outputFileName);
                fw.write(html);
                fw.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            System.err.println("Error processing files: " + e.getMessage());
        }
    }

    /**
     * Cleans a YAML file by removing special characters outside the printable ASCII range.
     *
     * @param filePath Path to the YAML file.
     * @throws IOException if file reading or writing fails.
     */
    private static void cleanYamlFile(String filePath) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(filePath)), StandardCharsets.UTF_8);

        // Remove special characters outside normal printable ASCII range
        String cleanedContent = content.replaceAll("[^\\x20-\\x7E\\n\\r]", "");

        Files.write(Paths.get(filePath), cleanedContent.getBytes(StandardCharsets.UTF_8), StandardOpenOption.TRUNCATE_EXISTING);
        System.out.println("Cleaned YAML file: " + filePath);
    }

    public void generateCommands(String OPENAPI_DOC_OLD, String OPENAPI_DOC2_NEW, Configuration configuration, String outputFileName){
        String outputFile = configuration.getAPI_DOCS_DIFF_OUTPUT_FOLDER()+outputFileName+".txt";
//        String command = "npx openapi-diff "+'"'+ "file:/"+OPENAPI_DOC_OLD+ '"'+ " " + '"'+"file:/"+OPENAPI_DOC2_NEW +'"'+" > "+'"'+ outputFile+'"';

        String command = "npx openapi-diff "+'"'+OPENAPI_DOC_OLD+ '"'+ " " + '"'+OPENAPI_DOC2_NEW +'"'+" > "+'"'+ outputFile+'"';
        System.out.println(command);
    }

    public void generateCompleteReport(String OPENAPI_DOC_OLD, String OPENAPI_DOC_NEW, Configuration configuration ,String outputFileName) {
        // Construct the shell command
//        npx swagger-cli validate path/to/api-doc.yaml
        
        String outputFile = configuration.getAPI_DOCS_DIFF_OUTPUT_FOLDER()+"\\"+outputFileName+".txt";
        String command = String.format("npx openapi-diff \"%s\" \"%s\" > \"%s\"",
                OPENAPI_DOC_OLD,
                OPENAPI_DOC_NEW,
                outputFile);
        System.out.println(command);
        try {
            // Run the command using ProcessBuilder
            ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", command);
            processBuilder.redirectErrorStream(true);

            Process process = processBuilder.start();

            // Capture the output
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }

            int exitCode = process.waitFor();
            System.out.println("Process exited with code: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
//            log.error(String.valueOf(e));
        }
    }
}
