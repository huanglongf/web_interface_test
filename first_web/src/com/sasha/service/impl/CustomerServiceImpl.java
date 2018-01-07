package com.sasha.service.impl;

import cn.itcast.utils.Page;
import com.sasha.mapper.CustomerMapper;
import com.sasha.pojo.Customer;
import com.sasha.service.CustomerService;
import com.sasha.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Andy on 2018/1/2.
 */


@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper CustomerMapper;

    @Override
    public Page<Customer> findCustomerByPage(QueryVo vo) {

        //分页包装类;
        Page<Customer> page = new Page<>();

        //设置起始页;
        int startNo = (vo.getPage() - 1) * vo.getPageSize();
        vo.setStartNo(startNo);

        // 查询总记录;
        List<Customer> list = CustomerMapper.findCustomerByPage(vo);

        //查询总记录数;
        int customerByPageCount = CustomerMapper.findCustomerByPageCount(vo);

        //分页的列表
        page.setRows(list);
        //设置当前页
        page.setPage(vo.getPage());
        //设置
        page.setSize(vo.getPageSize());
        //总记录数
        page.setTotal(customerByPageCount);


        return page;
    }

    @Override
    public Customer findCustomerByID(Long id) {
        return CustomerMapper.selectByPrimaryKey(id);
    }

    @Override
    public String updateCustomer(Customer customer) {
         CustomerMapper.updateByPrimaryKey(customer);
        return "ok";
    }

    @Override
    public String deleteCustomer(Long custId) {
        CustomerMapper.deleteByPrimaryKey(custId);
        return "ok";
    }
}
