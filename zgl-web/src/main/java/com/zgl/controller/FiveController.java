package com.zgl.controller;
import java.util.List;

import com.zgl.service.FiveService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.zgl.pojo.TbFive;
import com.zgl.pojo.PageResult;
import com.zgl.pojo.Result;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/five")
public class FiveController {

	@Reference
	private FiveService fiveService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbFive> findAll(){			
		return fiveService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return fiveService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param five
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody TbFive five){
		try {
			fiveService.add(five);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param five
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody TbFive five){
		try {
			fiveService.update(five);
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
	public TbFive findOne(Integer id){
		return fiveService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(Integer [] ids){
		try {
			fiveService.delete(ids);
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
	public PageResult search(@RequestBody TbFive five, int page, int rows  ){
		return fiveService.findPage(five, page, rows);		
	}
	
}
