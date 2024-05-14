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


import com.dao.JishoudingdanxinxiDao;
import com.entity.JishoudingdanxinxiEntity;
import com.service.JishoudingdanxinxiService;
import com.entity.vo.JishoudingdanxinxiVO;
import com.entity.view.JishoudingdanxinxiView;

@Service("jishoudingdanxinxiService")
public class JishoudingdanxinxiServiceImpl extends ServiceImpl<JishoudingdanxinxiDao, JishoudingdanxinxiEntity> implements JishoudingdanxinxiService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JishoudingdanxinxiEntity> page = this.selectPage(
                new Query<JishoudingdanxinxiEntity>(params).getPage(),
                new EntityWrapper<JishoudingdanxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JishoudingdanxinxiEntity> wrapper) {
		  Page<JishoudingdanxinxiView> page =new Query<JishoudingdanxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<JishoudingdanxinxiVO> selectListVO(Wrapper<JishoudingdanxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JishoudingdanxinxiVO selectVO(Wrapper<JishoudingdanxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JishoudingdanxinxiView> selectListView(Wrapper<JishoudingdanxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JishoudingdanxinxiView selectView(Wrapper<JishoudingdanxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
