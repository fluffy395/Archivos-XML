package XML;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class Ejercicio_XML_1 {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();

            Document documento = implementation.createDocument(null, "curriculum_vitae", null);
            documento.setXmlVersion("1.0");

            Element curriculums = documento.createElement("curriculums");
            Element curriculum = documento.createElement("curriculum");

            Element nombre = documento.createElement("Nombre");
            Text textNombre = documento.createTextNode("Issaias Garcia Alcantara");
            nombre.appendChild(textNombre);
            curriculum.appendChild(nombre);

            Element educacion = documento.createElement("Educacion");
            Text textEducacion = documento.createTextNode("CU UAEM Atlacomulco");
            educacion.appendChild(textEducacion);
            curriculum.appendChild(educacion);

            Element experiencia = documento.createElement("Experiencia");
            Text textExperiencia = documento.createTextNode("Microsoft");
            experiencia.appendChild(textExperiencia);
            curriculum.appendChild(experiencia);

            curriculums.appendChild(curriculum);
            documento.getDocumentElement().appendChild(curriculums);

            Source source = new DOMSource(documento);
            Result result = new StreamResult(new File("Curriculum_1.xml"));

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);

        } catch (ParserConfigurationException | TransformerException ex) {
            System.out.println(ex.getMessage());
        }
    }
}