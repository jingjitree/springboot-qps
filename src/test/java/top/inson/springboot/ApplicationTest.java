package top.inson.springboot;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import top.inson.springboot.utils.RedisUtil;


@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RedisUtil redisUtil;


    @Test
    public void testRedis(){
        //log.info("redisTemplate:"+redisTemplate);
        redisUtil.set("username","jingjitree");
        Object username = redisUtil.get("username");
        log.info("用户名" + username);
    }


}
