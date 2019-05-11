package com.funtl.myshop.service.user.provider.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.funtl.myshop.commons.domain.User;
import com.funtl.myshop.commons.mapper.UserMapper;
import com.funtl.myshop.service.user.api.Userservice;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


@Service(version = "${services.versions.user.v1}")
@Transactional(readOnly = true)
public class UserServiceImpl implements Userservice {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public PageInfo<User> page(int pageNum, int pageSize) {
        Example example = new Example(User.class);
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<User> pageInfo = new PageInfo<>(userMapper.selectByExample(example));
        return pageInfo;
    }
}
