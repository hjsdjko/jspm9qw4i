package com.dao;

import com.entity.DijiajishouEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DijiajishouVO;
import com.entity.view.DijiajishouView;


/**
 * 低价急售
 * 
 * @author 
 * @email 
 * @date 2022-04-21 00:20:41
 */
public interface DijiajishouDao extends BaseMapper<DijiajishouEntity> {
	
	List<DijiajishouVO> selectListVO(@Param("ew") Wrapper<DijiajishouEntity> wrapper);
	
	DijiajishouVO selectVO(@Param("ew") Wrapper<DijiajishouEntity> wrapper);
	
	List<DijiajishouView> selectListView(@Param("ew") Wrapper<DijiajishouEntity> wrapper);

	List<DijiajishouView> selectListView(Pagination page,@Param("ew") Wrapper<DijiajishouEntity> wrapper);
	
	DijiajishouView selectView(@Param("ew") Wrapper<DijiajishouEntity> wrapper);
	

}
