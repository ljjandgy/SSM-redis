package com.example.springredis.mybatis;





import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * SqlSessionFactory相关功能工具类
 */
public class SqlSessionFactoryUtils {
    private final static Class<SqlSessionFactoryUtils> LOCK = SqlSessionFactoryUtils.class;
    private static SqlSessionFactory sqlSessionFactoryUtils = null;
    //构造方法私有化，让其不能再其他类中通过new实例化
    private SqlSessionFactoryUtils(){}
    public static SqlSessionFactory getSqlSessionFactoryUtils(){
        synchronized (LOCK){
            //当类已经被实例化时（内存中已经存在该类了）,就直接返回成员变量
            if (sqlSessionFactoryUtils!=null){
                return sqlSessionFactoryUtils;
            }
        }
        String resource = "";//mybatis的配置文件，用于生成SqlSessionFactory对象（在SqlSessionFactoryBuilder对象中使用）
        //定义输入流对象
        InputStream inputStream;
        try{
            inputStream = Resources.getResourceAsStream(resource);//获取配置文件流
            sqlSessionFactoryUtils = new SqlSessionFactoryBuilder().build(inputStream);//获取工厂对象
        }catch (IOException e){
            e.printStackTrace();
        }
        return sqlSessionFactoryUtils;
    }
}
