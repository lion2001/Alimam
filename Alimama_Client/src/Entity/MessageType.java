package Entity;

public interface MessageType {
    //最基础的两个信息
    static String message_succeed="1";
    static String message_fail="2";
    static String message_comm_mes="3";
    static String message_get_onLineFriend="4";
    static String message_ret_onLineFriend="5";
    static String message_add_chat_object="6";
    static String message_been_add_chat_object="7";
    static String message_add_collection="8";
    static String message_get_collection="9";
    static String message_get_comment="10";
    static String message_add_comment="11";
    static String message_is_comment="12";
    static String message_add_deal="13";
    static String message_get_seller="14";
    static String message_get_buyer="15";
    static String message_add_register="16";
    static String message_login="17";
    static String message_up_photo="18";
    static String message_get_all="19";
    static String message_up_product="20";
    static String message_return_product="21";
    static String message_final_auction="22";
    static String message_close="23";
}
