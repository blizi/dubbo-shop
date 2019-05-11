package com.funtl.myshop.service.user.api;

import com.funtl.myshop.commons.domain.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface Userservice {
    List<User> selectAll();
    PageInfo<User> page(int pageNum, int pageSize);
}
