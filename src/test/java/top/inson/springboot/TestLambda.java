package top.inson.springboot;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

@Log4j2
public class TestLambda {

    @Test
    public void testLambda(){
        List<String> list = Arrays.asList("a", "d", "c", "s", "f");
        log.info("list集合：{}",list);
        //list.forEach( a -> log.info("值：" + a));
        //lambda表达式引用类成员和局部变量，会将这些变量隐式转换成final的
        String str = "字符串:";
        list.forEach( (String a) -> {
            log.info(str + a);
        });
        list.sort( (a, b) -> {
            return a.compareTo(b);
        });
        log.info("list集合：{}", list);

    }


}
