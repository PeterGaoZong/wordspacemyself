package com.zgl.controller;
import java.util.List;

import com.zgl.pojo.TbEight;
import com.zgl.service.EightService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.zgl.pojo.PageResult;
import com.zgl.pojo.Result;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/eight")
public class EightController {

	@Reference
	private EightService eightService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbEight> findAll(){
		return eightService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return eightService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param eight
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody TbEight eight){
		try {
			eightService.add(eight);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param eight
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody TbEight eight){
		try {
			eightService.update(eight);
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
	public TbEight findOne(Integer id){
		return eightService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(Integer [] ids){
		try {
			eightService.delete(ids);
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
	public PageResult search(@RequestBody TbEight eight, int page, int rows  ){
		return eightService.findPage(eight, page, rows);		
	}
	
}
