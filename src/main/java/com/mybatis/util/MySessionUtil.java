package com.mybatis.util;

import net.sf.cglib.beans.BeanMap;
import org.apache.ibatis.datasource.jndi.JndiDataSourceFactory;
import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.apache.ibatis.type.TypeAliasRegistry;

import java.io.*;
import java.util.HashMap;

public class MySessionUtil {
    private final static Class<MySessionUtil> MYUTIL = MySessionUtil.class;
    //数据库连接池
    private static SqlSessionFactory factory = null;
    public static SqlSession getSqlSession() {
        synchronized (MYUTIL){
        if(factory != null){
            return factory.openSession();
        }
        try {
            String config = "config/mybatis-config.xml";

            InputStream in = Resources.getResourceAsStream(config);

            factory = new SqlSessionFactoryBuilder().build(in);

            //看看mybatis的配置
            Configuration mybatisConfig = factory.getConfiguration();
            //注册别名
            registerAlias(mybatisConfig);

            BeanMap configBean = BeanMap.create(mybatisConfig);

            configBean.forEach((k,v) -> {
                //MyUtil.log(k+":"+v);
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
        //返回数据库单例
        return factory.openSession();
        }
    }

    public static void log(Object obj){
        try {
            //向文件追加内容
            FileOutputStream file = new FileOutputStream("log.txt",true);
            System.setOut(new PrintStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(obj);
    }
    public static void println(Object obj){
        System.setOut(System.out);
        System.out.println(obj);
    }

    public static void registerAlias(Configuration config){
        TypeAliasRegistry register = config.getTypeAliasRegistry();
        //参数或返回值
        register.registerAlias("hashmap", HashMap.class);
        //事务别名
        register.registerAlias("JDBC", JdbcTransactionFactory.class);
        //数据源别名
        register.registerAlias("JNDI", JndiDataSourceFactory.class);
        register.registerAlias("POOLED", PooledDataSourceFactory.class);
        //......
    }
}
