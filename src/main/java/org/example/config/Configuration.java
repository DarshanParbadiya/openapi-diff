package org.example.config;

public class Configuration {
    public  String API_DOCS_FOLDER;
    public String API_DOCS_DIFF_OUTPUT_FOLDER;

    public Configuration(){
        API_DOCS_FOLDER = "C:\\yaml\\ordered-YAML\\";
//        API_DOCS_FOLDER = "./input\\";
        API_DOCS_DIFF_OUTPUT_FOLDER = "C:\\yaml\\diff-HTML\\";
    }

    public Configuration(String API_DOCS_FOLDER, String API_DOCS_DIFF_OUTPUT_FOLDER) {
        this.API_DOCS_FOLDER = API_DOCS_FOLDER;
        this.API_DOCS_DIFF_OUTPUT_FOLDER = API_DOCS_DIFF_OUTPUT_FOLDER;
    }

    public String getAPI_DOCS_FOLDER() {
        return API_DOCS_FOLDER;
    }

    public void setAPI_DOCS_FOLDER(String API_DOCS_FOLDER) {
        this.API_DOCS_FOLDER = API_DOCS_FOLDER;
    }

    public String getAPI_DOCS_DIFF_OUTPUT_FOLDER() {
        return API_DOCS_DIFF_OUTPUT_FOLDER;
    }

    public void setAPI_DOCS_DIFF_OUTPUT_FOLDER(String API_DOCS_DIFF_OUTPUT_FOLDER) {
        this.API_DOCS_DIFF_OUTPUT_FOLDER = API_DOCS_DIFF_OUTPUT_FOLDER;
    }
}
