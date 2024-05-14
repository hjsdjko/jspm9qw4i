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


import com.dao.DiscussdijiajishouDao;
import com.entity.DiscussdijiajishouEntity;
import com.service.DiscussdijiajishouService;
import com.entity.vo.DiscussdijiajishouVO;
import com.entity.view.DiscussdijiajishouView;

@Service("discussdijiajishouService")
public class DiscussdijiajishouServiceImpl extends ServiceImpl<DiscussdijiajishouDao, DiscussdijiajishouEntity> implements DiscussdijiajishouService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussdijiajishouEntity> page = this.selectPage(
                new Query<DiscussdijiajishouEntity>(params).getPage(),
                new EntityWrapper<DiscussdijiajishouEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussdijiajishouEntity> wrapper) {
		  Page<DiscussdijiajishouView> page =new Query<DiscussdijiajishouView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussdijiajishouVO> selectListVO(Wrapper<DiscussdijiajishouEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussdijiajishouVO selectVO(Wrapper<DiscussdijiajishouEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussdijiajishouView> selectListView(Wrapper<DiscussdijiajishouEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussdijiajishouView selectView(Wrapper<DiscussdijiajishouEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
