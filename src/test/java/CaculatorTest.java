import com.xian.Annotation.Caculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CaculatorTest {
    @Test
    public void testAdd(){
        //1、创建计算器对象
        Caculator ct = new Caculator();
        //2、调用add()方法
//        int result = ct.add();
//        System.out.println(result);
        //3、断言    我断言这个结果是581
//        Assert.assertEquals(result,581);
    }
    @Test
    public void testSub(){
        //1、创建计算器对象
        Caculator ct = new Caculator();
        //2、调用add()方法
        int result = 0;
        System.out.println(result);
        //3、断言    我断言这个结果是581
        Assert.assertEquals(result,-331);
    }

    /**
     * 初始化方法：
     *  用于资源的申请,所有测试方法在执行前都会先执行该方法
     */
    @Before
    public void init(){
        System.out.println("init方法已开始执行！");
    }

    /**
     * 释放资源方法：
     *  在所有测试方法执行完成后，都会自动执行该方法
     */
    @After
    public void close(){
        System.out.println("close方法已执行...");
        Object ob = new Object();
    }
}
