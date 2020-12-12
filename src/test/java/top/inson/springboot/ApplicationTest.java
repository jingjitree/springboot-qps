package top.inson.springboot;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.inson.springboot.utils.RedisUtil;


@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private DruidDataSource druidDataSource;


    @Test
    public void testDataSource(){
        log.info("数据源：" + druidDataSource);
    }


    @Test
    public void testRedis(){
        redisUtil.set("username", "jingjitree");
        String username = String.valueOf(redisUtil.get("username111"));
        log.info("用户名" + username);
    }

    @Test
    public void testHash(){
        String orderId = RandomStringUtils.random(16, false, true);
        String merchantId = RandomStringUtils.random(8, false, true);
        String key = orderId + ":" + merchantId,
                item = "balance",
                value = "9.99";
        redisUtil.hset(key, item, value);
        String redisVal = (String) redisUtil.hget(key, item);
        log.info("redisVal:" + redisVal);
        String orderIdOld = "0478597569502596",
                merchantIdOld = "71630510",
                value2 = "10.96";
        String keyOld = orderIdOld + ":" + merchantIdOld;

        redisUtil.hsetNx(keyOld, item, value2);
        String oldVal = (String) redisUtil.hget(keyOld, item);
        log.info("oldVal:" + oldVal);

    }


}
