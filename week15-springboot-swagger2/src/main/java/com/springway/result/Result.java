package com.springway.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @ProjectName javaee-2208-seven-group-aunt-coming
 * @Author Qiu Jingxian
 * @Description TODO
 * @Date 2022/10/24 17:04
 * @Version 1.0
 */
@Data
@ApiModel("统一返回对象")
public class Result {

    @ApiModelProperty("返回代码")
    private Integer code;
    @ApiModelProperty("返回信息")
    private String message;
    @ApiModelProperty("返回数据")
    private HashMap data = new HashMap();

    private Result(){}

    /**
     * 生成访问成功结果
     * @return
     */
    public static Result genOkResult(){
        Result result = new Result();
        result.code = ResponseCode.SUCCESS.getCode();
        result.message = ResponseCode.SUCCESS.getMessage();
        return result;
    }

    /**
     * 生成访问失败结果
     * @return
     */
    public static Result genFailureResult(){
        Result result = new Result();
        result.code = ResponseCode.SUCCESS.getCode();
        result.message = ResponseCode.SUCCESS.getMessage();
        return result;
    }

    /**
     * 生成自定义参数访问失败结果
     * @return
     */
    public static Result genFailureResult(Integer code, String message){
        Result result = new Result();
        result.code = ResponseCode.SUCCESS.getCode();
        result.message = ResponseCode.SUCCESS.getMessage();
        return result;
    }

    /**
     * 根据键值对封装数据
     *
     * @param key
     * @param value
     * @return
     */
    public Result setData(String key, Object value){
        this.data.put(key, value);
        return this;
    }

    /**
     * 根据Map集合封装数据
     * @param datas
     * @return
     */
    public Result setData(HashMap<String, Object> datas ){
        Set<Map.Entry<String, Object>> entries = datas.entrySet();
        Iterator<Map.Entry<String, Object>> iterator = entries.iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Object> next = iterator.next();
            String key = next.getKey();
            Object value = next.getValue();
            this.data.put(key, value);
        }
        return this;
    }
}
