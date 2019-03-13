package com.mmall.dao;

import com.mmall.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 校验用户名是否存在
     */
    int checkUsername(String username);

    /**
     * 校验邮箱是否存在
     */
    int checkEmail(String email);

    /**
     * 验证用户名跟密码
     */
    User selectLogin(@Param("username") String username, @Param("password") String password);

    /**
     * 用户名查找问题
     */
    String selectQuestionByUserName(String userName);

    /**
     * 校验问题的答案
     */
    int checkAnswer(@Param("username") String username, @Param("question") String question, @Param("answer") String answer);

    /**
     * 修改密码
     */
    int updatePasswordByUserName(@Param("username") String username, @Param("password") String password);

    /**
     * 校验密码
     */
    int checkPassword(@Param("password") String password, @Param("userId") Integer userId);

    /**
     * 校验邮箱
     */
    int checkEmailByUserId(@Param("email") String email, @Param("userId") Integer userId);
}