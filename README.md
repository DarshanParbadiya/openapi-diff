# **OpenAPI Diff Documentation**  

## **Installation**

### **Step 1: Initialize a JavaScript Project (Optional)**  
If you haven't already set up a Node.js project, run:  
```bash
npm init  
```

### **Step 2: Install OpenAPI Diff**  
To install the tool, use the following command:  
```bash
npm install openapi-diff --save-dev
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

## **Java Project Integration**  

For bulk comparisons, a custom Java project is available to automate commands.  

### **How to Run**  
1. Clone the project from the repository.  
2. Update configuration settings in the Java class located in the `config` folder.  
3. Execute the main method in `ReportGeneratorBulk.java` to generate and run the OpenAPI Diff commands.  

### **Java Version of OpenAPI Diff Core**  
The Java project integrates `openapi-diff-core`:  
- [Download from Maven Repository](https://mvnrepository.com/artifact/org.openapitools.openapidiff/openapi-diff-core)  

By following these steps, you'll have a streamlined workflow for tracking changes between multiple OpenAPI specifications.  
