package tools;

import com.client.page.MyFrame2;

public class NowChatObject {
    private static String nowFriend;
    private static String nowState;
    private static MyFrame2 myFrame2;

    public static MyFrame2 getMyFrame2() {
        return myFrame2;
    }

    public static void setMyFrame2(MyFrame2 myFrame2) {
        NowChatObject.myFrame2 = myFrame2;
    }

    public static String getNowFriend() {
        return nowFriend;
    }

    public static void setNowFriend(String nowFriend) {
        NowChatObject.nowFriend = nowFriend;
    }

    public static String getNowState() {
        return nowState;
    }

    public static void setNowState(String nowState) {
        NowChatObject.nowState = nowState;
    }
}
