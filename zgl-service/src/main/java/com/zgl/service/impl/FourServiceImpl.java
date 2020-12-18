package com.zgl.service.impl;
import java.util.List;

import com.zgl.pojo.PageResult;
import com.zgl.pojo.TbFourExample;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zgl.mapper.TbFourMapper;
import com.zgl.pojo.TbFour;
import com.zgl.service.FourService;


/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class FourServiceImpl implements FourService {

	@Autowired
	private TbFourMapper fourMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbFour> findAll() {
		return fourMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbFour> page=   (Page<TbFour>) fourMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbFour four) {
		fourMapper.insert(four);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbFour four){
		fourMapper.updateByPrimaryKey(four);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TbFour findOne(Integer id){
		return fourMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			fourMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(TbFour four, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbFourExample example=new TbFourExample();
		TbFourExample.Criteria criteria = example.createCriteria();
		
		if(four!=null){			
						if(four.getName()!=null && four.getName().length()>0){
				criteria.andNameLike("%"+four.getName()+"%");
			}
			if(four.getCompany()!=null && four.getCompany().length()>0){
				criteria.andCompanyLike("%"+four.getCompany()+"%");
			}
			if(four.getSm()!=null && four.getSm().length()>0){
				criteria.andSmLike("%"+four.getSm()+"%");
			}
	
		}
		
		Page<TbFour> page= (Page<TbFour>)fourMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
