import com.xian.Annotation.Caculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CaculatorTest {
    @Test
    public void testAdd(){
        //1����������������
        Caculator ct = new Caculator();
        //2������add()����
//        int result = ct.add();
//        System.out.println(result);
        //3������    �Ҷ�����������581
//        Assert.assertEquals(result,581);
    }
    @Test
    public void testSub(){
        //1����������������
        Caculator ct = new Caculator();
        //2������add()����
        int result = 0;
        System.out.println(result);
        //3������    �Ҷ�����������581
        Assert.assertEquals(result,-331);
    }

    /**
     * ��ʼ��������
     *  ������Դ������,���в��Է�����ִ��ǰ������ִ�и÷���
     */
    @Before
    public void init(){
        System.out.println("init�����ѿ�ʼִ�У�");
    }

    /**
     * �ͷ���Դ������
     *  �����в��Է���ִ����ɺ󣬶����Զ�ִ�и÷���
     */
    @After
    public void close(){
        System.out.println("close������ִ��...");
        Object ob = new Object();
    }
}
