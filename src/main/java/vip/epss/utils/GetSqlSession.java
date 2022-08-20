package vip.epss.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class GetSqlSession {

        public static SqlSession createSq1Session() {
            SqlSessionFactory sqlSessionFactory = null;
            InputStream input = null;
            SqlSession session = null;
            try {
//1 获得mybatis的环境配置文件
                String resource = "main/resources/mybatis.xml";
                //以流的方式获取recource(mybatis的环境配置文件)
                input = Resources.getResourceAsStream(resource);// 创建会话工厂
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(input);
                // 通过工厂得到Sq1Session
                session = sqlSessionFactory.openSession();
                return session;
            } catch (IOException e) {
                e.printStackTrace();
                return null;

            }
        }

    public static void main(String[] args) {
        System.out.println(createSq1Session());
    }
    }
