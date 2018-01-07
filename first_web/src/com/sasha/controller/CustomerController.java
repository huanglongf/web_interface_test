package com.sasha.controller;

import cn.itcast.utils.Page;
import com.sasha.pojo.BaseDict;
import com.sasha.pojo.Customer;
import com.sasha.service.BaseDictService;
import com.sasha.service.CustomerService;
import com.sasha.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by Andy on 2017/12/31.
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    //客户来源类别码
    @Value("${CUST_SOURCE_CODE}")
    private String CUST_SOURCE_CODE;

    //客户行业类别码
    @Value("${CUST_INDUSTRY_CODE}")
    private String CUST_INDUSTRY_CODE;
    //客户级别类别码
    @Value("${CUST_LEVEL_CODE}")
    private String CUST_LEVEL_CODE;

    //注入字典表;
    @Autowired
    private BaseDictService baseDictService;

    //注入CustomerService
   @Autowired
    private CustomerService customerService;


    @RequestMapping("/list")
    public String list(Model model, QueryVo vo) {
        //客户名称,客户来源,所属行业,客户级别的显示,排序和enable判断;
        System.out.println("===============打通==================");

        //get 中文乱码的处理;
        try {

            if (vo.getCustName() != null) {
                vo.setCustName(new String(vo.getCustName().getBytes("iso-8859-1"), "utf-8"));
            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        //初始化查询下拉选;
        List<BaseDict> fromType = baseDictService.findBaseDictWithTypeCode(CUST_SOURCE_CODE);
        List<BaseDict> industryType = baseDictService.findBaseDictWithTypeCode(CUST_INDUSTRY_CODE);
        List<BaseDict> levelType = baseDictService.findBaseDictWithTypeCode(CUST_LEVEL_CODE);


        model.addAttribute("fromType", fromType);
        model.addAttribute("industryType", industryType);
        model.addAttribute("levelType", levelType);


        //将数据封装进去queryVo,返回页面的数据是page;
        //起始页的初始化(在mybatis 和 queryvo中初始化了)
        Page<Customer> page = customerService.findCustomerByPage(vo);
        model.addAttribute("page", page);


        //页面的回显
        model.addAttribute("custSource", vo.getCustSource());
        model.addAttribute("customerName", vo.getCustName());
        model.addAttribute("custIndustry", vo.getCustIndustry());
        model.addAttribute("custLevel", vo.getCustLevel());


        return "list";
    }


    /**
     * 窗口回显
     * @param id
     * @return json -string
     */
    @RequestMapping("/edit")
    @ResponseBody
    public Customer findCustomerByID(Long id){
        Customer customer = customerService.findCustomerByID(id);
        //返回查询对象
        return customer;
    }


    /**
     * 更新数据
     * @param customer
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public String updateCustomer(Customer customer){

        String oK = customerService.updateCustomer(customer);
        return oK;
    }

    /**
     * 删除数据
     * @param custId
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public String deleteCustomer(@RequestParam(value="id") Long custId){
        //删除客户信息
        String ok = customerService.deleteCustomer(custId);
        return ok;

    }

}
