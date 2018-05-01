import java.sql.Date;
import java.util.ArrayList;
import java.util.TreeMap;

public class DataModel {

    private Date timeStamp;
    private boolean sync;
    private ArrayList<Integer> data;

    public DataModel()
    {
        data = null;
        sync = false;
        timeStamp = null;
    }
}
