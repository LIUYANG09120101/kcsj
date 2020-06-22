package cn.kcsj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *jsp页面路径配置
 */

@Controller
@RequestMapping("/JSP")
public class JSPController {
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @RequestMapping("/searchResult")
    public String searchResult(){ return "searchResult"; }
    @RequestMapping("/readerPersonal")
    public String readerPersonal(){
        return "readerPersonal";
    }
    @RequestMapping("/readerAlterData")
    public String readerAlterData(){ return "readerAlterData"; }
    @RequestMapping("/readerAlterPaswd")
    public String readerAlterPaswd(){
        return "readerAlterPaswd";
    }
    @RequestMapping("/readerBorrowing")
    public String readerBorrowing(){
        return "readerBorrowing";
    }
    @RequestMapping("/readerBorrowed")
    public String readerBorrowed(){ return "readerBorrowed"; }
    @RequestMapping("/adBorrowBook")
    public String adBorrowBook(){ return "adBorrowBook"; }
    @RequestMapping("/adReturnBook")
    public String adReturnBook(){ return "adReturnBook"; }
    @RequestMapping("/adAddBook")
    public String adAddBook(){ return "adAddBook"; }
    @RequestMapping("/adOutBook")
    public String adOutBook(){ return "adOutBook"; }
    @RequestMapping("/adAlterBook")
    public String adAlterBook(){ return "adAlterBook"; }
    @RequestMapping("/adCheckBook")
    public String adCheckBook(){ return "adCheckBook"; }
    @RequestMapping("/adSearchBook")
    public String adSearchBook(){ return "adSearchBook"; }
    @RequestMapping("/adPersonal")
    public String adPersonal(){ return "adPersonal"; }
    @RequestMapping("/adminPersonal")
    public String adminPersonal(){ return "adminPersonal"; }
    @RequestMapping("/adminAddReader")
    public String adminAddReader(){ return "adminAddReader"; }
    @RequestMapping("/adminOutReader")
    public String adminOutReader(){ return "adminOutReader"; }
    @RequestMapping("/adminAlterReader")
    public String adminAlterReader(){ return "adminAlterReader"; }
    @RequestMapping("/adminAddAd")
    public String adminAddAd(){ return "adminAddAd"; }
    @RequestMapping("/adminOutAd")
    public String adminOutAd(){ return "adminOutAd"; }
    @RequestMapping("/adminAlterAd")
    public String adminAlterAd(){ return "adminAlterAd"; }
    @RequestMapping("/adminSearchAd")
    public String adminSearchAd(){ return "adminSearchAd"; }
    @RequestMapping("/adminSearchReader")
    public String adminSearchReader(){ return "adminSearchReader"; }

    @RequestMapping("/insterBorrowBookr")
    public String insterBorrowBookr(){ return "insterBorrowBookr"; }
}
