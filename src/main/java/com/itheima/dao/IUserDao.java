package com.itheima.dao;

import com.itheima.domain.QueryVo;
import com.itheima.domain.User;

import java.util.List;

public interface IUserDao {
    //查找
    User findByid(int id);
    //存数据
    void save(User user);
    //修改数据
    void update(User user);
    //删除操作
    void  delete(int id);
    //模糊查询
    List<User> FindByUserNameLike(String username);
    //条件查询
    List<User> findByCondition(QueryVo queryVo);
    //统计
    long count();
}
