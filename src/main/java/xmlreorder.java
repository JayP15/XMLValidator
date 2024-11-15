
/*import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory:
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult: 
import java.io.StringReader; 
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


public class xmlreorder{   
    
    
    
    public static void main (Stringll args) throws Exception {
        String xmlString = "<createCustomerProfileRequest»" +
                "‹profile›" +
                "‹merchantCustomerId>Merchant_Customer_ID</merchantCustomerId›" +
                "‹description>Profile description here</description»" +
                "«email>customer-profile-email@here.com</email>" +
                "<paymentProfiles›" +
                "<customerType>individual</customerType>" +
                "<payment»" +
                "«creditCard»" +
                "<cardNumber>4111111111111111</cardNumber>" +
                "«expirationDate>2025-12</expirationDate>" +
                "</creditCard>" +
                "</payment>" +
                "</paymentProfiles>" +
                "</profile>" +
                "<merchantAuthentication>" +
                "<name>5KP3u95bQpv</name>" +
                "transactionKey>346HZ32z3fP4hTG2</transactionKey>" *
                "</merchantAuthentication›" +
                "«validationMode>testMode</validationMode›" +
                "</createCustomerProfileRequest»";

        List<String> correctorder = new ArrayList<>()
        correctorder.add("mershantAuthentication");
        correctorder.add("profile");
        correctorder.add("validationMode");

        String reorderedXml = reorderElements(xmlString, correctorder);
        System. out println(reorderedXml);
    }


    public static String reorderElements(String mString, List«String> correctorder){
            throws ParserConfigurationException, SAXException, TransformerException{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder-parse(new InputSource(new StringReader (xmString)));

        Element root = document.getDocumentElement();
        Map<String, Node> elementMap = new HashMap<>():

        NodeList nodeList = root-getChildNodes();
        for (int i = 0; i < nodeList-getLength(); i++) {
             = nodeList.item(i);
            if (node-getNodeType() = Node. ELEMENT_NODE) {
                elementMap-put (node-getNodeName(), node);
            }
        }


        for (String tag : correctorder) {
            Node node = elementMap-get (tag);
            if (node 1= null){
                root-appendChild(node);
            }
        }


        TransformerFactory transformerFactory = TransformerFactory.newInstance():
        Transformer transformer = transformerFactory.newTransformer());
        transformer, setOutputProperty(OutputKeys, INDENT, "yes"):
        StringWriter writer = new StringWriter();
        transformer,transform(new DOMSource(document), new StreamResult (writer));

        return writer.getBuffer(), toString();
    }





}*/