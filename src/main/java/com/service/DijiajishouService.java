package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DijiajishouEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DijiajishouVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DijiajishouView;


/**
 * 低价急售
 *
 * @author 
 * @email 
 * @date 2022-04-21 00:20:41
 */
public interface DijiajishouService extends IService<DijiajishouEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DijiajishouVO> selectListVO(Wrapper<DijiajishouEntity> wrapper);
   	
   	DijiajishouVO selectVO(@Param("ew") Wrapper<DijiajishouEntity> wrapper);
   	
   	List<DijiajishouView> selectListView(Wrapper<DijiajishouEntity> wrapper);
   	
   	DijiajishouView selectView(@Param("ew") Wrapper<DijiajishouEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DijiajishouEntity> wrapper);
   	

}

