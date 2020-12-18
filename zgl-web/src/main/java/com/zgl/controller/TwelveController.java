package com.zgl.controller;
import java.util.List;

import com.zgl.service.TwelveService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.zgl.pojo.TbTwelve;
import com.zgl.pojo.PageResult;
import com.zgl.pojo.Result;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/twelve")
public class TwelveController {

	@Reference
	private TwelveService twelveService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbTwelve> findAll(){			
		return twelveService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return twelveService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param twelve
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody TbTwelve twelve){
		try {
			twelveService.add(twelve);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param twelve
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody TbTwelve twelve){
		try {
			twelveService.update(twelve);
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
	public TbTwelve findOne(Integer id){
		return twelveService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(Integer [] ids){
		try {
			twelveService.delete(ids);
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
	public PageResult search(@RequestBody TbTwelve twelve, int page, int rows  ){
		return twelveService.findPage(twelve, page, rows);		
	}
	
}
