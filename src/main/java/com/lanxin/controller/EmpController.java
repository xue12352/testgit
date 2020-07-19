package com.lanxin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanxin.bean.Emp;
import com.lanxin.bean.EmpExample;
import com.lanxin.service.EmpService;
import com.lanxin.util.PageNum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by 86166 on 2019/8/16.
 */
@Controller
@RequestMapping(value = "empcontroller")
public class EmpController {

    @Autowired
    private EmpService empService;

    @RequestMapping(value = "/listemp")
    public ModelAndView listemp(Integer current) {
        ModelAndView mv = new ModelAndView();
        EmpExample example=new EmpExample();
        EmpExample.Criteria criteria=example.createCriteria();
        PageHelper.startPage(current, PageNum.PAGENUM);
        List<Emp> emps=empService.selectByExample(example);
        PageInfo pageInfo=new PageInfo(emps);
        mv.addObject("pageInfo",pageInfo);
        mv.addObject("emps",emps);
        mv.setViewName("listemp");
        mv.addObject("current",current);
        return mv;
    }

    @RequestMapping(value = "add")
    @ResponseBody
    public Emp add(String ename,Integer eage,Integer deptid){
        Emp e=new Emp();
        e.setEname(ename);
        e.setAge(eage);
        e.setDeptid(deptid);
        empService.insert(e);
        return e;
    }
}
