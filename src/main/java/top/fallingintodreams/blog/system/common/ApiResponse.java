package top.fallingintodreams.blog.system.common;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class ApiResponse implements Serializable {
    
    @Serial
    private static final long serialVersionUID = 2633609520611856010L;
    
    private int code;
    private String msg;
    private Object data;
    
    private ApiResponse(int responseCode, String msg) {
        this(responseCode, null, msg);
    }
    
    private ApiResponse(int responseCode, Object data, String msg) {
        this.code = responseCode;
        this.data = data;
        this.msg = msg;
    }
    
    public static ApiResponse success() {
        return new ApiResponse(200, "请求成功");
    }
    
    public static ApiResponse success(String msg) {
        return new ApiResponse(200, msg);
    }
    
    public static ApiResponse success(Object data) {
        return new ApiResponse(200, data, "请求成功");
    }
    
    public static ApiResponse success(Object data, String msg) {
        return new ApiResponse(200, data, msg);
    }
    
    public static ApiResponse error(int code, String msg) {
        return new ApiResponse(code, msg);
    }
    
    public static ApiResponse error(String msg) {
        return new ApiResponse(400, msg);
    }
    
}
