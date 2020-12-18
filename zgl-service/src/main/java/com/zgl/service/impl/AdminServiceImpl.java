package com.zgl.service.impl;
import java.util.List;

import com.zgl.pojo.PageResult;
import com.zgl.pojo.TbAdminExample;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zgl.mapper.TbAdminMapper;
import com.zgl.pojo.TbAdmin;

import com.zgl.service.AdminService;


/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private TbAdminMapper adminMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbAdmin> findAll() {
		return adminMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbAdmin> page=   (Page<TbAdmin>) adminMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbAdmin admin) {
		adminMapper.insert(admin);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbAdmin admin){
		adminMapper.updateByPrimaryKey(admin);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TbAdmin findOne(Integer id){
		return adminMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			adminMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(TbAdmin admin, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbAdminExample example=new TbAdminExample();
		TbAdminExample.Criteria criteria = example.createCriteria();
		
		if(admin!=null){			
						if(admin.getUsername()!=null && admin.getUsername().length()>0){
				criteria.andUsernameLike("%"+admin.getUsername()+"%");
			}
			if(admin.getPassword()!=null && admin.getPassword().length()>0){
				criteria.andPasswordLike("%"+admin.getPassword()+"%");
			}
	
		}
		
		Page<TbAdmin> page= (Page<TbAdmin>)adminMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
