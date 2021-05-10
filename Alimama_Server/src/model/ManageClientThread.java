package model;

import java.util.HashMap;

public class ManageClientThread {
    public static HashMap hm=new HashMap<String,SerConClientThread>();
    public static void addClientThread(String uid,SerConClientThread ct){

        hm.put(uid,ct);
    }
    public static SerConClientThread getClientThread(String uid) {

        if (hm.containsKey(uid)) {

            return (SerConClientThread) hm.get(uid);
        } else {
            return null;
        }

    }

}
