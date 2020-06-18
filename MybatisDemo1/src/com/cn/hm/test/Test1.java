package com.cn.hm.test;

import com.cn.hm.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Test1 {
    public static void main(String[] args) {

        String resource = "mybatis-config.xml";
        //输入流
        InputStream inputStream = null;
        try {
            //通过加载Mybatis的主配置文件mybatis-config.xml，创建输入对象
            inputStream =  Resources.getResourceAsStream(resource);
        }catch (IOException e){
            e.printStackTrace();
        }
        /*
        SqlSessionFactoryBuilder：SqlSessionFactory的创建者
            通过该建造者对象调用建造方法，为我们创建一个SqlSessionFactory对象

            SqlSessionFactory对象唯一的作用技术为我们创建SqlSession对象

         */
        SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
        //我们未来所有的操作，使用的都是SqlSession对象
        //例如增删改查，处理事务等等，都是统一使用session来完成
        SqlSession session = sqlSessionFactory.openSession();
        /*
            需求：根据id查单条

            如果取得的是单条记录，我们请用select方法
            参数1：根据命名空间 .sqlId的形式找到我们需要使用的sql语句
            参数2：我们要为sql语句中传递的参数
         */
       /* Student student = session.selectOne("test1.getById","A0001");
        System.out.println(student);
        session.close();*/

        //查询学生表中的所有数据信息
        /*List<Student> studentlist = session.selectList("test1.getAll");
        for (Student student:studentlist){
            System.out.println(studentlist);
        }
        session.close();*/

        /*
            MyBatis默认情况下是手动提交事务
            添加、修改、删除都需要提交事务
         */
        //添加操作
       /* Student student = new Student();
        student.setId("A0005");
        student.setName("wf");
        student.setAge(29);
        session.insert("test1.save",student);
        session.commit();//手动提交事务
        session.close();*/

        //修改操作
        /*Student student = new Student();
        student.setId("A0006");
        student.setName("cxk1");
        student.setAge(30);
        session.update("test1.update",student);
        session.commit();
        session.close();*/

        //删除操作
        /*session.delete("test1.delete","A0005");
        session.commit();
        session.close();*/
    }

}
