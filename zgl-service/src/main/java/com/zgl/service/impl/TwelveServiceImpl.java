package com.zgl.service.impl;
import java.util.List;

import com.zgl.pojo.PageResult;
import com.zgl.pojo.TbTwelveExample;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zgl.mapper.TbTwelveMapper;
import com.zgl.pojo.TbTwelve;
import com.zgl.service.TwelveService;


/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class TwelveServiceImpl implements TwelveService {

	@Autowired
	private TbTwelveMapper twelveMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbTwelve> findAll() {
		return twelveMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbTwelve> page=   (Page<TbTwelve>) twelveMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbTwelve twelve) {
		twelveMapper.insert(twelve);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbTwelve twelve){
		twelveMapper.updateByPrimaryKey(twelve);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TbTwelve findOne(Integer id){
		return twelveMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			twelveMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(TbTwelve twelve, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbTwelveExample example=new TbTwelveExample();
		TbTwelveExample.Criteria criteria = example.createCriteria();
		
		if(twelve!=null){			
						if(twelve.getName()!=null && twelve.getName().length()>0){
				criteria.andNameLike("%"+twelve.getName()+"%");
			}
	
		}
		
		Page<TbTwelve> page= (Page<TbTwelve>)twelveMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
