package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysMaterial;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2024-09-14
 */
public interface ISysMaterialService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param materialId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public SysMaterial selectSysMaterialByMaterialId(Long materialId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param sysMaterial 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<SysMaterial> selectSysMaterialList(SysMaterial sysMaterial);

    /**
     * 新增【请填写功能名称】
     * 
     * @param sysMaterial 【请填写功能名称】
     * @return 结果
     */
    public int insertSysMaterial(SysMaterial sysMaterial);

    /**
     * 修改【请填写功能名称】
     * 
     * @param sysMaterial 【请填写功能名称】
     * @return 结果
     */
    public int updateSysMaterial(SysMaterial sysMaterial);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param materialIds 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteSysMaterialByMaterialIds(String materialIds);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param materialId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteSysMaterialByMaterialId(Long materialId);
}
