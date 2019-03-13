package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.Category;

import java.util.List;

public interface ICategoryService {
    /**增加分类*/
    ServerResponse addCategory(String categoryName,Integer parentId);

    /**修改名称*/
    ServerResponse updateCategory(String categoryName,Integer parentId);

    /**查询*/
    ServerResponse<List<Category>> getChildrenParallelCategory(Integer categoryId);

    /**查询包括子节点的id*/
    ServerResponse<List<Integer>> getChildrenDeepCategoryId(Integer categoryId);
}
