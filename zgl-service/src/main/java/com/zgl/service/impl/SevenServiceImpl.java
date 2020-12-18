package com.zgl.service.impl;
import java.util.List;

import com.zgl.pojo.PageResult;
import com.zgl.pojo.TbSevenExample;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zgl.mapper.TbSevenMapper;
import com.zgl.pojo.TbSeven;
import com.zgl.service.SevenService;


/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class SevenServiceImpl implements SevenService {

	@Autowired
	private TbSevenMapper sevenMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbSeven> findAll() {
		return sevenMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbSeven> page=   (Page<TbSeven>) sevenMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbSeven seven) {
		sevenMapper.insert(seven);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbSeven seven){
		sevenMapper.updateByPrimaryKey(seven);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TbSeven findOne(Integer id){
		return sevenMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			sevenMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(TbSeven seven, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbSevenExample example=new TbSevenExample();
		TbSevenExample.Criteria criteria = example.createCriteria();
		
		if(seven!=null){			
						if(seven.getName()!=null && seven.getName().length()>0){
				criteria.andNameLike("%"+seven.getName()+"%");
			}
			if(seven.getCompany()!=null && seven.getCompany().length()>0){
				criteria.andCompanyLike("%"+seven.getCompany()+"%");
			}
			if(seven.getSm()!=null && seven.getSm().length()>0){
				criteria.andSmLike("%"+seven.getSm()+"%");
			}
	
		}
		
		Page<TbSeven> page= (Page<TbSeven>)sevenMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
