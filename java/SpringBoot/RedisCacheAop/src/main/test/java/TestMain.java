import cn.bestsort.Service.TestService;
import cn.bestsort.StartUpApplication;
import cn.bestsort.TestVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author bestsort
 * @version 1.0
 * @date 12/12/19 10:09 AM
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = StartUpApplication.class)
public class TestMain {
    @Autowired
    TestService service;
    @Test
    public void Test(){
        TestVo vo = new TestVo();
        vo.setPassword("passwd");
        vo.setAccount("account");
        vo.setMail("mail");
        for (int i = 0; i < 100; i++) {
            service.getTest(vo);
        }
        assert TestVo.cnt <= 1;
    }
}
