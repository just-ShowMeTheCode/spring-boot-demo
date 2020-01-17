import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.RedisCacheDemoApplication;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fumj
 * @projectName spring-boot-demo
 * @description: TODO
 * @date 2019/8/1611:44
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RedisCacheDemoApplication.class)
@Slf4j
public class BastTest {
    private Map<Long,Long>  costTimeMap = new HashMap<>();
    @Before
    public void before(){
            costTimeMap.put(Thread.currentThread().getId(),System.currentTimeMillis());
    }

    @After
    public void after(){
        Long threadId = Thread.currentThread().getId();
        log.info("thread" + threadId+ "cost time " + (System.currentTimeMillis() - costTimeMap.get(threadId)));
    }


}
