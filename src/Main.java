
import console.util.ConsoleWriter;
import entity.User;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import service.GsonService;
import service.XMlDOMService;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
//JSON

        GsonService gsonService = new GsonService();

        User user1 = new User("Simon", "sensei", "tms-t");
        User user2 = new User("Yuri", "student", "tms-s");

        List<User> usersList = new ArrayList<>();
        usersList.add(user1);
        usersList.add(user2);

        gsonService.inputJson("test4.json", usersList);

        List list = gsonService.outputJson("test4.json");

        ConsoleWriter consoleWriter = new ConsoleWriter();
        consoleWriter.writeJson(list);

//XML
        XMlDOMService xmlService = new XMlDOMService();
        Document document = xmlService.parse("test2.xml");

        Element documentElement = document.getDocumentElement();

        NodeList users = documentElement.getElementsByTagName("users");
        List<Object> xmlList = new ArrayList<>();
        if (users.getLength() != 0){
            xmlList = xmlService.readTreeFromElement(users);
        } else {
            System.out.println("Element didn't found");
        }
        consoleWriter.writeXML(xmlList);
    }
}