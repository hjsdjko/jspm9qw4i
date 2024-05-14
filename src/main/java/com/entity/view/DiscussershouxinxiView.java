package com.entity.view;

import com.entity.DiscussershouxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 二手信息评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-04-21 00:20:41
 */
@TableName("discussershouxinxi")
public class DiscussershouxinxiView  extends DiscussershouxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussershouxinxiView(){
	}
 
 	public DiscussershouxinxiView(DiscussershouxinxiEntity discussershouxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, discussershouxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
