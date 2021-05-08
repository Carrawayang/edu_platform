package com.platform.eduservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.platform.eduservice.entity.frontvo.CrmBanner;

import java.util.List;

public interface CrmBannerService extends IService<CrmBanner> {

    //查询所有banner
    List<CrmBanner> selectAllBanner();
}
