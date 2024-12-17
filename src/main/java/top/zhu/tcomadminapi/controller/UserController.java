package top.zhu.tcomadminapi.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
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
    @PostMapping("/update")
    public Result<UserVO> updateUser(@RequestBody UserVO userVO) {
        System.out.println("接收到的用户数据: " + userVO);

        if (userVO.getPkId() == null) {
            return Result.error("pkId 不能为空");
        }

        // 使用转换类将 UserVO 转换为 User
        User user = UserConvert.INSTANCE.convert(userVO);

        // 调用服务层进行更新
        boolean isUpdated = userService.updateUser(user);

        return isUpdated ? Result.ok() : Result.error("更新失败");

    }


//    @Operation(summary = "更新用户信息", description = "根据用户对象更新用户信息")
//    @PutMapping("/update")
//    public ResponseEntity<Map<String, Object>> updateUser(@RequestBody UserVO userVO) {
//        Map<String, Object> response = new HashMap<>();
//        try {
//            // 打印接收到的参数，用于调试
//            System.out.println("接收到的用户数据: " + userVO);
//
//            // 将 UserVO 转换为 User 实体
//            User user = UserConvert.INSTANCE.convert(userVO);
//
//            // 调用服务层方法进行用户更新
//            boolean updated = userService.updateUser(user);
//
//            // 根据更新结果返回相应信息
//            if (updated) {
//                response.put("code", 0);
//                response.put("msg", "用户信息更新成功");
//            } else {
//                response.put("code", 1);
//                response.put("msg", "用户信息更新失败");
//            }
//        } catch (IllegalArgumentException e) {
//            // 处理请求参数问题
//            response.put("code", 2);
//            response.put("msg", "无效的用户数据");
//        } catch (Exception e) {
//            // 处理其他异常
//            response.put("code", 500);
//            response.put("msg", "服务器内部错误");
//            e.printStackTrace(); // 打印详细错误日志
//        }
//        return ResponseEntity.ok(response);
//    }




}
