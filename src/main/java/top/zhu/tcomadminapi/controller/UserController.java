package top.zhu.tcomadminapi.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import top.zhu.tcomadminapi.common.result.Result;
import top.zhu.tcomadminapi.convert.UserConvert;
import top.zhu.tcomadminapi.mapper.UserMapper;
import top.zhu.tcomadminapi.model.entity.User;
import top.zhu.tcomadminapi.model.vo.UserVO;
import top.zhu.tcomadminapi.service.UserService;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户管理
 */
@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 分页查询所有用户
     */
    @Operation(summary = "分页查询所有用户", description = "分页查询所有用户，支持筛选昵称、手机号和角色")
    @GetMapping("/page")
    public Page<User> getUserPage(
            @RequestParam int pageNum,
            @RequestParam int pageSize,
            @RequestParam(required = false) String nickname,
            @RequestParam(required = false) String phone,
            @RequestParam(required = false) Integer role) {

        // 调用 UserService 分页查询方法
        return userService.getUserPage(pageNum, pageSize, nickname, phone, role);
    }

    /**
     * 按条件查询所有用户
     */
    @GetMapping("/search")
    public List<User> searchUsers(
            @RequestParam(required = false) String nickname,
            @RequestParam(required = false) String phone,
            @RequestParam(required = false) Integer role) {

        return userService.searchUsers(nickname, phone, role);
    }


    /**
     * 更新用户信息
     */
//    @PutMapping("/update")
//    public ResponseEntity<Result<UserVO>> updateUser(@RequestBody UserVO userVO) {
//        // 使用 MapStruct 转换
//        User user = UserConvert.INSTANCE.convert(userVO);
//
//        boolean isUpdated = userService.updateUser(user);  // 调用更新方法
//
//        if (isUpdated) {
//            // 更新成功，返回 UserVO
//            return ResponseEntity.ok(Result.ok(userVO));
//        } else {
//            // 更新失败
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Result.error("更新失败"));
//        }
//    }
// 后端的 API 接口
//    @PutMapping("/update")
//    public Result<UserVO> updateUser(@RequestBody UserVO userVO) {
//        System.out.println("接收到的用户数据: " + userVO);
//
//        if (userVO.getPkId() == null) {
//            return Result.error("pkId 不能为空");
//        }
//
//        // 使用转换类将 UserVO 转换为 User
//        User user = UserConvert.INSTANCE.convert(userVO);
//
//        // 调用服务层进行更新
//        boolean isUpdated = userService.updateUser(user);
//
//        return isUpdated ? Result.ok() : Result.error("更新失败");
//
//    }


    @PutMapping("/update")
    public Result<?> updateUser(@RequestBody UserVO userVO) {
        // 打印原始请求体内容
//        try {
//            String requestBody = new String(request.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
//            System.out.println("接收到的原始请求体：" + requestBody);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // 打印接收到的 UserVO 数据
        System.out.println("接收到的用户数据: " + userVO.getNickname());

        // 后续代码逻辑
        if (userVO.getPkId() == null) {
            return Result.error("pkId 不能为空");
        }

        // 假设你有一个转换类 UserConvert，将 UserVO 转换为 User
        User user = UserConvert.INSTANCE.convert(userVO);

        // 假设你有一个 userService 调用服务层进行更新
        boolean isUpdated = userService.updateUser(user);

        // 返回更新结果
        return isUpdated ? Result.ok() : Result.error("更新失败");
    }


//    @PostMapping("/update")
//    public Result<String> updateUser(@RequestBody Map<String, Object> requestBody, HttpServletRequest request) {
//        // 打印原始请求体内容
//        try {
//            String requestBodyStr = new String(request.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
//            System.out.println("接收到的原始请求体：" + requestBodyStr);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        // 打印接收到的 Map 数据
//        System.out.println("接收到的用户数据: " + requestBody);
//
//        // 从 requestBody 中获取字段值
//        Long pkId = (Long) requestBody.get("pkId");
//        String nickname = (String) requestBody.get("nickname");
//        String phone = (String) requestBody.get("phone");
//        String slogan = (String) requestBody.get("slogan");
//        Integer role = (Integer) requestBody.get("role");
//        Integer isEnable = (Integer) requestBody.get("isEnable");
//        String avatar = (String) requestBody.get("avatar");
//
//        // 校验 pkId 是否为空
//        if (pkId == null) {
//            return Result.error("pkId 不能为空");
//        }
//
//        // 其他字段的校验，例如 nickname 或 phone 是否有效等
//        if (nickname == null || nickname.isEmpty()) {
//            return Result.error("nickname 不能为空");
//        }
//
//        if (phone == null || phone.isEmpty()) {
//            return Result.error("phone 不能为空");
//        }
//
//        if (role == null) {
//            return Result.error("role 不能为空");
//        }
//
//        if (isEnable == null) {
//            return Result.error("isEnable 不能为空");
//        }
//
//
//        // 创建 User 对象并设置字段
//        User user = new User();
//        user.setPkId(pkId);
//        user.setNickname(nickname);
//        user.setPhone(phone);
//        user.setSlogan(slogan);
//        user.setRole(role);
//        user.setIsEnable(isEnable);  // 根据传入的 0 或 1 转换为布尔值
//        user.setAvatar(avatar);
//
//        // 假设你有一个 userService 来处理数据库更新
//        boolean isUpdated = userService.updateUser(user);
//
//        // 返回字符串消息
//        if (isUpdated) {
//            return Result.ok("用户信息更新成功");
//        } else {
//            return Result.error("用户信息更新失败");
//        }
//    }




}
