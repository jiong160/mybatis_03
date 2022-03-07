import mapper.UserMapper;
import model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test {
    @org.junit.Test
    public void Testmybatis_03(){
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
            SqlSessionFactory build = sqlSessionFactoryBuilder.build(resourceAsStream);
            SqlSession sqlSession = build.openSession(true);
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> users = mapper.selectByExample(null);
            System.out.println(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
