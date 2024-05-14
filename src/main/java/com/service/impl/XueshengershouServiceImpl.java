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


import com.dao.XueshengershouDao;
import com.entity.XueshengershouEntity;
import com.service.XueshengershouService;
import com.entity.vo.XueshengershouVO;
import com.entity.view.XueshengershouView;

@Service("xueshengershouService")
public class XueshengershouServiceImpl extends ServiceImpl<XueshengershouDao, XueshengershouEntity> implements XueshengershouService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XueshengershouEntity> page = this.selectPage(
                new Query<XueshengershouEntity>(params).getPage(),
                new EntityWrapper<XueshengershouEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XueshengershouEntity> wrapper) {
		  Page<XueshengershouView> page =new Query<XueshengershouView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<XueshengershouVO> selectListVO(Wrapper<XueshengershouEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XueshengershouVO selectVO(Wrapper<XueshengershouEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XueshengershouView> selectListView(Wrapper<XueshengershouEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XueshengershouView selectView(Wrapper<XueshengershouEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
