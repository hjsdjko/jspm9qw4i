package com.dao;

import com.entity.ErshouxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ErshouxinxiVO;
import com.entity.view.ErshouxinxiView;


/**
 * 二手信息
 * 
 * @author 
 * @email 
 * @date 2022-04-21 00:20:40
 */
public interface ErshouxinxiDao extends BaseMapper<ErshouxinxiEntity> {
	
	List<ErshouxinxiVO> selectListVO(@Param("ew") Wrapper<ErshouxinxiEntity> wrapper);
	
	ErshouxinxiVO selectVO(@Param("ew") Wrapper<ErshouxinxiEntity> wrapper);
	
	List<ErshouxinxiView> selectListView(@Param("ew") Wrapper<ErshouxinxiEntity> wrapper);

	List<ErshouxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<ErshouxinxiEntity> wrapper);
	
	ErshouxinxiView selectView(@Param("ew") Wrapper<ErshouxinxiEntity> wrapper);
	

}
