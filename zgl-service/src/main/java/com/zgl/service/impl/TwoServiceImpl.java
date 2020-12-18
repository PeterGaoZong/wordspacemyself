package com.zgl.service.impl;
import java.util.List;

import com.zgl.pojo.PageResult;
import com.zgl.pojo.TbTwoExample;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zgl.mapper.TbTwoMapper;
import com.zgl.pojo.TbTwo;
import com.zgl.service.TwoService;


/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class TwoServiceImpl implements TwoService {

	@Autowired
	private TbTwoMapper twoMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbTwo> findAll() {
		return twoMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbTwo> page=   (Page<TbTwo>) twoMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbTwo two) {
		twoMapper.insert(two);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbTwo two){
		twoMapper.updateByPrimaryKey(two);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TbTwo findOne(Integer id){
		return twoMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			twoMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(TbTwo two, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbTwoExample example=new TbTwoExample();
		TbTwoExample.Criteria criteria = example.createCriteria();
		
		if(two!=null){			
						if(two.getName()!=null && two.getName().length()>0){
				criteria.andNameLike("%"+two.getName()+"%");
			}
			if(two.getCompany()!=null && two.getCompany().length()>0){
				criteria.andCompanyLike("%"+two.getCompany()+"%");
			}
			if(two.getSm()!=null && two.getSm().length()>0){
				criteria.andSmLike("%"+two.getSm()+"%");
			}
	
		}
		
		Page<TbTwo> page= (Page<TbTwo>)twoMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
