package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.DiscussershouxinxiEntity;
import com.entity.view.DiscussershouxinxiView;

import com.service.DiscussershouxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 二手信息评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2022-04-21 00:20:41
 */
@RestController
@RequestMapping("/discussershouxinxi")
public class DiscussershouxinxiController {
    @Autowired
    private DiscussershouxinxiService discussershouxinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussershouxinxiEntity discussershouxinxi, 
		HttpServletRequest request){

        EntityWrapper<DiscussershouxinxiEntity> ew = new EntityWrapper<DiscussershouxinxiEntity>();
    	PageUtils page = discussershouxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussershouxinxi), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussershouxinxiEntity discussershouxinxi, 
		HttpServletRequest request){
        EntityWrapper<DiscussershouxinxiEntity> ew = new EntityWrapper<DiscussershouxinxiEntity>();
    	PageUtils page = discussershouxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussershouxinxi), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussershouxinxiEntity discussershouxinxi){
       	EntityWrapper<DiscussershouxinxiEntity> ew = new EntityWrapper<DiscussershouxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussershouxinxi, "discussershouxinxi")); 
        return R.ok().put("data", discussershouxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussershouxinxiEntity discussershouxinxi){
        EntityWrapper< DiscussershouxinxiEntity> ew = new EntityWrapper< DiscussershouxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussershouxinxi, "discussershouxinxi")); 
		DiscussershouxinxiView discussershouxinxiView =  discussershouxinxiService.selectView(ew);
		return R.ok("查询二手信息评论表成功").put("data", discussershouxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussershouxinxiEntity discussershouxinxi = discussershouxinxiService.selectById(id);
        return R.ok().put("data", discussershouxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussershouxinxiEntity discussershouxinxi = discussershouxinxiService.selectById(id);
        return R.ok().put("data", discussershouxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussershouxinxiEntity discussershouxinxi, HttpServletRequest request){
    	discussershouxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussershouxinxi);

        discussershouxinxiService.insert(discussershouxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussershouxinxiEntity discussershouxinxi, HttpServletRequest request){
    	discussershouxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussershouxinxi);

        discussershouxinxiService.insert(discussershouxinxi);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DiscussershouxinxiEntity discussershouxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussershouxinxi);
        discussershouxinxiService.updateById(discussershouxinxi);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussershouxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<DiscussershouxinxiEntity> wrapper = new EntityWrapper<DiscussershouxinxiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = discussershouxinxiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	





}
