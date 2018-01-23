package cn.aldd.vape.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * All rights Reserved, Designed By 翼虎能源
 * Copyright:    Copyright(C) 2015-2017
 * Company   北京翼虎能源科技有限公司
 *
 * @author 严作宇
 * @version 1.0
 * @date 17/7/10 下午1:44
 * @Description
 */
public class HttpClientUtils {

    public static Map<String,Object> httpPost(String uri , Map<String,String> headers, JSONObject jsonObj ) throws Exception{
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(uri);
        // header 参数处理
        if(headers !=null){
            Object[] keys = headers.keySet().toArray();;
            for (Object key:keys
                    ) {
                httpPost.setHeader(key.toString(),headers.get(key) );
            }

        }
        //body 处理 拼接参数
        if(jsonObj !=null) {
            StringEntity entity = new StringEntity(jsonObj.toJSONString());
            entity.setContentEncoding("UTF-8");
            entity.setContentType("application/json");//设置为 json数据
            httpPost.setEntity(entity);
        }
        CloseableHttpResponse response = httpclient.execute(httpPost);
        StatusLine statusLine = response.getStatusLine();
        try {
            HttpEntity responseEntity = response.getEntity();
            EntityUtils.consume(responseEntity);
        } finally {
            response.close();
        }
        Map<String,Object> result = new HashMap<String, Object>();
        result.put("code" , statusLine.getStatusCode());
        result.put("reason" ,statusLine.getReasonPhrase());
        return result ;
    }
}