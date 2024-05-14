package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XueshengershouEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XueshengershouVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XueshengershouView;


/**
 * 学生二手
 *
 * @author 
 * @email 
 * @date 2022-04-21 00:20:40
 */
public interface XueshengershouService extends IService<XueshengershouEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XueshengershouVO> selectListVO(Wrapper<XueshengershouEntity> wrapper);
   	
   	XueshengershouVO selectVO(@Param("ew") Wrapper<XueshengershouEntity> wrapper);
   	
   	List<XueshengershouView> selectListView(Wrapper<XueshengershouEntity> wrapper);
   	
   	XueshengershouView selectView(@Param("ew") Wrapper<XueshengershouEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XueshengershouEntity> wrapper);
   	

}

