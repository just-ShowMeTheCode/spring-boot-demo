package cn.com.city.redis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * @author fumj
 * @projectName spring-boot-demo
 * @description: TODO
 * @date 2019/8/1613:47
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Person implements Serializable {

    private Long personId;

    private String name;

    private String email;


}
