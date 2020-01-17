import com.google.gson.Gson;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import redis.model.Person;

/**
 * @author fumj
 * @projectName spring-boot-demo
 * @description: TODO
 * @date 2019/8/1611:45
 */
public class RedisTest extends BastTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void test1(){
        for (int i = 0; i < 10; i++) {
            stringRedisTemplate.opsForValue().set("redis_test_key" + i,"redis_value_" + i);
        }
    }


    @Test
    public void test2(){
        Person person = new Person();
        for (int i = 0; i < 10; i++) {
            person.setPersonId(Long.valueOf(i)).setName("redis_name" + i).setEmail("redis_" + i + "@email");
            stringRedisTemplate.opsForValue().set("person:redis_test_person_key" + i,new Gson().toJson(person));
        }
    }


}
