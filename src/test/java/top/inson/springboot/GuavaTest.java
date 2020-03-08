package top.inson.springboot;


import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Stopwatch;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.*;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

@Log4j2
public class GuavaTest {

    @Test
    public void collection(){
        //不变的collection创建
        ImmutableList<String> iList = ImmutableList.of("a", "d", "c", "f");
        log.info("guava集合ilist:{}", iList);
        ImmutableMap<String, Integer> iMap = ImmutableMap.of("k1",1,"k2",2);
        log.info("iMap:{}", iMap);
        ImmutableSet<String> iSet = ImmutableSet.of("s1", "s2");
        log.info("iset:{}", iSet);
    }

    @Test
    public void multiMap(){
        //等同于 Map<String, List<Integer>>
        Multimap<String,Integer> map = ArrayListMultimap.create();
        map.put("student",1);
        map.put("student",2);
        map.put("username", 66);
        log.info("map数据：{}", map);
    }

    @Test
    public void testStr(){
        //实现的连接器将忽略 null
        Joiner joiner = Joiner.on(",").skipNulls();
        String result = joiner.join("java", "mysql", "spring", null);
        log.info("result:" + result);

        //字符串拆分
        Splitter splitter = Splitter.on("-").trimResults().omitEmptyStrings();
        Iterable<String> splits = splitter.split("java-   --mysql--   -jdk");
        log.info("splits:" + splits);

        //字符串匹配，实现匹配筛选等动作
        String str = "ssddsdsd123,456,789.23";
        //只保留数字
        String num = CharMatcher.digit().retainFrom(str);
        log.info("num：" + num);
        //数字与字母使用 * 号代替
        String reNum = CharMatcher.javaLetterOrDigit().replaceFrom(num, "*");
        log.info("reNum:" + reNum);
        //是否全是数字
        boolean b = CharMatcher.digit().matchesAllOf(str);
        log.info("isb:" + b);
    }

    @Test
    public void testStopwatch(){
        Stopwatch stopwatch = Stopwatch.createUnstarted();
        //开始计量时间
        stopwatch.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //停止计量时间
        stopwatch.stop();
        //秒数
        long seconds = stopwatch.elapsed(TimeUnit.SECONDS);
        log.info("second:" + seconds);
    }

    @Test
    public void guavaCache(){
        Cache<Object, Object> cache = CacheBuilder.newBuilder().build();
        cache.put("key", "abcdefg123456");
        log.info("缓存中取值key：" + cache.getIfPresent("key"));

    }



}
