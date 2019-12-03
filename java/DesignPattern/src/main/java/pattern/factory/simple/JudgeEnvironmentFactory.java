package pattern.factory.simple;

/**
 * @ClassName JudgeEnvironmentFactory
 * @Description 环境通过工厂模式构建,OnlineJudge只负责测评结果.这样一来可降低OnlineJudge和JudgeEnvironment的耦合度.
 * 在以后需要添加/移除新的编程语言时也会更方便
 * @Author bestsort
 * @Date 2019/11/27 下午9:14
 * @Version 1.0
 */

public class JudgeEnvironmentFactory {
    public static final String CPLUSPLUS = "C++";
    public static final String JAVA = "Java";
    JudgeEnvironment createJudgeEnvironment(String language){
        JudgeEnvironment judgeEnvironment = null;
        if (language.equals(CPLUSPLUS)){
            judgeEnvironment = new CPlusPlusJudgeEnvironment();
        }else if (language.equals(JAVA)){
            judgeEnvironment = new JavaJudgeEnvironment();
        }
        return judgeEnvironment;
    }
}
