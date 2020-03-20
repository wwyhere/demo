package com.wwy.admin.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configuration
public class RedisConfig {

    @Value("${spring.redis.sentinel.nodes}")
    private String sentinelNodes;

    @Value("${spring.redis.password}")
    private String password;

    @Value("${spring.redis.pool.max-idle}")
    private Integer maxIdle;
    @Value("${spring.redis.pool.min-idle}")
    private Integer minIdle;
    @Value("${spring.redis.pool.max-wait}")
    private Integer maxWait;
    @Value("${spring.redis.pool.max-active}")
    private Integer maxActive;
    @Value("${spring.redis.timeout}")
    private Integer timeout;
    @Value("${spring.redis.master}")
    private String master;

    @Bean(name = "jedisPoolConfig")
    public JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(maxIdle);
        config.setMaxTotal(maxActive);
        config.setMaxWaitMillis(maxWait);
        config.setMinIdle(minIdle);
        config.setTestOnBorrow(true);
        config.setTestWhileIdle(true);
        config.setNumTestsPerEvictionRun(2);
        config.setTimeBetweenEvictionRunsMillis(30000);
        config.setMinEvictableIdleTimeMillis(60000);
        config.setSoftMinEvictableIdleTimeMillis(60000);
        return config;
    }

    @Bean(name = "redisSentinelConfiguration")
    public RedisSentinelConfiguration getRedisSentinelConfiguration() {
        RedisSentinelConfiguration redisSentinelConfiguration = new RedisSentinelConfiguration();
        //配置redis的sentinel
        Set<RedisNode> redisNodeSet = new HashSet<>();

        List<String> nodes = Lists.newArrayList(sentinelNodes.split(","));
        if (nodes != null && nodes.size() > 0) {
            nodes.forEach(redisNode -> {
                String[] split = redisNode.split(":");
                RedisNode redisNodes = new RedisNode(split[0], Integer.parseInt(split[1]));
                redisNodeSet.add(redisNodes);
            });
        }
        redisSentinelConfiguration.setSentinels(redisNodeSet);
        redisSentinelConfiguration.setMaster(master);
        return redisSentinelConfiguration;

    }

    @Bean(name = "jedisConnectionFactory")
    public JedisConnectionFactory redisConnectionFactory(@Qualifier("redisSentinelConfiguration") RedisSentinelConfiguration redisSentinelConfiguration,
                                                         @Qualifier("jedisPoolConfig") JedisPoolConfig jedisPoolConfig) {
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(redisSentinelConfiguration, jedisPoolConfig);
        jedisConnectionFactory.setPassword(password);
        jedisConnectionFactory.setTimeout(timeout);
        jedisConnectionFactory.setUsePool(true);
        return jedisConnectionFactory;
    }


    @Bean
    public RedisTemplate<String, Object> redisTemplate(@Qualifier("jedisConnectionFactory") JedisConnectionFactory jedisConnectionFactory) {
//        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
//        ObjectMapper om = new ObjectMapper();
//        SimpleModule simpleModule = new SimpleModule();
//        om.registerModule(simpleModule);
//        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);
//        jackson2JsonRedisSerializer.setObjectMapper(om);
        RedisTemplate<String, Object> template = new RedisTemplate();
        template.setConnectionFactory(jedisConnectionFactory);
//        template.setKeySerializer(jackson2JsonRedisSerializer);
//        template.setValueSerializer(jackson2JsonRedisSerializer);
//        template.setHashKeySerializer(jackson2JsonRedisSerializer);
//        template.setHashValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }

}