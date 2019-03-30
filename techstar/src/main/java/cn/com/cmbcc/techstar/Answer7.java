package cn.com.cmbcc.techstar;

import cn.com.cmbcc.mapper.TechstarMapper;
import org.apache.commons.codec.binary.Hex;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by tinyspace on 2018/3/6.
 */
public class Answer7 {

    public static void main(String[] args) throws InterruptedException {

        doSomething("1");
    }
    private static SqlSessionFactory sqlSessionFactory=null;

    public static int threadTotal=80;

    static {
        //初始化工厂
        Reader reader= null;
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory= new SqlSessionFactoryBuilder().build(reader);

        //开启线程
        ExecutorService executorService= Executors.newCachedThreadPool();
        for (int i = 0; i < threadTotal; i++) {
            executorService.execute(new MyThread(i*100000, 1000, 100 ));
        }
    }

    public static void doSomething(String id) throws InterruptedException {

//        Map<String ,Object> result=getInfoById(Integer.parseInt(id));
//        System.out.println(result);

    }

    static class MyThread extends Thread{

        private int first;//查询起始位置
        private int len;//查询的数据数量
        private int count;//循环次数
        public MyThread(int first, int len,  int count){
           this.first=first;
           this.len=len;
           this.count=count;
        }

        @Override
        public void run() {
            Map<String ,Object> map=new HashMap<>();
            map.put("first",first);
            map.put("len",len);
            for (;count>0;count--) {
                List<Map<String, Object>> resultlist = getInfoLimit(map);
                for (Map<String, Object> item: resultlist) {
                    String enMobile=encrytor((String)item.get("mobile"));
                    item.put("mobile",enMobile);
//                    System.out.println("更新数据"+item);
//                    updateInfo(item);
                }
                System.out.println("长度"+resultlist.size()+" 更新数据"+resultlist);
                batchUpdate(resultlist);
                map.put("first",first+len);
            }
        }
    }

    //对称密钥
    public static final String KEY = "729edc668823083b7477a848cfb78571";

    //加密算法
    private static final String ALGORITHMSTR = "AES/ECB/PKCS5Padding";

    private static String encrytor(String mobile){
        SecretKey secretKey=new SecretKeySpec(KEY.getBytes(),"AES");
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance(ALGORITHMSTR);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] result = cipher.doFinal(mobile.getBytes());//输入要加密的内容
            String lastResult=Hex.encodeHexString(result);
            return lastResult;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //更新
    public static void updateInfo(Map<String ,Object> params){
        TechstarMapper techstarMapper= sqlSessionFactory.openSession().getMapper(TechstarMapper.class);
        techstarMapper.updateInfo(params);
    }
    //批量更新
    public static void batchUpdate( List<Map<String, Object>>  paramsList){
        TechstarMapper techstarMapper= sqlSessionFactory.openSession().getMapper(TechstarMapper.class);
        techstarMapper.batchUpdate(paramsList);
    }
    //查找
    public static Map<String ,Object> getInfoById(int id) {
        TechstarMapper techstarMapper= sqlSessionFactory.openSession().getMapper(TechstarMapper.class);
        return techstarMapper.getInfoById(id);
    }
    //查找
    public static List<Map<String, Object>> getInfoLimit(Map<String ,Object> map) {
        TechstarMapper techstarMapper= sqlSessionFactory.openSession().getMapper(TechstarMapper.class);
        return techstarMapper.getInfoLimit(map);
    }


}
