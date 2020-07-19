package com.lanxin.service;

import com.lanxin.bean.Emp;
import com.lanxin.bean.EmpExample;
import com.lanxin.dao.EmpMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 86166 on 2019/8/16.
 */
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public int countByExample(EmpExample example) {
        return empMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(EmpExample example) {
        return empMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer oid) {
        return empMapper.deleteByPrimaryKey(oid);
    }

    @Override
    public int insert(Emp record) {
        return empMapper.insert(record);
    }

    @Override
    public int insertSelective(Emp record) {
        return empMapper.insertSelective(record);
    }

    @Override
    public List<Emp> selectByExample(EmpExample example) {
        return empMapper.selectByExample(example);
    }

    @Override
    public Emp selectByPrimaryKey(Integer oid) {
        return empMapper.selectByPrimaryKey(oid);
    }

    @Override
    public int updateByExampleSelective(@Param("record") Emp record, @Param("example") EmpExample example) {
        return empMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(@Param("record") Emp record, @Param("example") EmpExample example) {
        return empMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(Emp record) {
        return empMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Emp record) {
        return empMapper.updateByPrimaryKey(record);
    }

}
