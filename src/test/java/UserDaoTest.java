import com.itheima.dao.IUserDao;
import com.itheima.domain.QueryVo;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class UserDaoTest {
    private IUserDao userDao;
    private InputStream in;
    private SqlSession sqlSession;
    //在junit测试之前执行
    @Before
    public void bofore() throws IOException {
        //获取文件流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder Builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = Builder.build(in);
        sqlSession = sqlSessionFactory.openSession();
       userDao = sqlSession.getMapper(IUserDao.class);
    }
@Test
        //查
    public void test() throws IOException {
    //执行查询方法
    User user = userDao.findByid(46);
    System.out.println(user);
    }
    @Test
    //增
    public void testSave(){
        User user = new User();
        user.setUsername("C罗");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("西班牙");
        System.out.println("保存之前:"+user);
        userDao.save(user);
        System.out.println("保存之后:"+user);
    }
    @Test
    //改
    public void testupdate(){
        User user = new User();
        user.setId(53);
        user.setAddress("葡萄牙");
        user.setSex("男");
        user.setBirthday(new Date());
        user.setUsername("C罗");
        userDao.update(user);
    }
    //删
    @Test
    public void testUpdate(){
        userDao.delete(53);
    }
    @Test
    //模糊查询
    public void testlike(){
        List<User> list = userDao.FindByUserNameLike("C%");
        System.out.println(list);
    }
    //条件查询
    @Test
    public void testByCondition(){
        QueryVo queryVo = new QueryVo();
        User user = new User();
        user.setAddress("西班牙");
        queryVo.setUser(user);
        queryVo.setStart(this.pareseDate("2018-07-08"));
        queryVo.setEnd(this.pareseDate("2018-07-10"));
        List<User> list = userDao.findByCondition(queryVo);
        System.out.println(list);
    }
    public Date pareseDate(String text){
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(text);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    //统计
    @Test
    public void count(){
        long count = userDao.count();
        System.out.println(count);
    }
    @After
    public void after(){
        if (in!=null){
            try {
                in.close();
                sqlSession.commit();
                sqlSession.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
