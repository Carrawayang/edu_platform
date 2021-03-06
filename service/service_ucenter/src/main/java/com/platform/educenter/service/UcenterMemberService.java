package com.platform.educenter.service;

import com.platform.educenter.entity.UcenterMember;
import com.baomidou.mybatisplus.extension.service.IService;
import com.platform.educenter.entity.vo.RegisterVo;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author yanwei
 * @since 2021-05-07
 */
public interface UcenterMemberService extends IService<UcenterMember> {
    //登录的方法
    String login(UcenterMember member);

    //注册的方法
    void register(RegisterVo registerVo);

    //根据openid判断
    UcenterMember getOpenIdMember(String openid);
}
