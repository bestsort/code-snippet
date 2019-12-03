package pattern.factory.simple;

/**
 * @ClassName JudgeEnvironment
 * @Description 测试环境,运行python需要python环境,运行Java需要Java环境
 * @Author bestsort
 * @Date 2019/11/27 下午9:02
 * @Version 1.0
 */

class JudgeEnvironment {
    String language;
    /**
     * 运行完毕后对比输出和答案
     * @return
     */
    void compareToResult(){
        System.out.println("比对答案中...");
    }

    String getLanguage(){
        return language;
    }
}
