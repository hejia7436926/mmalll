package com.mmall.service.impl;

import com.google.common.collect.Lists;
import com.mmall.common.ServerResponse;
import com.mmall.dao.CategoryMapper;
import com.mmall.pojo.Category;
import com.mmall.service.ICategoryService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @version : 1.0
 * @ClassName: CategoryServiceImpl
 * @Description :
 * @auther: hejia
 * @date: 2018/10/22
 */
@Service
public class CategoryServiceImpl implements ICategoryService {

    private Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public ServerResponse addCategory(String categoryName, Integer parentId) {
        if(StringUtils.isBlank(categoryName) || parentId == null){
            return ServerResponse.createByErrorMessage("参数错误");
        }
        Category category = new Category();
        category.setName(categoryName);
        category.setParentId(parentId);
        category.setStatus(true);
        int rowCount =categoryMapper.insert(category);
        if(rowCount>0){
            ServerResponse.createBySuccessMessage("创建品类成功");
        }
        return ServerResponse.createByErrorMessage("创建品类失败");
    }


    @Override
    public ServerResponse updateCategory(String categoryName, Integer parentId) {
        if(StringUtils.isBlank(categoryName) || parentId == null){
            return ServerResponse.createByErrorMessage("参数错误");
        }
        Category category = new Category();
        category.setParentId(parentId);
        category.setName(categoryName);
        int rowCount = categoryMapper.updateByPrimaryKeySelective(category);
        if(rowCount>0){//生效行数
            return ServerResponse.createBySuccess("更新品类名字成功");
        }
        return ServerResponse.createByErrorMessage("更新品类名字失败");
    }

    @Override
    public ServerResponse<List<Category>> getChildrenParallelCategory(Integer categoryId) {
        List<Category> categories = categoryMapper.getChildrenParallelCategory(categoryId);
        if(categories.size()==0){
            logger.info("未查询到当前分类的子节点");
        }
        return ServerResponse.createBySuccess(categories);
    }

    @Override
    public ServerResponse<List<Integer>> getChildrenDeepCategoryId(Integer categoryId) {
        HashSet<Category> categories = new HashSet<>();
        findChildCategory(categories,categoryId);
        List<Integer> categoryIdList = Lists.newArrayList();
        if(categoryId != null){
            for(Category categoryItem : categories){
                categoryIdList.add(categoryItem.getId());
            }
        }
        return ServerResponse.createBySuccess(categoryIdList);
    }
    /**递归算法*/
    private Set<Category> findChildCategory(Set<Category> categorySet,Integer categoryId){
        Category category = categoryMapper.selectByPrimaryKey(categoryId);
        if(category !=null){
            //不为空，添加进去
            categorySet.add(category);
        }
        //查找子节点
        List<Category> categoryList = categoryMapper.getChildrenParallelCategory(categoryId);
        for(Category cateroryItem : categoryList){
            findChildCategory(categorySet,cateroryItem.getId());
        }
        return categorySet;
    }
}
