package xyz.gattion.demoweb.json;

import java.io.Serializable;

public class ReturnJson implements Serializable {

    public ReturnJson() {
        this("200", "OK");
    }

    public ReturnJson(String returnCode, String returnMsg) {
        this.returnCode = returnCode;
        this.returnMsg = returnMsg;
    }

    public static ReturnJson ok() {
        return new ReturnJson();
    }

    public static ReturnJson fail() {
        return new ReturnJson("400", "fail");
    }

    private String returnCode;
    private String returnMsg;

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }
}
