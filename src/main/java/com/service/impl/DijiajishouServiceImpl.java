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


import com.dao.DijiajishouDao;
import com.entity.DijiajishouEntity;
import com.service.DijiajishouService;
import com.entity.vo.DijiajishouVO;
import com.entity.view.DijiajishouView;

@Service("dijiajishouService")
public class DijiajishouServiceImpl extends ServiceImpl<DijiajishouDao, DijiajishouEntity> implements DijiajishouService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DijiajishouEntity> page = this.selectPage(
                new Query<DijiajishouEntity>(params).getPage(),
                new EntityWrapper<DijiajishouEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DijiajishouEntity> wrapper) {
		  Page<DijiajishouView> page =new Query<DijiajishouView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DijiajishouVO> selectListVO(Wrapper<DijiajishouEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DijiajishouVO selectVO(Wrapper<DijiajishouEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DijiajishouView> selectListView(Wrapper<DijiajishouEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DijiajishouView selectView(Wrapper<DijiajishouEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
