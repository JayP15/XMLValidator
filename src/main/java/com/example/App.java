package com.example;

import java.io.File;

public class App {
    public static void main(String[] args) {
        // Instantiate XMLValidator
        XMLValidator validator = new XMLValidator();

        // Define file paths
        File inputFile = new File("data/peoples.json");
        File xsdFile = new File("data/peoples.xsd");

        // Check if files exist before processing
        if (!inputFile.exists() || !xsdFile.exists()) {
            System.out.println("One or more files do not exist.");
            return; // Exit if files are not found
        }

        try {
            // Check file type and validate accordingly
            if (inputFile.getName().endsWith(".json")) {
                // Convert JSON to XML
                File xmlFile = validator.convertJsonToXml(inputFile);
                if (xmlFile != null) {
                    // Validate the converted XML against XSD
                    validator.validateXMLAgainstXSD(xmlFile, xsdFile);
                } else {
                    System.out.println("Failed to convert JSON to XML.");
                }
            } else {
                // Directly validate XML against XSD
                validator.validateXMLAgainstXSD(inputFile, xsdFile);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
