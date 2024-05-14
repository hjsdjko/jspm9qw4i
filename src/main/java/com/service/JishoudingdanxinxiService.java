package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JishoudingdanxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JishoudingdanxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JishoudingdanxinxiView;


/**
 * 急售订单信息
 *
 * @author 
 * @email 
 * @date 2022-04-21 00:20:41
 */
public interface JishoudingdanxinxiService extends IService<JishoudingdanxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JishoudingdanxinxiVO> selectListVO(Wrapper<JishoudingdanxinxiEntity> wrapper);
   	
   	JishoudingdanxinxiVO selectVO(@Param("ew") Wrapper<JishoudingdanxinxiEntity> wrapper);
   	
   	List<JishoudingdanxinxiView> selectListView(Wrapper<JishoudingdanxinxiEntity> wrapper);
   	
   	JishoudingdanxinxiView selectView(@Param("ew") Wrapper<JishoudingdanxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JishoudingdanxinxiEntity> wrapper);
   	

}

