package com.dao.impl;

import com.dao.BusinessAccessBiz;
import com.dao.SolrDao;
import com.dao.SolrRegister;
import com.orm.AnQuan;
import com.orm.MeiShi;

/**
 * Created by Administrator on 2016/4/6.
 */
public class Simple {

    public static void main(String[] args) {
//        BusinessAccessBiz anQuanBiz = new AnQuanBiz();
//        BusinessAccessBiz meishiBiz = new MeiShiBiz();
//        AnQuan anQuan = new AnQuan();
//        MeiShi meiShi = new MeiShi();
//        anQuanBiz.saveObject(anQuan);
//        meishiBiz.saveObject(meiShi);

        MeiShi meiShi = new MeiShi();
        meiShi.setId(2);
        meiShi.setName("小太明");

        SolrDao solrDao = new SolrDao();
        solrDao.saveSolr(meiShi);

    }

}
