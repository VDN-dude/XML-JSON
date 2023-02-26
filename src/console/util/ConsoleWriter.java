package console.util;

import util.Writer;

import java.util.List;

public class ConsoleWriter implements Writer {
    @Override
    public void write(String message) {System.out.print(message);}
    @Override
    public void writeln(String message) {System.out.println(message);}
    public void writeJson(List list){
        System.out.println(list);
    }
    public void writeXML(List<Object> list){
        for (Object o : list) {
            System.out.println(o);
        }
    }
}
