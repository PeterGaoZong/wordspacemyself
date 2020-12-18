package com.zgl.service.impl;
import java.util.List;

import com.zgl.pojo.PageResult;
import com.zgl.pojo.TbOneExample;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zgl.mapper.TbOneMapper;
import com.zgl.pojo.TbOne;
import com.zgl.service.OneService;


/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class OneServiceImpl implements OneService {

	@Autowired
	private TbOneMapper oneMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbOne> findAll() {
		return oneMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbOne> page=   (Page<TbOne>) oneMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbOne one) {
		oneMapper.insert(one);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbOne one){
		oneMapper.updateByPrimaryKey(one);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TbOne findOne(Integer id){
		return oneMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			oneMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(TbOne one, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbOneExample example=new TbOneExample();
		TbOneExample.Criteria criteria = example.createCriteria();
		
		if(one!=null){			
						if(one.getName()!=null && one.getName().length()>0){
				criteria.andNameLike("%"+one.getName()+"%");
			}
			if(one.getCompany()!=null && one.getCompany().length()>0){
				criteria.andCompanyLike("%"+one.getCompany()+"%");
			}
			if(one.getSm()!=null && one.getSm().length()>0){
				criteria.andSmLike("%"+one.getSm()+"%");
			}
	
		}
		
		Page<TbOne> page= (Page<TbOne>)oneMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
