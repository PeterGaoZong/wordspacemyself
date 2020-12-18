package com.zgl.service.impl;
import java.util.List;

import com.zgl.pojo.PageResult;
import com.zgl.pojo.TbEightExample;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zgl.mapper.TbEightMapper;
import com.zgl.pojo.TbEight;
import com.zgl.service.EightService;


/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class EightServiceImpl implements EightService {

	@Autowired
	private TbEightMapper eightMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbEight> findAll() {
		return eightMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbEight> page=   (Page<TbEight>) eightMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbEight eight) {
		Float num = eight.getNum();
		double numDouble = num.doubleValue();
		Integer.parseInt(Double.toString(numDouble));
		Integer fcrg = eight.getFcrg();
		eightMapper.insert(eight);
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbEight eight){
		eightMapper.updateByPrimaryKey(eight);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TbEight findOne(Integer id){
		return eightMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			eightMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(TbEight eight, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbEightExample example=new TbEightExample();
		TbEightExample.Criteria criteria = example.createCriteria();
		
		if(eight!=null){			
						if(eight.getName()!=null && eight.getName().length()>0){
				criteria.andNameLike("%"+eight.getName()+"%");
			}
			if(eight.getCompany()!=null && eight.getCompany().length()>0){
				criteria.andCompanyLike("%"+eight.getCompany()+"%");
			}
			if(eight.getSm()!=null && eight.getSm().length()>0){
				criteria.andSmLike("%"+eight.getSm()+"%");
			}
	
		}
		
		Page<TbEight> page= (Page<TbEight>)eightMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
