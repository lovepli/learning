package com.datastructure.learning.basicTest.分页类;

import java.util.Arrays;
import java.util.List;

/**
 * @author: lipan
 * @date: 2020-02-21
 * @description: java分页代码实现
 */
public class PageBean {
    private int curPage; //当前页
    private int pageCount; //总页数
    private int rowsCount; //总行数
    private int pageSize=10; //每页多少行

    public PageBean(int rows){

        this.setRowsCount(rows);
        if(this.rowsCount % this.pageSize == 0){
            this.pageCount=this.rowsCount / this.pageSize;
        }
        else if(rows<this.pageSize){
            this.pageCount=1;
        }
        else{
            this.pageCount=this.rowsCount / this.pageSize +1;
        }
    }

    public int getCurPage() {
        return curPage;
    }
    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }
    public int getPageCount() {
        return pageCount;
    }
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public int getRowsCount() {
        return rowsCount;
    }
    public void setRowsCount(int rowsCount) {
        this.rowsCount = rowsCount;
    }


//新建一个测试类Article
static class Article{
        public String a;
        private String b;

    public  Article(String a,String B){
            this.a=a;
            this.b=b;
        }
}

    public static void main(String[] args) {
        Article source1= new Article("1","1");
        Article source2= new Article("2","2");
        Article source3= new Article("3","1");
        Article source4= new Article("4","2");
        Article source5= new Article("5","1");
        Article source6= new Article("6","2");
        Article source7= new Article("7","1");
        Article source8= new Article("8","2");
        Article source9= new Article("9","1");
        Article source10= new Article("10","2");
        Article source11= new Article("11","1");
        Article source12= new Article("12","2");
        List<Article> clist= Arrays.asList(source1,source2,source3,source4,source5,source6,source7,source8,source9,source10,source11,source12);
        //将查询结果存放在List集合里


        PageBean pagebean=new PageBean(clist.size());//初始化PageBean对象
        //设置当前页
        int page=2;
        pagebean.setCurPage(page); //这里page是从页面上获取的一个参数，代表当前页，即页数
        //获得分页大小
        int pagesize=pagebean.getPageSize();
        //获得分页数据在list集合中的索引
        int firstIndex=(page-1)*pagesize;
        int toIndex=page*pagesize;
        if(toIndex>clist.size()){
            toIndex=clist.size();
        }
        if(firstIndex>toIndex){
            firstIndex=0;
            pagebean.setCurPage(1);
        }
        //截取数据集合，获得分页数据
        List courseList=clist.subList(firstIndex, toIndex);
        System.out.println(courseList);  //第一页总共有打印出10条数据，第二页打印2条数据，说明分页没有问题


    }
}
