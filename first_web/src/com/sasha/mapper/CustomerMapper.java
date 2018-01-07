package com.sasha.mapper;

import cn.itcast.utils.Page;
import com.sasha.pojo.Customer;
import com.sasha.pojo.CustomerExample;
import com.sasha.vo.QueryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerMapper {
    long countByExample(CustomerExample example);

    int deleteByExample(CustomerExample example);

    int deleteByPrimaryKey(Long custId);

    int insert(Customer record);

    int insertSelective(Customer record);

    List<Customer> selectByExample(CustomerExample example);

    Customer selectByPrimaryKey(Long custId);

    int updateByExampleSelective(@Param("record") Customer record, @Param("example") CustomerExample example);

    int updateByExample(@Param("record") Customer record, @Param("example") CustomerExample example);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);

    //根据条件分页查询客户列表
     List<Customer> findCustomerByPage(QueryVo vo);

     //分页总记录数
    int findCustomerByPageCount(QueryVo vo);
}