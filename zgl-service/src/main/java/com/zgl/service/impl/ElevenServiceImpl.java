package com.zgl.service.impl;
import java.util.List;

import com.zgl.pojo.PageResult;
import com.zgl.pojo.TbElevenExample;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zgl.mapper.TbElevenMapper;
import com.zgl.pojo.TbEleven;
import com.zgl.service.ElevenService;


/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class ElevenServiceImpl implements ElevenService {

	@Autowired
	private TbElevenMapper elevenMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbEleven> findAll() {
		return elevenMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbEleven> page=   (Page<TbEleven>) elevenMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbEleven eleven) {
		elevenMapper.insert(eleven);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbEleven eleven){
		elevenMapper.updateByPrimaryKey(eleven);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TbEleven findOne(Integer id){
		return elevenMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			elevenMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(TbEleven eleven, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbElevenExample example=new TbElevenExample();
		TbElevenExample.Criteria criteria = example.createCriteria();
		
		if(eleven!=null){			
						if(eleven.getCode()!=null && eleven.getCode().length()>0){
				criteria.andCodeLike("%"+eleven.getCode()+"%");
			}
			if(eleven.getName()!=null && eleven.getName().length()>0){
				criteria.andNameLike("%"+eleven.getName()+"%");
			}
			if(eleven.getNum()!=null && eleven.getNum().length()>0){
				criteria.andNumLike("%"+eleven.getNum()+"%");
			}
			if(eleven.getCompany()!=null && eleven.getCompany().length()>0){
				criteria.andCompanyLike("%"+eleven.getCompany()+"%");
			}
			if(eleven.getFcrg()!=null && eleven.getFcrg().length()>0){
				criteria.andFcrgLike("%"+eleven.getFcrg()+"%");
			}
			if(eleven.getSum()!=null && eleven.getSum().length()>0){
				criteria.andSumLike("%"+eleven.getSum()+"%");
			}
			if(eleven.getSm()!=null && eleven.getSm().length()>0){
				criteria.andSmLike("%"+eleven.getSm()+"%");
			}
	
		}
		
		Page<TbEleven> page= (Page<TbEleven>)elevenMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
