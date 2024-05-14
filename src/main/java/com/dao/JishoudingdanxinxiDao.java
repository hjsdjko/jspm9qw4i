package com.dao;

import com.entity.JishoudingdanxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JishoudingdanxinxiVO;
import com.entity.view.JishoudingdanxinxiView;


/**
 * 急售订单信息
 * 
 * @author 
 * @email 
 * @date 2022-04-21 00:20:41
 */
public interface JishoudingdanxinxiDao extends BaseMapper<JishoudingdanxinxiEntity> {
	
	List<JishoudingdanxinxiVO> selectListVO(@Param("ew") Wrapper<JishoudingdanxinxiEntity> wrapper);
	
	JishoudingdanxinxiVO selectVO(@Param("ew") Wrapper<JishoudingdanxinxiEntity> wrapper);
	
	List<JishoudingdanxinxiView> selectListView(@Param("ew") Wrapper<JishoudingdanxinxiEntity> wrapper);

	List<JishoudingdanxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<JishoudingdanxinxiEntity> wrapper);
	
	JishoudingdanxinxiView selectView(@Param("ew") Wrapper<JishoudingdanxinxiEntity> wrapper);
	

}
