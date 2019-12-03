import org.junit.Test;
import pattern.factory.simple.JudgeEnvironmentFactory;
import pattern.factory.simple.OnlineJudge;


/**
 * @ClassName FactoryTest
 * @Description 简单工厂模式
 * @Author bestsort
 * @Date 2019/11/27 下午9:25
 * @Version 1.0
 */
public class FactoryTest {
    @Test
    public void test(){
        new OnlineJudge().judge(JudgeEnvironmentFactory.JAVA);
    }
}
