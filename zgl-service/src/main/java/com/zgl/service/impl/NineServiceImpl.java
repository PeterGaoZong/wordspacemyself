package com.zgl.service.impl;
import java.util.List;

import com.zgl.pojo.PageResult;
import com.zgl.pojo.TbNineExample;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zgl.mapper.TbNineMapper;
import com.zgl.pojo.TbNine;
import com.zgl.service.NineService;


/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class NineServiceImpl implements NineService {

	@Autowired
	private TbNineMapper nineMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbNine> findAll() {
		return nineMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbNine> page=   (Page<TbNine>) nineMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbNine nine) {
		nineMapper.insert(nine);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbNine nine){
		nineMapper.updateByPrimaryKey(nine);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TbNine findOne(Integer id){
		return nineMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			nineMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(TbNine nine, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbNineExample example=new TbNineExample();
		TbNineExample.Criteria criteria = example.createCriteria();
		
		if(nine!=null){			
						if(nine.getName()!=null && nine.getName().length()>0){
				criteria.andNameLike("%"+nine.getName()+"%");
			}
			if(nine.getCompany()!=null && nine.getCompany().length()>0){
				criteria.andCompanyLike("%"+nine.getCompany()+"%");
			}
			if(nine.getSm()!=null && nine.getSm().length()>0){
				criteria.andSmLike("%"+nine.getSm()+"%");
			}
	
		}
		
		Page<TbNine> page= (Page<TbNine>)nineMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
