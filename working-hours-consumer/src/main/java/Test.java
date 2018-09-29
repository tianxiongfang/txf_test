import com.jd.api.model.RequestLogMQMsgModel;
import com.jd.consumer.config.MongoConfig;
import com.jd.consumer.service.EmailRepository;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2018/8/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={MongoConfig.class})
@FixMethodOrder
public class Test {
    @Autowired
    EmailRepository repository;

    @Before
    public void setup() {
        Set<String> roles=new HashSet<>();
        String str[]={"1","2","3","4"};
        roles.add("manage");
        RequestLogMQMsgModel requestLogMQMsgModel=new RequestLogMQMsgModel();
        requestLogMQMsgModel.setCostTime(1);
        requestLogMQMsgModel.setMethodName("txf");
        requestLogMQMsgModel.setParamNames(str);
        requestLogMQMsgModel.setRemoteAddr("1012944504@qq.com");
        requestLogMQMsgModel.setParamTypes(str);
        requestLogMQMsgModel.setParamValues(str);
        requestLogMQMsgModel.setRequestMethod("1");
        requestLogMQMsgModel.setRequestURI("1111");
        requestLogMQMsgModel.setUserEmail("101294450@qq.com");

        //SysUser sysUser=new SysUser("1", "hlhdidi", "123", "xiaohulong", "email@com.cn", new Date(), roles);
        repository.save(requestLogMQMsgModel);
    }
    @org.junit.Test
    public void findAll() {
        List<RequestLogMQMsgModel> users=repository.findAll();
       // List<SysUser> users=repository.findAll();
     for(RequestLogMQMsgModel user:users) {
            System.out.println(user.getRemoteAddr());
      }
    }
}
