package com.dao;

import com.entity.DiscussdijiajishouEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussdijiajishouVO;
import com.entity.view.DiscussdijiajishouView;


/**
 * 低价急售评论表
 * 
 * @author 
 * @email 
 * @date 2022-04-21 00:20:41
 */
public interface DiscussdijiajishouDao extends BaseMapper<DiscussdijiajishouEntity> {
	
	List<DiscussdijiajishouVO> selectListVO(@Param("ew") Wrapper<DiscussdijiajishouEntity> wrapper);
	
	DiscussdijiajishouVO selectVO(@Param("ew") Wrapper<DiscussdijiajishouEntity> wrapper);
	
	List<DiscussdijiajishouView> selectListView(@Param("ew") Wrapper<DiscussdijiajishouEntity> wrapper);

	List<DiscussdijiajishouView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussdijiajishouEntity> wrapper);
	
	DiscussdijiajishouView selectView(@Param("ew") Wrapper<DiscussdijiajishouEntity> wrapper);
	

}
