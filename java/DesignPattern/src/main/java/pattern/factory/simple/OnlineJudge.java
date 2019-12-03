package pattern.factory.simple;

/**
 * @ClassName OnlineJudge
 * @Description 现在有个OnlineJudge(在线测评平台),里面有很多算法题.OnlineJudge可以根据你提交的代码
 * 创建不同的运行环境并测试代码结果.你可以提交C/C++, Java, python等等一些语言.
 * @Author bestsort
 * @Date 2019/11/27 下午8:54
 * @Version 1.0
 */

public class OnlineJudge {
    private JudgeEnvironmentFactory factory = new JudgeEnvironmentFactory();
    /**
     * 用不同的测评机编程语言提交代码
     * @param language 提交的语言
     */
    public void judge(String language){
        JudgeEnvironment judgeEnvironment = factory.createJudgeEnvironment(language);
        judgeEnvironment.compareToResult();
        System.out.println("运行环境:"+judgeEnvironment.getLanguage());
    }
}
