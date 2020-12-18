package com.zgl.controller;
import java.util.List;

import com.zgl.service.SixService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.zgl.pojo.TbSix;
import com.zgl.pojo.PageResult;
import com.zgl.pojo.Result;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/six")
public class SixController {

	@Reference
	private SixService sixService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbSix> findAll(){			
		return sixService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return sixService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param six
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody TbSix six){
		try {
			sixService.add(six);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param six
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody TbSix six){
		try {
			sixService.update(six);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改失败");
		}
	}	
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public TbSix findOne(Integer id){
		return sixService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(Integer [] ids){
		try {
			sixService.delete(ids);
			return new Result(true, "删除成功"); 
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	
		/**
	 * 查询+分页
	 * @param brand
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult search(@RequestBody TbSix six, int page, int rows  ){
		return sixService.findPage(six, page, rows);		
	}
	
}
