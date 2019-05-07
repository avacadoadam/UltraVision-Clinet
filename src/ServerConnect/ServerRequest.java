package ServerConnect;

import org.json.JSONObject;

import java.io.*;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ServerRequest implements Runnable{
    private static final int PORT = 3234;
    private static final String HOST = "127.0.0.1";

    private RequestCallback callback;
    private String requestJSON;

    public ServerRequest(RequestCallback callback, String requestJSON) {
        this.callback = callback;
        this.requestJSON = requestJSON;
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        try {
            Socket socket = new Socket(HOST, PORT);
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(outputStream, true);
            pw.write(requestJSON+"\n");
            pw.flush();
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String str = br.readLine();

            JSONObject json = new JSONObject(str);

            callback.response(json);
        } catch (Exception e) {
            callback.fail();
            e.printStackTrace();
        }
    }

    public static ServerRequest createServerRequest(RequestCallback callback,String requestJSON){
        return new ServerRequest(callback,requestJSON);
    }


}
