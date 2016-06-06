package com.dao.impl;

import com.dao.IWorkFactory;
import com.dao.Work;

/**
 * Created by Administrator on 2016/4/5.
 */
public class StudentWorkFactory implements IWorkFactory {

    public Work getWork() {
        return new StudentWork();
    }

}
