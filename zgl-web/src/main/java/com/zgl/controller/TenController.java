package com.zgl.controller;
import java.util.List;

import com.zgl.service.TenService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.zgl.pojo.TbTen;
import com.zgl.pojo.PageResult;
import com.zgl.pojo.Result;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/ten")
public class TenController {

	@Reference
	private TenService tenService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbTen> findAll(){			
		return tenService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return tenService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param ten
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody TbTen ten){
		try {
			tenService.add(ten);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param ten
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody TbTen ten){
		try {
			tenService.update(ten);
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
	public TbTen findOne(Integer id){
		return tenService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(Integer [] ids){
		try {
			tenService.delete(ids);
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
	public PageResult search(@RequestBody TbTen ten, int page, int rows  ){
		return tenService.findPage(ten, page, rows);		
	}
	
}
