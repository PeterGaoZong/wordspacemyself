package com.zgl.controller;
import java.util.List;

import com.zgl.service.NineService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.zgl.pojo.TbNine;
import com.zgl.pojo.PageResult;
import com.zgl.pojo.Result;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/nine")
public class NineController {

	@Reference
	private NineService nineService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbNine> findAll(){			
		return nineService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return nineService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param nine
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody TbNine nine){
		try {
			nineService.add(nine);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param nine
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody TbNine nine){
		try {
			nineService.update(nine);
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
	public TbNine findOne(Integer id){
		return nineService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(Integer [] ids){
		try {
			nineService.delete(ids);
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
	public PageResult search(@RequestBody TbNine nine, int page, int rows  ){
		return nineService.findPage(nine, page, rows);		
	}
	
}
