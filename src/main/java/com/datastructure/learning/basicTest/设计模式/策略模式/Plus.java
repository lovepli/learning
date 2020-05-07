package com.datastructure.learning.basicTest.设计模式.策略模式;

/**
 * @author: lipan
 * @date: 2020-04-24
 * @description:
 */
public class Plus extends AbstractCalculator implements ICalculator {

    @Override
    public int calculate(String exp) {
        int arrayInt[] = split(exp, "\\+");
        return arrayInt[0] + arrayInt[1];
    }
}
