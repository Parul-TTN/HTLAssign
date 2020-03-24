import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import javax.script.Bindings;
import org.apache.sling.scripting.sightly.pojo.Use;

public class Ques1 implements Use {

    private String date;


    @Override
    public void init(Bindings bindings) {

        Date dateObject = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        date = dateFormat.format(dateObject);

    }

    public String getDate() {
        return this.date;
    }

}