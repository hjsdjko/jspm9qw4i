package com.dao;

import com.entity.DiscussershouxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussershouxinxiVO;
import com.entity.view.DiscussershouxinxiView;


/**
 * 二手信息评论表
 * 
 * @author 
 * @email 
 * @date 2022-04-21 00:20:41
 */
public interface DiscussershouxinxiDao extends BaseMapper<DiscussershouxinxiEntity> {
	
	List<DiscussershouxinxiVO> selectListVO(@Param("ew") Wrapper<DiscussershouxinxiEntity> wrapper);
	
	DiscussershouxinxiVO selectVO(@Param("ew") Wrapper<DiscussershouxinxiEntity> wrapper);
	
	List<DiscussershouxinxiView> selectListView(@Param("ew") Wrapper<DiscussershouxinxiEntity> wrapper);

	List<DiscussershouxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussershouxinxiEntity> wrapper);
	
	DiscussershouxinxiView selectView(@Param("ew") Wrapper<DiscussershouxinxiEntity> wrapper);
	

}
