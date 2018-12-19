package com.yangbin1.mybatisTest;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.yangbin1.mybatis.bean.Employee;

public class MybatisTest {
	
	/**
	 * 1.根据配置文件（全局配置文件）得到sqlSessionFactory对象
	 * 2.sqlsession对象
	 * @throws IOException
	 */
	@Test
	public void test() throws IOException {
		String resource = "mybatis-config.xml";
		// 配置文件的流读取sessionFactory
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 获取sqlSession实例，可以直接执行已经映射的sql语句
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			// 第一个参数mapper唯一标识，第二个参数是传入对象id
			Employee employee = sqlSession.selectOne("com.yangbin1.mybatis.EmployeeMapper.selectEmp", 1);
			System.out.println(employee);
		} finally {
			sqlSession.close();
		}
	}

}
