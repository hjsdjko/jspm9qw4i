package com.entity.view;

import com.entity.JishoudingdanxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 急售订单信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-04-21 00:20:41
 */
@TableName("jishoudingdanxinxi")
public class JishoudingdanxinxiView  extends JishoudingdanxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JishoudingdanxinxiView(){
	}
 
 	public JishoudingdanxinxiView(JishoudingdanxinxiEntity jishoudingdanxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, jishoudingdanxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
