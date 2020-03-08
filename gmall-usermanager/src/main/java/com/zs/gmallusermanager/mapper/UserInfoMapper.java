package com.zs.gmallusermanager.mapper;

import com.zs.gmallusermanager.bean.UserInfo;
import tk.mybatis.mapper.common.Mapper;

// 泛型规定：看你是操作的哪个实体类！ 数据访问层
public interface UserInfoMapper extends Mapper<UserInfo> {
}
