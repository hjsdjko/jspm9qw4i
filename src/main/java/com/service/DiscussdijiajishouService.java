package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussdijiajishouEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussdijiajishouVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussdijiajishouView;


/**
 * 低价急售评论表
 *
 * @author 
 * @email 
 * @date 2022-04-21 00:20:41
 */
public interface DiscussdijiajishouService extends IService<DiscussdijiajishouEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussdijiajishouVO> selectListVO(Wrapper<DiscussdijiajishouEntity> wrapper);
   	
   	DiscussdijiajishouVO selectVO(@Param("ew") Wrapper<DiscussdijiajishouEntity> wrapper);
   	
   	List<DiscussdijiajishouView> selectListView(Wrapper<DiscussdijiajishouEntity> wrapper);
   	
   	DiscussdijiajishouView selectView(@Param("ew") Wrapper<DiscussdijiajishouEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussdijiajishouEntity> wrapper);
   	

}

