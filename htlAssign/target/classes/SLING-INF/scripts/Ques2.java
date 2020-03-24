import com.google.gson.reflect.TypeToken;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.scripting.sightly.pojo.Use;
import com.google.gson.Gson;


import javax.script.Bindings;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Ques2 implements Use {


    private List<Map<String, String>> resourceChild;

    @Override
    public void init(Bindings bindings) {
        try {
            URL url = new URL("http://localhost:8080/content/htl/my-servlets.data.json");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            Gson gson = new Gson();
            resourceChild = gson.fromJson(in.readLine(), new TypeToken<List<Map<String, String>>>() {}.getType());
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Map<String, String>> getResourceChild() {
        return this.resourceChild;
    }


}