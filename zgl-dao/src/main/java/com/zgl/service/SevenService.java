package com.zgl.service;
import java.util.List;
import com.zgl.pojo.TbSeven;

import com.zgl.pojo.PageResult;
/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface SevenService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<TbSeven> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(TbSeven seven);
	
	
	/**
	 * 修改
	 */
	public void update(TbSeven seven);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public TbSeven findOne(Integer id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	public void delete(Integer[] ids);

	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	public PageResult findPage(TbSeven seven, int pageNum, int pageSize);
	
}
