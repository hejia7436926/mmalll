package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;

/**
 *
 */
public interface IUserService {
    /**
     * 登录
     */
    ServerResponse<User> login(String username, String password);

    /**
     * 注册
     */
    ServerResponse<String> register(User user);

    /**
     * 校验-邮箱跟用户名
     */
    ServerResponse<String> checkValid(String str, String type);

    /**
     * 用户名找到问题
     */
    ServerResponse selectQuestion(String username);

    /**
     * 校验答案
     */
    ServerResponse<String> checkAnswer(String username, String question, String answer);

    /**
     * 忘记密码的重设密码
     */
    ServerResponse<String> forgetRestPassword(String username, String passwordNew, String forgetToken);

    /**
     * 登录状态下重置密码
     */
    ServerResponse<String> resetPassword(String passwordOld, String passwordNew, User user);

    /**
     * 修改信息
     */
    ServerResponse<User> updateInformation(User user);

    /**
     * 获取信息
     */
    ServerResponse<User> getInfomation(Integer userId);
    /**校验是否是管理员*/
    ServerResponse checkAdminRole(User user);
}
