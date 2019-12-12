package cn.bestsort.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author bestsort
 * @version 1.0
 * @date 12/12/19 10:04 AM
 */

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RedisServiceImpl implements RedisService {
        private final JedisPool jedisPool;
        @Override
        public Jedis getResource() throws Exception {
            return jedisPool.getResource();
        }

        @Override
        public void set(String key,String val,long time,String strategy) {
            Jedis jedis = null;
            try{
                jedis = getResource();
                jedis.set(key,val,strategy,"ex",time);
            }catch (Exception e){
                log.error("Redis set error:{}-{},value:{}", e.getMessage(), key, val);
            }finally {
                returnResource(jedis);
            }
        }

        @Override
        public void inc(String key, Long step) {
            Jedis jedis = null;
            try{
                jedis = getResource();
                jedis.incrBy(key, step);
            }catch (Exception e){
                log.error("Redis inc error:{}-{},value:{}", e.getMessage(), key, step);
            }finally {
                returnResource(jedis);
            }
        }

        @Override
        public String get(String key) {
            String result = null;
            Jedis jedis = null;
            try{
                jedis = getResource();
                result = jedis.get(key);
            }catch (Exception e){
                log.error("Redis set error:{}-{},value:{}",e.getMessage(),key,result);
            }finally {
                returnResource(jedis);
            }
            return result;
        }

        @Override
        public boolean containKey(String key) {
            Jedis jedis = null;
            try{
                jedis = getResource();
                return jedis.exists(key);
            }catch (Exception e){
                log.error("redis server error:{}",e.getMessage());
                return false;
            }finally {
                returnResource(jedis);
            }
        }

        @Override
        public void returnResource(Jedis jedis) {
            if (jedis != null){
                jedis.close();
            }
        }

        @Override
        public String getKeyForAop(JoinPoint joinPoint) {
            Object[] objects = joinPoint.getArgs();
            return joinPoint.getSignature().getName() + ":" + objects[0].toString();
        }
    }
