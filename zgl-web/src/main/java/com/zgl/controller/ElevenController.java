package com.zgl.controller;
import java.util.List;

import com.zgl.service.ElevenService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.zgl.pojo.TbEleven;
import com.zgl.pojo.PageResult;
import com.zgl.pojo.Result;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/eleven")
public class ElevenController {

	@Reference
	private ElevenService elevenService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbEleven> findAll(){			
		return elevenService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return elevenService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param eleven
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody TbEleven eleven){
		try {
			elevenService.add(eleven);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param eleven
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody TbEleven eleven){
		try {
			elevenService.update(eleven);
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
	public TbEleven findOne(Integer id){
		return elevenService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(Integer [] ids){
		try {
			elevenService.delete(ids);
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
	public PageResult search(@RequestBody TbEleven eleven, int page, int rows  ){
		return elevenService.findPage(eleven, page, rows);		
	}
	
}
