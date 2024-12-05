package top.zhu.tcomadminapi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import top.zhu.tcomadminapi.model.entity.Menu;

import java.util.List;

public interface MenuMapper extends BaseMapper<Menu> {
    /**
     * 查询所有菜单列表
     */
    List<Menu> getMenuList();

    /**
     * 查询用户菜单列表
     *
     * @param managerId 用户ID
     */
    List<Menu> getManagerMenuList(@Param("managerId") Integer managerId , @Param("isEq") boolean isEq);
}
