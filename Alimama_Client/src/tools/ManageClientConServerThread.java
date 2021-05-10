package tools;

import java.util.HashMap;

public class ManageClientConServerThread extends Thread {
    public  static HashMap hm=new HashMap<String,ClientConServerThread>();
    public static void addClientConServerThread(String id,ClientConServerThread ccst){
        hm.put(id,ccst);
    }
    public static ClientConServerThread getClientConServerThread(String id){
        return (ClientConServerThread)hm.get(id);
    }
}
