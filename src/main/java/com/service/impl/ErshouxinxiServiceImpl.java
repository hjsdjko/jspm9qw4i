package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ErshouxinxiDao;
import com.entity.ErshouxinxiEntity;
import com.service.ErshouxinxiService;
import com.entity.vo.ErshouxinxiVO;
import com.entity.view.ErshouxinxiView;

@Service("ershouxinxiService")
public class ErshouxinxiServiceImpl extends ServiceImpl<ErshouxinxiDao, ErshouxinxiEntity> implements ErshouxinxiService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ErshouxinxiEntity> page = this.selectPage(
                new Query<ErshouxinxiEntity>(params).getPage(),
                new EntityWrapper<ErshouxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ErshouxinxiEntity> wrapper) {
		  Page<ErshouxinxiView> page =new Query<ErshouxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ErshouxinxiVO> selectListVO(Wrapper<ErshouxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ErshouxinxiVO selectVO(Wrapper<ErshouxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ErshouxinxiView> selectListView(Wrapper<ErshouxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ErshouxinxiView selectView(Wrapper<ErshouxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
