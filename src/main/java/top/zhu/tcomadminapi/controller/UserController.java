package top.zhu.tcomadminapi.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.zhu.tcomadminapi.model.entity.User;
import top.zhu.tcomadminapi.service.UserService;

import java.util.List;

/**
 * 用户管理
 */
@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 新增用户
     */
    @Operation(summary = "新增用户", description = "创建一个新的用户")
    @PostMapping
    public String addUser(@RequestBody @Parameter(description = "用户对象") User user) {
        return userService.addUser(user) ? "用户新增成功" : "用户新增失败";
    }

    /**
     * 删除用户
     */
    @Operation(summary = "删除用户", description = "根据用户 ID 删除用户")
    @DeleteMapping("/{id}")
    public String deleteUser(@Parameter(description = "用户 ID") @PathVariable Long id) {
        return userService.deleteUser(id) ? "用户删除成功" : "用户删除失败";
    }

    /**
     * 更新用户信息
     */
    @Operation(summary = "更新用户信息", description = "根据用户对象更新用户信息")
    @PutMapping
    public String updateUser(@RequestBody @Parameter(description = "用户对象") User user) {
        return userService.updateUser(user) ? "用户更新成功" : "用户更新失败";
    }

    /**
     * 查询所有用户
     */
    @Operation(summary = "查询所有用户", description = "获取所有用户的列表")
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    /**
     * 根据 ID 查询用户
     */
    @Operation(summary = "根据 ID 查询用户", description = "根据用户 ID 获取用户信息")
    @GetMapping("/{id}")
    public User getUserById(@Parameter(description = "用户 ID") @PathVariable Long id) {
        return userService.getUserById(id);
    }

    /**
     * 根据条件查询用户
     */
    @Operation(summary = "根据条件查询用户", description = "根据用户的昵称、手机号或角色查询用户")
    @GetMapping("/search")
    public List<User> searchUsers(
            @Parameter(description = "用户昵称") @RequestParam(required = false) String nickname,
            @Parameter(description = "用户手机号") @RequestParam(required = false) String phone,
            @Parameter(description = "用户角色") @RequestParam(required = false) Integer role) {
        return userService.searchUsers(nickname, phone, role);
    }

    /**
     * 分页查询用户
     */
    @Operation(summary = "分页查询用户", description = "分页查询用户信息")
    @GetMapping("/page")
    public Page<User> getUserPage(
            @Parameter(description = "当前页码") @RequestParam int pageNum,
            @Parameter(description = "每页条数") @RequestParam int pageSize) {
        return userService.getUserPage(pageNum, pageSize);
    }
}
