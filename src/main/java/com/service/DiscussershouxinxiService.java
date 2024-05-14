package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussershouxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussershouxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussershouxinxiView;


/**
 * 二手信息评论表
 *
 * @author 
 * @email 
 * @date 2022-04-21 00:20:41
 */
public interface DiscussershouxinxiService extends IService<DiscussershouxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussershouxinxiVO> selectListVO(Wrapper<DiscussershouxinxiEntity> wrapper);
   	
   	DiscussershouxinxiVO selectVO(@Param("ew") Wrapper<DiscussershouxinxiEntity> wrapper);
   	
   	List<DiscussershouxinxiView> selectListView(Wrapper<DiscussershouxinxiEntity> wrapper);
   	
   	DiscussershouxinxiView selectView(@Param("ew") Wrapper<DiscussershouxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussershouxinxiEntity> wrapper);
   	

}

