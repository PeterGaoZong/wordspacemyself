package com.zgl.service.impl;
import java.util.List;

import com.zgl.pojo.PageResult;
import com.zgl.pojo.TbThreeExample;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zgl.mapper.TbThreeMapper;
import com.zgl.pojo.TbThree;
import com.zgl.service.ThreeService;


/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class ThreeServiceImpl implements ThreeService {

	@Autowired
	private TbThreeMapper threeMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbThree> findAll() {
		return threeMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbThree> page=   (Page<TbThree>) threeMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbThree three) {
		threeMapper.insert(three);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbThree three){
		threeMapper.updateByPrimaryKey(three);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TbThree findOne(Integer id){
		return threeMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			threeMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(TbThree three, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbThreeExample example=new TbThreeExample();
		TbThreeExample.Criteria criteria = example.createCriteria();
		
		if(three!=null){			
						if(three.getName()!=null && three.getName().length()>0){
				criteria.andNameLike("%"+three.getName()+"%");
			}
			if(three.getCompany()!=null && three.getCompany().length()>0){
				criteria.andCompanyLike("%"+three.getCompany()+"%");
			}
			if(three.getSm()!=null && three.getSm().length()>0){
				criteria.andSmLike("%"+three.getSm()+"%");
			}
	
		}
		
		Page<TbThree> page= (Page<TbThree>)threeMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
