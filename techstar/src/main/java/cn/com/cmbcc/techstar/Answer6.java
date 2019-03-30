package cn.com.cmbcc.techstar;

import cn.com.cmbcc.utils.SSLClient;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.dom4j.*;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;


public class Answer6 {


    public static void main(String[] args) throws IOException, DocumentException {
//        String[] nums={"1"};
//        String[] nums={"1","2"};
        String[] nums={"1","2" ,"3","4","5","6","7","8","9","10"};
        doSomething(args);

    }

    public static void doSomething(String[] nums) {

        String urlMode = "https://exam.cmbccdn.cn/WW.xml";

        for (int i = 0; i < nums.length; i++) {
            String realUrl = urlMode.replace("WW", nums[i]);
            String result = getResponse(realUrl);
            if (result == null){
                System.out.println("-1");
            }else {
                Document document = null;
                try {
                    document = DocumentHelper.parseText(result);
                } catch (DocumentException e) {
                    e.printStackTrace();
                    System.out.println(-1);
                    return;
                }
                Element employeeRoot = document.getRootElement();
                Iterator child1 = employeeRoot.elementIterator();
                while(child1.hasNext()){
                    Element ele2 = (Element)child1.next();
                    Iterator child2 = ele2.elementIterator();
                    while (child2.hasNext()){
                        Element ele3 = (Element)child2.next();
                        String vecAutoProcess=ele3.getName();
                        if ("vecAutoProcess".equals(vecAutoProcess)){
                            Iterator child3 = ele3.elementIterator();
                            while (child3.hasNext()) {
                                Element ele4 = (Element)child3.next();
                                Iterator child4 = ele4.elementIterator();
                                boolean flag=true;
                                while (child4.hasNext() && flag) {
                                    Element ele5 = (Element)child4.next();
                                    Iterator child5 = ele5.elementIterator();
                                    if(child5.hasNext()) {
                                        Element ele6 = (Element) child5.next();
                                        String PerspectiveTransform = ele6.getName();
                                        if ("PerspectiveTransform".equals(PerspectiveTransform)) {
                                            List<Attribute> attrs = ele6.attributes();
                                            for (Attribute item : attrs) {
                                                if ("nWidth".equals(item.getName())) {
                                                    String nWidth = item.getValue();
                                                    flag=false;
                                                    System.out.println(nWidth);

                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }

    }

    public static String getResponse(String realUrl) {

        HttpClient httpClient = null;
        HttpGet httpGet = null;
        String result = null;
        try{
            httpClient = new SSLClient();
            httpGet = new HttpGet(realUrl);
//            HttpPost httpPost=new HttpPost(url);
            HttpResponse response = httpClient.execute(httpGet);
//            HttpResponse response = httpClient.execute(httpPost);
            if(response != null){
                HttpEntity resEntity = response.getEntity();
                if(resEntity != null){
                    result = EntityUtils.toString(resEntity);
//                    System.out.println(result);
                    return result;
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
