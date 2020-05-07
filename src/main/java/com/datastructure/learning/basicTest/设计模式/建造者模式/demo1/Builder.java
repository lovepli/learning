package com.datastructure.learning.basicTest.设计模式.建造者模式.demo1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lipan
 * @date: 2020-04-23
 * @description:
 */
public class Builder {

    private List<Sender> list = new ArrayList<Sender>();

    public void produceMailSender(int count) {
        int a=0;
        for (int i = 0; i < count; i++) {
            list.add(new MailSender());
            a=a+i;
            System.out.println("#########"+a);
        }
    }

    public void produceSmsSender(int count) {
        for (int i = 0; i < count; i++) {
            list.add(new SmsSender());
        }
    }
}

