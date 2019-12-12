package cn.bestsort.Service;

import cn.bestsort.TestVo;
import cn.bestsort.aop.Cache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author bestsort
 * @version 1.0
 * @date 12/12/19 10:13 AM
 */
@Service
@Slf4j
public class TestService {
    @Cache
    public TestVo getTest(TestVo vo){
        log.info("I'm in! {}",vo);
        TestVo.cnt ++;
        return vo;
    }
}
