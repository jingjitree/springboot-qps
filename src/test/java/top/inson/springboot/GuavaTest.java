package top.inson.springboot;


import com.google.common.collect.*;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;

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



}
