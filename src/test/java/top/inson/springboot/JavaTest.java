package top.inson.springboot;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


@Log4j2
public class JavaTest {

    @Test
    public void listTest(){
        //值传递
        List<List<String>> parentList = new LinkedList<>();
        List<String> childrenList = new ArrayList<>();
        childrenList.add("test");
        parentList.add(childrenList);
        childrenList.add("java");
        log.info("parentList:{}", parentList);
    }

    @Test
    public void stringBufferTest(){
        String s1 = "hello";
        String s2 = "world";
        change(s1, s2);
        log.info("s1:{},s2:{}",s1,s2);
    }

    public void change(String s1, String s2){
        s1 = s2;
        s2 = s1 + s2;
    }



}
