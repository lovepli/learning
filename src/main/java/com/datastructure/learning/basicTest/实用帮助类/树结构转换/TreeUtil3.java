package com.datastructure.learning.basicTest.实用帮助类.树结构转换;

import cn.hutool.json.JSONUtil; //github开源工具类
import com.alibaba.fastjson.JSON; //阿里巴巴 fastJson工具类
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotNull;
import java.lang.reflect.Field;
import java.util.*;

/**
 * @author: lipan
 * @date: 2020/5/15
 * @description: Java 基于反射的通用树形结构工具类
 *     在日常的开发中, 经常会遇到许多树形结构的场景, 如菜单树, 部门树, 目录树等. 而这些一般都会涉及到要将数据库查询出来的集合转化为树形结构的功能.
 *     由于 list -> tree 是一个比较通用的功能, 无非就是根据 id, pid, children 这三个字段进行转换. 但由于字段名可能不一致, 如菜单里可能叫 menuId, 而部门里叫
 *     deptId，所以我用反射来实现了一个通用的工具类, 来进行转换.
 *
 *     参考：https://github.com/zhaojun1998/Shiro-Action
 */
public class TreeUtil3 {

    /**
     * 集合转树结构
     *
     * @param collection 目标集合
     * @param clazz      集合元素类型
     * @return 转换后的树形结构
     */
    public static <T> Collection<T> toTree(@NotNull Collection<T> collection, @NotNull Class<T> clazz) {
        return toTree(collection, null, null, null, clazz);
    }

    /**
     * 集合转树结构 重载的方法，根据实际情况添加具体的id,pid,children的字段名称
     *
     * @param collection 目标集合
     * @param id         节点编号字段名称
     * @param parent     父节点编号字段名称
     * @param children   子节点集合属性名称
     * @param clazz      集合元素类型
     * @return           转换后的树形结构
     */
    public static <T> Collection<T> toTree(@NotNull Collection<T> collection, String id, String parent, String children, @NotNull Class<T> clazz) {
        try {
            // 如果目标集合为空,直接返回一个空树
            if (collection == null || collection.isEmpty()) {
                return null;
            }
            // 如果被依赖字段名称为空则默认为id
            if (StringUtils.isEmpty(id)) {
                id = "id";
            }
            // 如果依赖字段为空则默认为parent
            if (StringUtils.isEmpty(parent)) {
                parent = "parent";
            }
            // 如果子节点集合属性名称为空则默认为children
            if (StringUtils.isEmpty(children)) {
                children = "children";
            }

            // 初始化根节点集合, 支持 Set 和 List
            Collection<T> roots;
            if (collection.getClass().isAssignableFrom(Set.class)) {
                roots = new HashSet<>();
            } else {
                roots = new ArrayList<>();
            }

            // 获取 id 字段, 从当前对象或其父类
            Field idField;
            try {
                idField = clazz.getDeclaredField(id);
            } catch (NoSuchFieldException e1) {
                idField = clazz.getSuperclass().getDeclaredField(id);
            }

            // 获取 parentId 字段, 从当前对象或其父类
            Field parentField;
            try {
                parentField = clazz.getDeclaredField(parent);
            } catch (NoSuchFieldException e1) {
                parentField = clazz.getSuperclass().getDeclaredField(parent);
            }

            // 获取 children 字段, 从当前对象或其父类
            Field childrenField;
            try {
                childrenField = clazz.getDeclaredField(children);
            } catch (NoSuchFieldException e1) {
                childrenField = clazz.getSuperclass().getDeclaredField(children);
            }

            // 设置为可访问
            idField.setAccessible(true);
            parentField.setAccessible(true);
            childrenField.setAccessible(true);

            // 找出所有的根节点
            for (T c : collection) {
                Object parentId = parentField.get(c);
                if (isRootNode(parentId)) {
                    roots.add(c);
                }
            }

            // 从目标集合移除所有根节点
            collection.removeAll(roots);

            // 遍历根节点, 依次添加子节点
            for (T root : roots) {
                addChild(root, collection, idField, parentField, childrenField);
            }

            // 关闭可访问
            idField.setAccessible(false);
            parentField.setAccessible(false);
            childrenField.setAccessible(false);

            return roots;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 为目标节点添加孩子节点
     *
     * @param node             目标节点
     * @param collection    目标集合
     * @param idField       ID 字段
     * @param parentField   父节点字段
     * @param childrenField 字节点字段
     */
    private static <T> void addChild(@NotNull T node, @NotNull Collection<T> collection, @NotNull Field idField, @NotNull Field parentField, @NotNull Field childrenField) throws IllegalAccessException {
        Object id = idField.get(node);
        Collection<T> children = (Collection<T>) childrenField.get(node);
        // 如果子节点的集合为 null, 初始化孩子集合
        if (children == null) {
            if (collection.getClass().isAssignableFrom(Set.class)) {
                children = new HashSet<>();
            } else {
                children = new ArrayList<>();
            }
        }

        for (T t : collection) {
            Object o = parentField.get(t);
            if (id.equals(o)) {
                // 将当前节点添加到目标节点的孩子节点
                children.add(t);
                // 重设目标节点的孩子节点集合,这里必须重设,因为如果目标节点的孩子节点是null的话,这样是没有地址的,就会造成数据丢失,所以必须重设,如果目标节点所在类的孩子节点初始化为一个空集合,而不是null,则可以不需要这一步,因为java一切皆指针
                childrenField.set(node, children);
                // 递归添加孩子节点
                addChild(t, collection, idField, parentField, childrenField);
            }
        }
    }

    /**
     * 判断是否是根节点, 判断方式为: 父节点编号为空或为 0, 则认为是根节点. 此处的判断应根据自己的业务数据而定.
     * @param parentId      父节点编号
     * @return              是否是根节点
     */
    private static boolean isRootNode(Object parentId) {
        boolean flag = false;
        if (parentId == null) {
            flag = true;
        } else if (parentId instanceof String && (StringUtils.isEmpty(parentId) || parentId.equals("0"))) {
            flag = true;
        } else if (parentId instanceof Integer && Integer.valueOf(0).equals(parentId)) {
            flag = true;
        }
        return flag;
    }

    /**
     * 获取树形结构中的所有叶子节点 (前提是已经是树形结构), 默认子节点字段为: "children"
     */
    public static <T> List<T> getAllLeafNode(List<T> list) {
        return getAllLeafNode(list, null);
    }

    /**
     * 获取树形结构中的所有叶子节点 (前提是已经是树形结构)
     * @param list      树形结构
     * @param children  child 字段名称
     */
    public static <T> List<T> getAllLeafNode(List<T> list, String children) {
        try {
            if (StringUtils.isEmpty(children)) {
                children = "children";
            }

            List<T> result = new ArrayList<>();

            Queue<T> queue = new ArrayDeque<>();
            for (T item : list) {
                Field childrenField = item.getClass().getDeclaredField(children);
                childrenField.setAccessible(true);
                List<T> childrenList = (List<T>) childrenField.get(item);
                if (CollectionUtils.isEmpty(childrenList)) {
                    result.add(item);
                } else {
                    queue.addAll(childrenList);
                }
            }

            while (!queue.isEmpty()) {
                T item = queue.poll();
                Field childrenField = item.getClass().getDeclaredField(children);
                childrenField.setAccessible(true);
                List<T> childrenList = (List<T>) childrenField.get(item);
                if (CollectionUtils.isEmpty(childrenList)) {
                    result.add(item);
                } else {
                    queue.addAll(childrenList);
                }
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
           // throw new TreeCastException(e);
            throw new RuntimeException("树形转换异常");
        }
    }

    public static List<Menu2> addRootNode(String rootName, Integer rootId, List<Menu2> children) {
        Menu2 root = new Menu2();
        root.setMenuId(rootId);
        root.setMenuName(rootName);
        root.setChildren(children);
        List<Menu2> rootList = new ArrayList<>();
        rootList.add(root);
        return rootList;
    }
    /**
     * 测试方法
     * @param args
     */
    public static void main(String[] args) {

        List<Menu2> menuList = new ArrayList<>();
        menuList.add(new Menu2(1, null, "节点1"));
        menuList.add(new Menu2(2, null, "节点2"));
        menuList.add(new Menu2(3, 1, "节点1.1"));
        menuList.add(new Menu2(4, 1, "节点1.2"));
        menuList.add(new Menu2(5, 3, "节点1.1.1"));
        //菜单集合为：
        System.out.println(JSONUtil.toJsonStr(menuList));
        //这里的JSONutil.toJsonStr();是用的github上的一个工具类，也可以用fastjson工具类
        // System.out.println(JSON.toJSONString(menuList)); //报错了
        //1、集合转为菜单树结构
        Collection<Menu2> menus = TreeUtil3.toTree(menuList, "menuId", "parentId", "children", Menu2.class);
        //转换的菜单树为:
         System.out.println(JSONUtil.toJsonStr(menus));
        //方法二：
        //Collection<Menu2> menus2 = TreeUtil3.toTree(menuList, Menu2.class);
        // System.out.println(JSONUtil.toJsonStr(menus2));

        //2、为菜单树添加根节点
        List<Menu2>  menu2list =addRootNode("导航目录", 0, (List<Menu2>) menus);
        //"有根节点的菜单树:"
        System.out.println(JSONUtil.toJsonStr(menu2list));

        //3、获取菜单树的所有子节点
        //获取树形结构中的所有叶子节点，前提是必须已经是树结构
        List<Menu2> menuLeafNode = TreeUtil3.getAllLeafNode(menu2list);
        //"获取到的菜单树的所有自节点为："
         System.out.println(JSONUtil.toJsonStr(menuLeafNode));
    }

}
