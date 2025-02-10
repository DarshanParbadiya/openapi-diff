package org.example.services;

import org.example.DAO.YAMLfilesHashMap;
import org.example.config.Configuration;

import java.util.ArrayList;
import java.util.Map;

/**
 * Application to compare consecutive OpenAPI YAML files and generate diffs.
 */
public class CommandGenerator {
    public  void processAllFiles() {
        String OPENAPI_DOC_OLD;

        String OPENAPI_DOC_NEW;

        Configuration configuration = new Configuration();

        ReportGenerator reportGenerator = new ReportGenerator();


        YAMLfilesHashMap yamlfilesHashMap = new YAMLfilesHashMap();
        Map<String, String> YAMLFiles = yamlfilesHashMap.getFilePahts();
        ArrayList<String> YAMLFilesArray = new ArrayList<String>();
        for (Map.Entry<String, String> entry : YAMLFiles.entrySet()) {
            YAMLFilesArray.add(entry.getKey());
        }
        for (int i=0 ; i < YAMLFilesArray.toArray().length - 1;i++){
            if(configuration.getAPI_DOCS_FOLDER() == ""){
                OPENAPI_DOC_OLD = YAMLFilesArray.get(i);
                OPENAPI_DOC_NEW = YAMLFilesArray.get(i+1);
            }
            else{
                OPENAPI_DOC_OLD = configuration.getAPI_DOCS_FOLDER()+YAMLFilesArray.get(i);
                OPENAPI_DOC_NEW = configuration.getAPI_DOCS_FOLDER()+YAMLFilesArray.get(i+1);
            }
//            System.out.println(YAMLFilesArray.get(i));
//            System.out.println(YAMLFilesArray.get(i+1));
            String outputFileName = "Diff-" +YAMLFilesArray.get(i) + "-" + YAMLFilesArray.get(i + 1) + ".html";
            try{

//            reportGenerator.generateReport(OPENAPI_DOC_OLD,OPENAPI_DOC_NEW,configuration,outputFileName);
                reportGenerator.generateCommands(OPENAPI_DOC_OLD,OPENAPI_DOC_NEW,configuration,outputFileName);
            }
            catch (Exception e){
                System.err.println("Error processing files: " + e.getMessage());
            }
//            break;

        }
    }


}
