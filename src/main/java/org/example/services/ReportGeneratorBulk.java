package org.example.services;

import com.github.elibracha.OpenApiCompare;
import com.github.elibracha.model.ChangedOpenApi;
import com.github.elibracha.output.HtmlRender;
import org.example.DAO.YAMLfilesHashMap;
import org.example.config.Configuration;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Map;

/**
 * Application to compare consecutive OpenAPI YAML files and generate diffs.
 */
public class ReportGeneratorBulk {

    public static void main(String[] args){
        ReportGeneratorBulk reportGeneratorBulk = new ReportGeneratorBulk();
        reportGeneratorBulk.generateHTMLReport();
    }

    public void generateHTMLReport() {
        Configuration config = new Configuration();
        String html = "";
        String API_DOCS_FOLDER = config.getAPI_DOCS_FOLDER();
        String API_DOCS_DIFF_OUTPUT_FOLDER = config.getAPI_DOCS_DIFF_OUTPUT_FOLDER();
        YAMLfilesHashMap filePath = new YAMLfilesHashMap();
        Map<String, String> YAMLFiles = filePath.getFilePahts();
        String[] YAMLFilesArray = YAMLFiles.keySet().toArray(new String[0]);

        System.out.println("Files to process: " + Arrays.toString(YAMLFilesArray));

        for (int i = 0; i < YAMLFilesArray.length - 1; i++) {
            String file1Path = API_DOCS_FOLDER  + YAMLFilesArray[i];
            String file2Path = API_DOCS_FOLDER + YAMLFilesArray[i + 1];

            try {
                cleanYamlFile(file1Path);
                cleanYamlFile(file2Path);

                // Compare the cleaned YAML files
                ChangedOpenApi diff = OpenApiCompare.fromLocations(file1Path, file2Path);

                if (diff != null && diff.isDifferent()) {

                    String outputFileName = "Diff-" + YAMLFilesArray[i + 1] + ".html";
                    String outputFilePath = API_DOCS_DIFF_OUTPUT_FOLDER + outputFileName;
                try {

                     html = new HtmlRender("Changelog", "http://deepoove.com/swagger-diff/stylesheets/demo.css").render(diff);
                }
                catch (Exception e){
                    System.err.println("Error processing files: " + e.getMessage());
                }

                    try (FileWriter fw = new FileWriter(outputFilePath)) {
                        fw.write(html);
                        System.out.println("Diff file generated: " + outputFilePath);
                    }
                } else {
                    System.out.println("No significant differences between " + YAMLFilesArray[i] + " and " + YAMLFilesArray[i + 1]);
                }

            } catch (IOException e) {
                System.err.println("Error processing files: " + e.getMessage());
            }
        }

        System.out.println("Comparison complete.");
    }

    /**
     * Cleans a YAML file by removing special characters outside the printable ASCII range.
     *
     * @param filePath Path to the YAML file.
     * @throws IOException if file reading or writing fails.
     */
    public static void cleanYamlFile(String filePath) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(filePath)), StandardCharsets.UTF_8);

        // Remove special characters outside normal printable ASCII range
        String cleanedContent = content.replaceAll("[^\\x20-\\x7E\\n\\r]", "");

        Files.write(Paths.get(filePath), cleanedContent.getBytes(StandardCharsets.UTF_8), StandardOpenOption.TRUNCATE_EXISTING);
        System.out.println("Cleaned YAML file: " + filePath);
    }
}
