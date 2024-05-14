package com.dao;

import com.entity.XueshengershouEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XueshengershouVO;
import com.entity.view.XueshengershouView;


/**
 * 学生二手
 * 
 * @author 
 * @email 
 * @date 2022-04-21 00:20:40
 */
public interface XueshengershouDao extends BaseMapper<XueshengershouEntity> {
	
	List<XueshengershouVO> selectListVO(@Param("ew") Wrapper<XueshengershouEntity> wrapper);
	
	XueshengershouVO selectVO(@Param("ew") Wrapper<XueshengershouEntity> wrapper);
	
	List<XueshengershouView> selectListView(@Param("ew") Wrapper<XueshengershouEntity> wrapper);

	List<XueshengershouView> selectListView(Pagination page,@Param("ew") Wrapper<XueshengershouEntity> wrapper);
	
	XueshengershouView selectView(@Param("ew") Wrapper<XueshengershouEntity> wrapper);
	

}
