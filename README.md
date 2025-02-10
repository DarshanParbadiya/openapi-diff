# **OpenAPI Diff Documentation**  


## **Java Project Integration**

For bulk comparisons, a custom Java project automates the execution of OpenAPI Diff commands.

### **How to Run**
1. Clone the project from the repository.
2. Update configuration settings in the `Configuration` class located in the `config` folder.
3. Execute the main method in `main.java` to generate and run OpenAPI Diff commands.

#### **Configuration Example**
```java
public class Configuration {
    public String API_DOCS_FOLDER;
    public String API_DOCS_DIFF_OUTPUT_FOLDER;

    public Configuration() {
        API_DOCS_FOLDER = "C:\\yaml\\ordered-YAML\\";
        API_DOCS_DIFF_OUTPUT_FOLDER = "C:\\yaml\\diff-HTML\\";
    }
}
```
Ensure that the YAML files are placed in the `API_DOCS_FOLDER`, and specify the desired output folder.

### **Handling YAML File Mapping**
The program maps files using a `YAMLfilesHashMap` class:
```java
public class YAMLfilesHashMap {
    Map<String, String> sortedMapping = new TreeMap<>();

    public YAMLfilesHashMap() {
        sortedMapping.put("2020-10-29-api-docs.yaml", "api-docs.yaml");
        sortedMapping.put("2020-11-19-api-docs.yaml", "api-docs-Nov192020.yaml.txt");
        sortedMapping.put("2020-11-27-api-docs.yaml", "api-docs-Nov272020.yaml.txt");
        sortedMapping.put("2020-12-02-api-docs.yaml", "api-docs-Dec022020.yaml.txt");
        sortedMapping.put("2020-12-24-api-docs.yaml", "api-docs-Dec242020.yaml.txt");
        sortedMapping.put("2021-01-12-api-docs.yaml", "api-docs-Jan122021.yaml.txt");
    }
}
```
The program scans for files in the specified folder by referring to this mapping.

### **Generating Reports**
Use the following function to generate HTML reports containing API differences:
```java
reportGeneratorBulk.generateHTMLReport();
```

### **Command Execution**
Commands are generated using:
```java
commandGenerator.processAllFiles();
```
Initially, commands were executed via `ProcessBuilder`, but errors caused instability. The improved approach generates all commands, which can be copied and executed manually in the command prompt.

**Tip:** If a command gets stuck, cancel it by pressing `Ctrl + Z`.

### Sample Output
![image](https://github.com/user-attachments/assets/9838945a-03a3-414c-bd0c-6d6a5ac8ad14)

---

### **Maven Dependency for `openapi-diff-core`**
To integrate OpenAPI Diff Core in Java, download it from [Maven Repository](https://mvnrepository.com/artifact/org.openapitools.openapidiff/openapi-diff-core).

---

By following these steps, you can efficiently track changes between multiple OpenAPI specifications and generate insightful reports.



## **Installation of openapi-diff**


### **Step 1: Install OpenAPI Diff**  
To install the tool, use the following command:  
```bash
npm install -g openapi-diff
```  






Follow the prompts to complete the project setup.  

---

## **Description**  

OpenAPI Diff helps identify changes between two Swagger or OpenAPI specification files, categorized into:  
- **Breaking Changes:** Potentially incompatible changes for consumers.  
- **Non-Breaking Changes:** Additions or updates that maintain compatibility.  
- **Unclassified Changes:** Changes that cannot be categorized (e.g., updates to custom properties).  

---

## **Change Classifications**  

### **Breaking Changes**  
These changes may break API compatibility for existing consumers, such as:  
- Removing a path or method  
- Changing a property from optional to required in request bodies  
- Changing a property from required to optional in response bodies  

### **Non-Breaking Changes**  
These changes are backward-compatible, such as:  
- Adding a path or method  
- Changing a property from required to optional in request bodies  
- Changing a property from optional to required in response bodies  

### **Unclassified Changes**  
Changes that can't be classified, such as modifications to custom properties (`x-properties`).  

---

## **Usage**  

### **As a CLI Tool**  
Invoke the tool with file paths for the source and destination specification files. Supported formats are JSON or YAML with Swagger 2 or OpenAPI 3 specifications.  

Example command:  
```bash
npx openapi-diff /path/to/source-specification.yaml /path/to/destination-specification.yaml  
```  

### **Output**  
The tool provides:  
- Lists of breaking, non-breaking, and unclassified differences  
- A non-zero exit code if any breaking changes are detected  

---


