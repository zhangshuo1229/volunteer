package com.hbsx.utils;

import com.alibaba.fastjson.JSONObject;
import com.hbsx.common.base.utils.SignUtil;
import com.hbsx.constant.Constant;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author liuj
 * @email liuj@hopshine.net
 * @time Creat in 13:30 2019/10/18
 */
public class HttpSendtUtil {

    /**
     * post请求
     *
     * @param json body体
     * @param url  链接
     * @return
     */
    public static String post(JSONObject json, String url) {
        try {
            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(url);
            httpPost.addHeader("Content-Type", "application/json;charset=UTF-8");
            // 解决中文乱码问题
            StringEntity stringEntity = new StringEntity(json.toString(), "UTF-8");
            stringEntity.setContentEncoding("UTF-8");

            httpPost.setEntity(stringEntity);

            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
                @Override
                public String handleResponse(final HttpResponse response)
                        throws ClientProtocolException, IOException {
                    int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {

                        HttpEntity entity = response.getEntity();

                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new ClientProtocolException(
                                "Unexpected response status: " + status);
                    }
                }
            };
            String responseBody = httpclient.execute(httpPost, responseHandler);

            return responseBody;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static String sendGet(String url, Map<String,String> param) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String entityStr = null;
        CloseableHttpResponse response = null;
        try {
            URIBuilder uriBuilder = new URIBuilder(url);
            if(param!=null){
                uriBuilder.addParameter("organizationId", param.get("instCode"));
                uriBuilder.addParameter("startTime", param.get("startTime"));
                uriBuilder.addParameter("endTime", param.get("endTime"));
            }

            HttpGet httpGet = new HttpGet(uriBuilder.build());
            // 浏览器表示
            httpGet.addHeader("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.7.6)");
            // 传输的类型
            httpGet.addHeader("Content-Type", "application/x-www-form-urlencoded");
            // 执行请求
            response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            entityStr = EntityUtils.toString(entity, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();

        }
        return entityStr;
    }

    public static JSONObject getJson(String instCode,String url,String type){
        try{
            Date endTime = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(endTime);
            calendar.add(Calendar.MONTH, -3);
            Date startTime = calendar.getTime();
            JSONObject jsonObjct = SignUtil.getCheckParams(Constant.APP_ID, Constant.SECRET);
            jsonObjct.put("startTime", startTime);
            jsonObjct.put("endTime", endTime);
            jsonObjct.put("venueNum", instCode);
            if(StringUtils.isNotEmpty(type)){
                jsonObjct.put("type", type);
            }
            JSONObject jsonStr = JSONObject.parseObject(post(jsonObjct, url));

            return jsonStr;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


    public static JSONObject getJsonDateStr(List<String> instCodes,String url,String type,String str){
        try{
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE, -1);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            Date startTime = calendar.getTime();
            Calendar calendar1 = Calendar.getInstance();
            calendar1.set(calendar1.HOUR_OF_DAY, 0);
            calendar1.set(calendar1.MINUTE, 0);
            calendar1.set(calendar1.SECOND, 0);
            Date endTime = calendar1.getTime();
            JSONObject jsonObjct = SignUtil.getCheckParams(Constant.APP_ID, Constant.SECRET);
            if(str!=null&& !"".equals(str)){
                jsonObjct.put("startTime", str.split(",")[0]);
                jsonObjct.put("endTime", str.split(",")[1]);
            }else {
                SimpleDateFormat formatDate = new SimpleDateFormat(Constant.FORMAT_DATE);
                jsonObjct.put("startTime", formatDate.format(startTime));
                jsonObjct.put("endTime", formatDate.format(endTime));
            }
            if(StringUtils.isNotEmpty(type)){
                jsonObjct.put("type", type);
            }
            if(instCodes!=null&&instCodes.size()>0){
                jsonObjct.put("venueNums", instCodes);
            }
            JSONObject jsonStr = JSONObject.parseObject(post(jsonObjct, url));

            return jsonStr;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static JSONObject getJsonOrderDateStr(List<String> instCodes, String url, String type,String str){
        try{
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE, -1);
            Date startTime = calendar.getTime();
            JSONObject jsonObjct = SignUtil.getCheckParams(Constant.APP_ID, Constant.SECRET);
            if(str!=null&& !"".equals(str)){
                jsonObjct.put("orderStartDate", str.split(",")[0]);
                jsonObjct.put("orderEndDate", str.split(",")[1]);
            }else {
                SimpleDateFormat formatDate = new SimpleDateFormat(Constant.FORMAT_DAY);
                jsonObjct.put("orderStartDate", formatDate.format(startTime));
                jsonObjct.put("orderEndDate", formatDate.format(startTime));
            }
            if(instCodes!=null&&instCodes.size()>0){
                jsonObjct.put("venueNums", instCodes);
            }
            if(StringUtils.isNotEmpty(type)){
                jsonObjct.put("type", type);
            }
            JSONObject jsonStr = JSONObject.parseObject(post(jsonObjct, url));

            return jsonStr;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }



}
