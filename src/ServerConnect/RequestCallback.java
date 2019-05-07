package ServerConnect;

import org.json.JSONObject;

public interface RequestCallback {

    void response(JSONObject obj);

    void fail();


}
