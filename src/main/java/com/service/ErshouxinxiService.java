package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ErshouxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ErshouxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ErshouxinxiView;


/**
 * 二手信息
 *
 * @author 
 * @email 
 * @date 2022-04-21 00:20:40
 */
public interface ErshouxinxiService extends IService<ErshouxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ErshouxinxiVO> selectListVO(Wrapper<ErshouxinxiEntity> wrapper);
   	
   	ErshouxinxiVO selectVO(@Param("ew") Wrapper<ErshouxinxiEntity> wrapper);
   	
   	List<ErshouxinxiView> selectListView(Wrapper<ErshouxinxiEntity> wrapper);
   	
   	ErshouxinxiView selectView(@Param("ew") Wrapper<ErshouxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ErshouxinxiEntity> wrapper);
   	

}

