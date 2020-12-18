package com.zgl.service.impl;
import java.util.List;

import com.zgl.pojo.PageResult;
import com.zgl.pojo.TbSixExample;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zgl.mapper.TbSixMapper;
import com.zgl.pojo.TbSix;
import com.zgl.service.SixService;


/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class SixServiceImpl implements SixService {

	@Autowired
	private TbSixMapper sixMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbSix> findAll() {
		return sixMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbSix> page=   (Page<TbSix>) sixMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbSix six) {
		sixMapper.insert(six);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbSix six){
		sixMapper.updateByPrimaryKey(six);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TbSix findOne(Integer id){
		return sixMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			sixMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(TbSix six, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbSixExample example=new TbSixExample();
		TbSixExample.Criteria criteria = example.createCriteria();
		
		if(six!=null){			
						if(six.getName()!=null && six.getName().length()>0){
				criteria.andNameLike("%"+six.getName()+"%");
			}
			if(six.getCompany()!=null && six.getCompany().length()>0){
				criteria.andCompanyLike("%"+six.getCompany()+"%");
			}
			if(six.getSm()!=null && six.getSm().length()>0){
				criteria.andSmLike("%"+six.getSm()+"%");
			}
	
		}
		
		Page<TbSix> page= (Page<TbSix>)sixMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
