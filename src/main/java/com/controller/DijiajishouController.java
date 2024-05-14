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

import com.entity.DijiajishouEntity;
import com.entity.view.DijiajishouView;

import com.service.DijiajishouService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 低价急售
 * 后端接口
 * @author 
 * @email 
 * @date 2022-04-21 00:20:41
 */
@RestController
@RequestMapping("/dijiajishou")
public class DijiajishouController {
    @Autowired
    private DijiajishouService dijiajishouService;


    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DijiajishouEntity dijiajishou, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xueshengershou")) {
			dijiajishou.setXueshengzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<DijiajishouEntity> ew = new EntityWrapper<DijiajishouEntity>();
    	PageUtils page = dijiajishouService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dijiajishou), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DijiajishouEntity dijiajishou, 
		HttpServletRequest request){
        EntityWrapper<DijiajishouEntity> ew = new EntityWrapper<DijiajishouEntity>();
    	PageUtils page = dijiajishouService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dijiajishou), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DijiajishouEntity dijiajishou){
       	EntityWrapper<DijiajishouEntity> ew = new EntityWrapper<DijiajishouEntity>();
      	ew.allEq(MPUtil.allEQMapPre( dijiajishou, "dijiajishou")); 
        return R.ok().put("data", dijiajishouService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DijiajishouEntity dijiajishou){
        EntityWrapper< DijiajishouEntity> ew = new EntityWrapper< DijiajishouEntity>();
 		ew.allEq(MPUtil.allEQMapPre( dijiajishou, "dijiajishou")); 
		DijiajishouView dijiajishouView =  dijiajishouService.selectView(ew);
		return R.ok("查询低价急售成功").put("data", dijiajishouView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DijiajishouEntity dijiajishou = dijiajishouService.selectById(id);
        return R.ok().put("data", dijiajishou);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DijiajishouEntity dijiajishou = dijiajishouService.selectById(id);
        return R.ok().put("data", dijiajishou);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        DijiajishouEntity dijiajishou = dijiajishouService.selectById(id);
        if(type.equals("1")) {
        	dijiajishou.setThumbsupnum(dijiajishou.getThumbsupnum()+1);
        } else {
        	dijiajishou.setCrazilynum(dijiajishou.getCrazilynum()+1);
        }
        dijiajishouService.updateById(dijiajishou);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DijiajishouEntity dijiajishou, HttpServletRequest request){
    	dijiajishou.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(dijiajishou);

        dijiajishouService.insert(dijiajishou);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
	@IgnoreAuth
    @RequestMapping("/add")
    public R add(@RequestBody DijiajishouEntity dijiajishou, HttpServletRequest request){
    	dijiajishou.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(dijiajishou);

        dijiajishouService.insert(dijiajishou);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DijiajishouEntity dijiajishou, HttpServletRequest request){
        //ValidatorUtils.validateEntity(dijiajishou);
        dijiajishouService.updateById(dijiajishou);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        dijiajishouService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<DijiajishouEntity> wrapper = new EntityWrapper<DijiajishouEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xueshengershou")) {
			wrapper.eq("xueshengzhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = dijiajishouService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	





}
