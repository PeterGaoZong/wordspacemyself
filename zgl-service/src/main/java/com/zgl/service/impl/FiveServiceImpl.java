package com.zgl.service.impl;
import java.util.List;

import com.zgl.pojo.PageResult;
import com.zgl.pojo.TbFiveExample;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zgl.mapper.TbFiveMapper;
import com.zgl.pojo.TbFive;
import com.zgl.service.FiveService;


/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class FiveServiceImpl implements FiveService {

	@Autowired
	private TbFiveMapper fiveMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbFive> findAll() {
		return fiveMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbFive> page=   (Page<TbFive>) fiveMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbFive five) {
		fiveMapper.insert(five);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbFive five){
		fiveMapper.updateByPrimaryKey(five);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TbFive findOne(Integer id){
		return fiveMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			fiveMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(TbFive five, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbFiveExample example=new TbFiveExample();
		TbFiveExample.Criteria criteria = example.createCriteria();
		
		if(five!=null){			
						if(five.getName()!=null && five.getName().length()>0){
				criteria.andNameLike("%"+five.getName()+"%");
			}
			if(five.getCompany()!=null && five.getCompany().length()>0){
				criteria.andCompanyLike("%"+five.getCompany()+"%");
			}
			if(five.getSm()!=null && five.getSm().length()>0){
				criteria.andSmLike("%"+five.getSm()+"%");
			}
	
		}
		
		Page<TbFive> page= (Page<TbFive>)fiveMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
