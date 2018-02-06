package cn.com.start.AppAPI.dto;

import java.util.HashMap;
import java.util.List;

/**
 * Created by user on 2017/3/2.
 */
public class PileBaseInfoJsonReDto {
    /** 返回状态码 */
    public int returnCode;

    /** 错误状态码 */
    public String errorCode;

    /** 返回消息 */
    public String message;

    public int cpType;

    // 可能返回的是多个list
    public HashMap<String, List<?>> detail = new HashMap<String, List<?>>();

}
