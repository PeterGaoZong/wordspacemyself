package com.zgl.service.impl;
import java.util.List;

import com.zgl.pojo.PageResult;
import com.zgl.pojo.TbTenExample;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zgl.mapper.TbTenMapper;
import com.zgl.pojo.TbTen;
import com.zgl.service.TenService;


/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class TenServiceImpl implements TenService {

	@Autowired
	private TbTenMapper tenMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbTen> findAll() {
		return tenMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbTen> page=   (Page<TbTen>) tenMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbTen ten) {
		tenMapper.insert(ten);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbTen ten){
		tenMapper.updateByPrimaryKey(ten);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TbTen findOne(Integer id){
		return tenMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			tenMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(TbTen ten, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbTenExample example=new TbTenExample();
		TbTenExample.Criteria criteria = example.createCriteria();
		
		if(ten!=null){			
						if(ten.getName()!=null && ten.getName().length()>0){
				criteria.andNameLike("%"+ten.getName()+"%");
			}
			if(ten.getCompany()!=null && ten.getCompany().length()>0){
				criteria.andCompanyLike("%"+ten.getCompany()+"%");
			}
			if(ten.getSm()!=null && ten.getSm().length()>0){
				criteria.andSmLike("%"+ten.getSm()+"%");
			}
	
		}
		
		Page<TbTen> page= (Page<TbTen>)tenMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
