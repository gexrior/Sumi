package cn.sumi.dto;

/**
 * JSON 字串封装
 * Created by gonghf95 on 5/30/17.
 */
public class JsonResult {
    private Object data;
    private String message;
    private int state;

    public static int SUCCESS = 1;
    public static int FAILURE = 0;

    public JsonResult() {
    }

    public JsonResult(String message, int state) {
        this.state = state;
        this.message = message;
    }

    public JsonResult(Object data, String message, int state) {
        this.state = state;
        this.message = message;
        this.data = data;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
