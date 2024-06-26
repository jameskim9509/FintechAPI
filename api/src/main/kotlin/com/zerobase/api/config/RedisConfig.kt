package com.zerobase.api.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.cache.CacheManager
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.cache.RedisCacheConfiguration
import org.springframework.data.redis.cache.RedisCacheManager
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.serializer.RedisSerializationContext
import org.springframework.data.redis.serializer.StringRedisSerializer
import java.time.Duration

@Configuration
@EnableCaching
class RedisConfig {
    @Value("\${spring.redis.host}")
    lateinit var host: String

    @Value("\${spring.redis.port}")
    lateinit var port: String

    @Bean
    fun redisConnectionFactory(): RedisConnectionFactory
    {
        return LettuceConnectionFactory(host, port.toInt())
    }

    @Bean
    fun redisCacheManager(cacheFactory: RedisConnectionFactory): CacheManager
    {
        val redisCacheConfig = RedisCacheConfiguration.defaultCacheConfig()
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(StringRedisSerializer()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(StringRedisSerializer()))
                .entryTtl(Duration.ofMinutes(10))

        return RedisCacheManager
                .RedisCacheManagerBuilder
                .fromConnectionFactory(cacheFactory)
                .cacheDefaults(redisCacheConfig)
                .build()
    }
}