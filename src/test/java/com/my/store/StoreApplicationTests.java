package com.my.store;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Slf4j
@SpringBootTest
class StoreApplicationTests {

	@Autowired
	private DataSource dataSource;

	@Test
	void contextLoads() {
	}


	@Test
	void getConnection(){

		Connection connection = null;
		try {
			connection = dataSource.getConnection();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		log.info("连接对象为：{}", connection.toString());


	}





}
