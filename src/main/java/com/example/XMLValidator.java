package com.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
//import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

public class XMLValidator {

    public File convertJsonToXml(File jsonFile) {
        try {
            // Read JSON from file
            ObjectMapper jsonMapper = new ObjectMapper();
            JsonNode jsonNode = jsonMapper.readTree(jsonFile);

            // Get the root element from JSON
            if (jsonNode.isObject() && jsonNode.size() == 1) {
                String rootName = jsonNode.fieldNames().next();
                JsonNode rootNode = jsonNode.get(rootName);

                // Convert JSON to XML with root name and namespace
                XmlMapper xmlMapper = new XmlMapper();

                // Set the default namespace
                //xmlMapper.setDefaultUseWrapper(false);
                String xml = xmlMapper.writer().withRootName(rootName).writeValueAsString(rootNode);

                // Create a temporary XML file
                File xmlFile = File.createTempFile("converted_", ".xml");
                try (FileWriter writer = new FileWriter(xmlFile)) {
                    writer.write(xml);
                }

                System.out.println("Converted XML:\n" + xml);
                //System.out.println("Converted XML");
                return xmlFile;
            } else {
                System.out.println("Unexpected JSON structure. Expected a single root element.");
                return null;
            }

        } catch (IOException e) {
            e.printStackTrace();
            return null; // Return null if conversion fails
        }
    }

    public  boolean validateXMLAgainstXSD(File xml, File xsd) {
        try {
            // Create a SchemaFactory capable of understanding WXS schemas
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

            // Load the XSD schema file
            Schema schema = factory.newSchema(xsd);
            
            // Create a Validator instance
            Validator validator = schema.newValidator();
            
            // Validate the XML file against the schema
            validator.validate(new StreamSource(xml));
            System.out.println("The XML file is valid against the schema.");
            return true;  // Validation passed

        } catch (SAXException e) {
            System.out.println("Validation error: " + e.getMessage());
            return false; // Validation failed
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
