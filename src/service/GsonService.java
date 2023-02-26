package service;

import com.google.gson.Gson;

import java.io.*;
import java.util.List;

public class GsonService {
    private final Gson gson = new Gson();
    public void inputJson(String uri, Object src) throws IOException {
        String s = gson.toJson(src);
        FileWriter fileWriter = new FileWriter(uri);
        fileWriter.write(s);
        fileWriter.close();
    }

    public List outputJson(String uri) throws IOException {
        FileReader fileReader = new FileReader(uri);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String gsonString = bufferedReader.readLine();
        String out;
        while ((out = bufferedReader.readLine()) != null){
            gsonString = gsonString.concat(out);
        }
        return gson.fromJson(gsonString, List.class);
    }
}
