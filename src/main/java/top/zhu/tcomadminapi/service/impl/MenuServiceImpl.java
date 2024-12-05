package top.zhu.tcomadminapi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import top.zhu.tcomadminapi.convert.MenuConvert;
import top.zhu.tcomadminapi.enums.SuperAdminEnum;
import top.zhu.tcomadminapi.mapper.MenuMapper;
import top.zhu.tcomadminapi.model.entity.Menu;
import top.zhu.tcomadminapi.model.vo.MenuVO;
import top.zhu.tcomadminapi.security.user.ManagerDetail;
import top.zhu.tcomadminapi.service.MenuService;
import top.zhu.tcomadminapi.utils.TreeUtils;

import java.util.List;

@Service
@AllArgsConstructor
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
    @Override
    public List<MenuVO> getManagerMenuList(ManagerDetail manager) {
        List<Menu> menuList = baseMapper.getManagerMenuList(manager.getPkId(), false);
        return TreeUtils.build(MenuConvert.INSTANCE.convertList(menuList));
    }

}
