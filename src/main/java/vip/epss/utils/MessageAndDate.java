package vip.epss.utils;

import java.util.HashMap;
import java.util.Map;

public class MessageAndDate {
    private Integer statusCode;
    private String message;
    private Map<String,Object> dataZone =new HashMap<>();

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getDataZone() {
        return dataZone;
    }

    public void setDataZone(Map<String, Object> dataZone) {
        this.dataZone = dataZone;
    }
    public static MessageAndDate success (String msg){
        MessageAndDate mad = new MessageAndDate();
        mad.setStatusCode(200);
        mad.setMessage(msg);
        return mad;
    }
    public MessageAndDate add(String key, Object value){
         dataZone.put(key, value);
         return this;
    }


}
