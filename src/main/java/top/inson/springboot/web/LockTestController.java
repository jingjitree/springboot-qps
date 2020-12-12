package top.inson.springboot.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.inson.springboot.utils.RedissonLockUtil;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping(value = "/lock")
public class LockTestController {


    @GetMapping("/doubleKill")
    public String doubleKill(HttpServletRequest request){
        String sessionId = request.getRequestedSessionId();
        log.info("请求的sessionId:" + sessionId);
        boolean getLock = RedissonLockUtil.tryLock("doubleKill", 0, 5);
        try {
            String msg;
            if (getLock) {
                msg = "恭喜：" + sessionId + ":成功秒杀到商品";
            }else {
                msg = "不好意思：" + sessionId +":该sessionId:没有抢到商品";
            }
            log.info(msg);
            return msg;
        }catch (Exception e){
            log.info("系统异常", e);
        }finally {
            RedissonLockUtil.unlock("doubleKill");
        }
        return "fail";
    }



}
