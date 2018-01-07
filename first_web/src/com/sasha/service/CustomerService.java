package com.sasha.service;

import cn.itcast.utils.Page;
import com.sasha.pojo.Customer;
import com.sasha.vo.QueryVo;

/**
 * Created by Andy on 2018/1/2.
 */
public interface CustomerService {
    Page<Customer> findCustomerByPage(QueryVo vo);

    Customer findCustomerByID(Long id);

    String updateCustomer(Customer customer);

    String deleteCustomer(Long custId);
}
