package com.swpu.asflow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UIController {
    @RequestMapping("login")
    public String login(){
        return "login.html";
    }
    @RequestMapping("reg")
    public String reg(){
        return "reg.html";
    }
    @RequestMapping("index")
    public String index(){
        return "index.html";
    }
    @RequestMapping("cxy")
    public String cxy(){
        return "cxy.html";
    }
    @RequestMapping("add_demand")
    public String add_demand(){
        return "add_demand.html";
    }
    @RequestMapping("add_model")
    public String add_model(){
        return "add_model.html";
    }
    @RequestMapping("creat")
    public String creat(){
        return "creat.html";
    }
    @RequestMapping("demand")
    public String demand(){
        return "demand.html";
    }
    @RequestMapping("mail")
    public String mail(){
        return "mail.html";
    }
    @RequestMapping("model")
    public String model(){
        return "model.html";
    }
    @RequestMapping("model_list")
    public String model_list(){
        return "model_list.html";
    }
    @RequestMapping("msg")
    public String msg(){
        return "msg.html";
    }
    @RequestMapping("project_admin")
    public String project_admin(){
        return "project_admin.html";
    }
    @RequestMapping("project_manager")
    public String project_manager(){
        return "project_manager.html";
    }
    @RequestMapping("test")
    public String test(){
        return "test.html";
    }
    @RequestMapping("toInterface")
    public String toInterface(){
        return "toInterface.html";
    }
    @RequestMapping("toModel")
    public String toModel(){
        return "toModel.html";
    }
    @RequestMapping("xinxi")
    public String xinxi(){
        return "xinxi.html";
    }
    @RequestMapping("add_changeUser")
    public  String add_changeUser(){
        return "add_changeUser.html";
    }
    @RequestMapping("searchDemand")
    public  String searchDemand(){
        return "searchDemand.html";
    }
    @RequestMapping("searchModel")
    public  String searchModel(){
        return "searchModel.html";
    }
    @RequestMapping("add_Department")
    public  String add_Department(){
        return "add_Department.html";
    }
    @RequestMapping("interface_list")
    public  String interfaces_list(){
        return "interface_list.html";
    }
    @RequestMapping("interface")
    public  String interfaces(){
        return "interface.html";
    }
    @RequestMapping("add_interface")
    public  String add_interface(){
        return "add_interface.html";
    }
@RequestMapping("toCode")
    public String toCode(){return "toCode.html";}
    @RequestMapping("code_list")
    public String code_list(){return "code_list.html";}
    @RequestMapping("add_job")
    public String add_job(){return "add_job.html";}
    @RequestMapping("searchJob")
    public String searchJob(){return "searchJob.html";}

    @RequestMapping("code_list_manager")
    public String code_list_manager(){return "code_list_manager.html";}
    @RequestMapping("add_job_manager")
    public String add_job_manager(){return "add_job_manager.html";}
    @RequestMapping("searchJob_manager")
    public String searchJob_manager(){return "searchJob_manager.html";}
    @RequestMapping("add_subjob")
    public String add_subjob(){
        return "add_subjob.html";
    }
    @RequestMapping("toTest")
    public String toTest(){
        return "toTest.html";
    }
    @RequestMapping("test_list")
    public String test_list(){
        return "test_list.html";
    }
    @RequestMapping("interfacetest")
    public String interfacetest(){
        return "interfacetest.html";
    }
    @RequestMapping("demandtest")
    public String demandtest(){
        return "demandtest.html";
    }

    @RequestMapping("add_test_job")
    public  String add_test_job(){
        return "add_test_job.html";
    }

    @RequestMapping("searchTestJob")
    public String searchTestJob(){
        return "searchTestJob.html";
    }
    @RequestMapping("test_manager")
    public String test_manager(){
        return "test_manager.html";
    }
    @RequestMapping("add_subtestjob")
    public String add_subtestjob(){
        return "add_subtestjob.html";
    }
    @RequestMapping("searchphoto")
    public String searchphoto(){
        return "searchphoto.html";
    }
    @RequestMapping("testcxy")
    public String testcxy(){
        return "testcxy.html";
    }
    @RequestMapping("searchDemandTestJob")
    public String searchDemandTestJob(){
        return "searchDemandTestJob.html";
    }
    @RequestMapping("add_showpdf")
    public String add_showpdf(){
        return "add_showpdf.html";
    }
    @RequestMapping("demandtest_manager")
    public String demandtest_manager(){
        return "demandtest_manager.html";
    }
    @RequestMapping("demandtestcxy")
    public String demandtestcxy(){
        return "demandtestcxy.html";
    }
}
