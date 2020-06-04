package com.datastructure.learning.basicTest.实现一个本地缓存cache.guava本地缓存实现.demo2;

/**
 * @author: lipan
 * @date: 2020/6/4
 * @description:  主要看这个处理逻辑思路 https://www.lagou.com/lgeduarticle/16286.html
 */
public class CacheGuavaController {

//    @RequestMapping(value = "/get",method = {RequestMethod.GET})
//    @ResponseBody
//    public CommonReturnType getItem(@RequestParam(name = "id")Integer id){
//        //在本地缓存中查找
//        ItemModel itemModel= (ItemModel) cacheService.getFromCommonCache("item_"+id);
//
//        if(itemModel==null){
//            //本地缓存没有则到redis缓存中查找
//            itemModel= (ItemModel) redisTemplate.opsForValue().get("item_"+id);
//            if(itemModel==null){
//                //都没有则到数据库查找，找到后放入redis中
//                itemModel = itemService.getItemById(id);
//                redisTemplate.opsForValue().set("item_"+id,itemModel);
//                redisTemplate.expire("item_"+id,10, TimeUnit.MINUTES);
//            }
//            //本地缓存没有时，在redis或数据库找到后再放入本地缓存
//            cacheService.setCommonCache("item_"+id,itemModel);
//        }
//
//
//        ItemVO itemVO = convertVOFromModel(itemModel);
//
//        return CommonReturnType.create(itemVO);
//
//    }
}
