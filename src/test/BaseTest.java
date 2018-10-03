import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 陈简君
 * @date 2018/10/3 21:15
 *
 * 用来配置spring和junit整合，junit启动时加载springIOV容器
 */

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件在哪
@ContextConfiguration({"spring/spring-dao.xml"})
public class BaseTest {
}
