package org.example.DAO;

import java.util.Map;
import java.util.TreeMap;

public class YAMLfilesHashMap {
    Map<String, String> sortedMapping = new TreeMap<>();

    public YAMLfilesHashMap(){
        sortedMapping.put("2020-10-29-api-docs.yaml", "api-docs.yaml");
        sortedMapping.put("2020-11-19-api-docs.yaml", "api-docs-Nov192020.yaml.txt");
        sortedMapping.put("2020-11-27-api-docs.yaml", "api-docs-Nov272020.yaml..txt");
        sortedMapping.put("2020-12-02-api-docs.yaml", "api-docs-Dec022020.yaml.txt");
        sortedMapping.put("2020-12-24-api-docs.yaml", "api-docs-Dec242020.yaml.txt");
        sortedMapping.put("2021-01-12-api-docs.yaml", "api-docs-Jan122021.yaml.txt");
        sortedMapping.put("2021-01-14-api-docs.yaml", "api-docs-Jan142021.yaml.txt");
        sortedMapping.put("2021-02-18-api-docs.yaml", "api-docs-Feb182021.yaml.txt");
        sortedMapping.put("2021-03-02-api-docs.yaml", "api-docs-Mar022021.yaml.txt");
        sortedMapping.put("2021-10-26-api-docs.yaml", "api-docs-Oct262021.yaml.txt");
        sortedMapping.put("2022-01-21-api-docs.yaml", "api-docs-Jan212022.yaml.txt");
        sortedMapping.put("2022-05-25-api-docs.yaml", "api-docs-May252022.yaml.txt");
        sortedMapping.put("2022-06-20-api-docs.yaml", "api-docs-June202022yaml.txt");
        sortedMapping.put("2022-11-api-docs.yaml", "api-docs-nov-2022.yaml.txt");
        sortedMapping.put("2022-12-api-docs.yaml", "api-docs-dec-2022.yaml.txt");
        sortedMapping.put("2023-01-api-docs.yaml", "api-docs-jan-2023.yaml.txt");
        sortedMapping.put("2023-02-api-docs.yaml", "api-docs-feb-2023.yaml.txt");
        sortedMapping.put("2023-04-03-api-docs.yaml", "api-docs-3 Apr-2023.yaml.txt");
        sortedMapping.put("2023-06-16-api-docs.yaml", "api-docs-16 June-2023.yaml.txt");
        sortedMapping.put("2023-07-14-api-docs.yaml", "api-docs-14 July-2023.yaml.txt");
        sortedMapping.put("2023-09-15-api-docs.yaml", "api-docs-15 Sept-2023.yaml.txt");
        sortedMapping.put("2023-11-api-docs.yaml", "api-docs-Nov-2023.yaml.txt");
        sortedMapping.put("2024-01-19-api-docs.yaml", "api-docs-Jan-19-2024.yaml.txt");
        sortedMapping.put("2024-06-api-docs.yaml", "api-docs-June-2024.yaml.txt");
        sortedMapping.put("2024-09-api-docs.yaml", "api-docs-September-2024.yaml.txt");
        sortedMapping.put("2024-10-api-docs.yaml", "api-docs-October-2024.yaml.txt");
        sortedMapping.put("2024-12-api-docs.yaml", "api-docs-December-2024.yaml.txt");
    }

    public Map<String, String> getFilePahts(){
        return sortedMapping;
    }

    public Map<String, String> getOldestAndNewestYAML(){
        Map<String, String> sortedMapping = new TreeMap<>();
        sortedMapping.put("OPENAPI_DOC_OLD","2020-10-29-api-docs.yaml");
        sortedMapping.put("OPENAPI_DOC_NEW","2024-12-api-docs.yaml");
        return sortedMapping;
    }

}
