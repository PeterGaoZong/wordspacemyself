package com.zgl.controller;
import java.util.List;

import com.zgl.pojo.PageResult;
import com.zgl.pojo.Result;
import com.zgl.pojo.TbAdmin;
import com.zgl.service.AdminService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;

/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

	@Reference
	private AdminService adminService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbAdmin> findAll(){
		return adminService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult findPage(int page, int rows){
		return adminService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param admin
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody TbAdmin admin){
		try {
			adminService.add(admin);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param admin
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody TbAdmin admin){
		try {
			adminService.update(admin);
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
	public TbAdmin findOne(Integer id){
		return adminService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(Integer [] ids){
		try {
			adminService.delete(ids);
			return new Result(true, "删除成功"); 
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	
		/**
	 * 查询+分页
	 * @param admin
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult search(@RequestBody TbAdmin admin, int page, int rows  ){
		return adminService.findPage(admin, page, rows);		
	}
	
}
