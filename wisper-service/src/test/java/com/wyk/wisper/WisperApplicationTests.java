package com.wyk.wisper;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.javamail.JavaMailSenderImpl;


@SpringBootTest
class WisperApplicationTests {
	@Autowired
	private JavaMailSenderImpl javaMailSender;
	@Autowired
	private RedisTemplate redisTemplate;

	@Test
	void contextLoads() {
		/*SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setSubject("吴永康你好");
		simpleMailMessage.setText("我爱你");
		simpleMailMessage.setTo("2216855594@qq.com");
		simpleMailMessage.setFrom("2216855594@qq.com");
		javaMailSender.send(simpleMailMessage);*/
		/*RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
		connection.flushAll();
		connection.flushDb()*/

		redisTemplate.opsForValue().set("ccccc", "123cc");
		System.out.println(redisTemplate.opsForValue().get("mwuyongkang"));
	}

}
