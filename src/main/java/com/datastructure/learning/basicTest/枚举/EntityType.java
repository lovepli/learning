package com.datastructure.learning.basicTest.枚举;

/**
 * @author: lipan
 * @date: 2020-04-26
 * @description: 在枚举出现之前，如果想要表示一组特定的离散值，往往使用一些常量。
 */
public class EntityType {

    public static final int VIDEO = 1;//视频
    public static final int AUDIO = 2;//音频
    public static final int TEXT = 3;//文字
    public static final int IMAGE = 4;//图片

    private int id;
    private int type;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
}
