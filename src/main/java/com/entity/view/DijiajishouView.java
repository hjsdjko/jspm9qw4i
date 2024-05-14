package com.entity.view;

import com.entity.DijiajishouEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 低价急售
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-04-21 00:20:41
 */
@TableName("dijiajishou")
public class DijiajishouView  extends DijiajishouEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DijiajishouView(){
	}
 
 	public DijiajishouView(DijiajishouEntity dijiajishouEntity){
 	try {
			BeanUtils.copyProperties(this, dijiajishouEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
