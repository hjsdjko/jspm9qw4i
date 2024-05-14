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


import com.dao.DiscussershouxinxiDao;
import com.entity.DiscussershouxinxiEntity;
import com.service.DiscussershouxinxiService;
import com.entity.vo.DiscussershouxinxiVO;
import com.entity.view.DiscussershouxinxiView;

@Service("discussershouxinxiService")
public class DiscussershouxinxiServiceImpl extends ServiceImpl<DiscussershouxinxiDao, DiscussershouxinxiEntity> implements DiscussershouxinxiService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussershouxinxiEntity> page = this.selectPage(
                new Query<DiscussershouxinxiEntity>(params).getPage(),
                new EntityWrapper<DiscussershouxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussershouxinxiEntity> wrapper) {
		  Page<DiscussershouxinxiView> page =new Query<DiscussershouxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussershouxinxiVO> selectListVO(Wrapper<DiscussershouxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussershouxinxiVO selectVO(Wrapper<DiscussershouxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussershouxinxiView> selectListView(Wrapper<DiscussershouxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussershouxinxiView selectView(Wrapper<DiscussershouxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
