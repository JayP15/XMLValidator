package com.example;

import java.io.File;

public class App 
{
    public static void main( String[] args ) {
        XMLValidator validator = new XMLValidator();

        // Define the file paths
        File inputFile = new File("data/peoples.json");
        File xsdFile = new File("data/peoples.xsd");

        // Check file type and validate accordingly
        if (inputFile.getName().endsWith(".json")) {
            // Convert JSON to XML
            File xmlFile = validator.convertJsonToXml(inputFile);
            if (xmlFile != null) {
                // Validate the converted XML
                validator.validateXMLAgainstXSD(xmlFile, xsdFile);
            }
        } else {
            // Directly validate XML
            validator.validateXMLAgainstXSD(inputFile, xsdFile);
        }

        // Comment
    }
}
