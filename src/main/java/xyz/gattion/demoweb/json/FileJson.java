package xyz.gattion.demoweb.json;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class FileJson extends ReturnJson{

    private JSONObject files = new JSONObject();
    private String content;

    public JSONObject getFiles() {
        return files;
    }

    public void setFiles(JSONObject files) {
        this.files = files;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
