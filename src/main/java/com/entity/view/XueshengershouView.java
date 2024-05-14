package com.entity.view;

import com.entity.XueshengershouEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 学生二手
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-04-21 00:20:40
 */
@TableName("xueshengershou")
public class XueshengershouView  extends XueshengershouEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public XueshengershouView(){
	}
 
 	public XueshengershouView(XueshengershouEntity xueshengershouEntity){
 	try {
			BeanUtils.copyProperties(this, xueshengershouEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
