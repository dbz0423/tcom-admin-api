package top.zhu.tcomadminapi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.zhu.tcomadminapi.model.entity.Menu;
import top.zhu.tcomadminapi.model.vo.MenuVO;
import top.zhu.tcomadminapi.security.user.ManagerDetail;

import java.util.List;

public interface MenuService extends IService<Menu> {
    List<MenuVO> getMenus();
    /**
     * 用户菜单列表
     */
    List<MenuVO> getManagerMenuList(ManagerDetail manager);

    public Menu saveMenu(MenuVO menuVO);

    public Menu update(MenuVO menuVO);

    public void delete(Integer id);
}
