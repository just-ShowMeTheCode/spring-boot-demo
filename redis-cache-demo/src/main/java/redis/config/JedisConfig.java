package redis.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

/**
 * @author fumj
 * @projectName spring-boot-demo
 * @description: TODO
 * @date 2019/8/719:08
 */
@Configuration
public class JedisConfig {

    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private Integer port;
    @Value("${spring.redis.database}")
    private Integer database;
    @Value("${spring.redis.password}")
    private String password;
    @Value("${spring.redis.jedis.pool.max-active}")
    private Integer maxActive;
    @Value("${spring.redis.jedis.pool.max-idle}")
    private Integer maxIdle;
    @Value("${spring.redis.jedis.pool.max-wait}")
    private Integer maxWait;
    @Value("${spring.redis.jedis.pool.min-idle}")
    private Integer minIdle;
    @Value("${spring.redis.timeout}")
    private Long timeout;


    @Bean
    public JedisConnectionFactory jedisConnectionFactory(RedisStandaloneConfiguration redisStandaloneConfiguration,
                                                         JedisClientConfiguration clientConfig) {
        return new JedisConnectionFactory(redisStandaloneConfiguration, clientConfig);
    }

    @Bean
    public RedisStandaloneConfiguration redisStandaloneConfiguration() {
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setDatabase(database);
        configuration.setHostName(host);
        configuration.setPassword(RedisPassword.of(password));
        configuration.setPort(port);
        return configuration;
    }


    @Bean
    public JedisClientConfiguration jedisClientConfiguration(JedisPoolConfig jedisPoolConfig){
        JedisClientConfiguration.JedisClientConfigurationBuilder builder = JedisClientConfiguration.builder();
        return builder.connectTimeout(Duration.of(timeout, ChronoUnit.MILLIS)).usePooling().poolConfig(jedisPoolConfig).build();
    }


    @Bean
    public JedisPoolConfig jedisPoolConfig(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(maxActive);
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMinIdle(minIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWait);
        return jedisPoolConfig;
    }
}
