package top.zhu.tcomadminapi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.zhu.tcomadminapi.common.model.BaseServiceImpl;
import top.zhu.tcomadminapi.common.result.PageResult;
import top.zhu.tcomadminapi.convert.SysRoleConvert;
import top.zhu.tcomadminapi.mapper.SysRoleMapper;
import top.zhu.tcomadminapi.model.entity.SysRole;
import top.zhu.tcomadminapi.model.query.SysRoleQuery;
import top.zhu.tcomadminapi.model.vo.SysRoleVO;
import top.zhu.tcomadminapi.service.SysRoleService;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class SysRoleServiceImpl extends BaseServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Override
    public PageResult<SysRoleVO> page(SysRoleQuery query) {
        Page<SysRoleVO> page = new Page<>(query.getPage(),query.getLimit());
        List<SysRoleVO> list = baseMapper.getRolePage(page, query);
        return new PageResult<>(list, page.getTotal());
    }

    @Override
    public List<SysRoleVO> getList(SysRoleQuery query) {
        LambdaQueryWrapper<SysRole> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.select(SysRole::getPkId, SysRole::getName, SysRole::getDes, SysRole::getType, SysRole::getCreateTime, SysRole::getUpdateTime);
        List<SysRole> entityList = baseMapper.selectList(queryWrapper);
        return SysRoleConvert.INSTANCE.convertList(entityList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(SysRoleVO vo) {
        SysRole entity = SysRoleConvert.INSTANCE.convert(vo);
        // 保存角色
        entity.setCreateTime(LocalDateTime.now());
        entity.setUpdateTime(LocalDateTime.now());
        baseMapper.insert(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysRoleVO vo) {
        SysRole entity = SysRoleConvert.INSTANCE.convert(vo);

        UpdateWrapper<SysRole> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("pk_id", entity.getPkId());
        updateWrapper.set("name", entity.getName());
        updateWrapper.set("des", entity.getDes());
        updateWrapper.set("create_time", entity.getCreateTime());
        updateWrapper.set("update_time", entity.getUpdateTime());

        update(updateWrapper);

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Integer> idList) {
        // 删除角色
        removeByIds(idList);

    }
}
