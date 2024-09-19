package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysMaterialFile;

/**
 * 材料文件关联Service接口
 * 
 * @author ruoyi
 * @date 2024-09-19
 */
public interface ISysMaterialFileService 
{
    /**
     * 查询材料文件关联
     * 
     * @param materialId 材料文件关联主键
     * @return 材料文件关联
     */
    public SysMaterialFile selectSysMaterialFileByMaterialId(Long materialId);

    /**
     * 查询材料文件关联列表
     * 
     * @param sysMaterialFile 材料文件关联
     * @return 材料文件关联集合
     */
    public List<SysMaterialFile> selectSysMaterialFileList(SysMaterialFile sysMaterialFile);

    /**
     * 新增材料文件关联
     * 
     * @param sysMaterialFile 材料文件关联
     * @return 结果
     */
    public int insertSysMaterialFile(SysMaterialFile sysMaterialFile);

    /**
     * 修改材料文件关联
     * 
     * @param sysMaterialFile 材料文件关联
     * @return 结果
     */
    public int updateSysMaterialFile(SysMaterialFile sysMaterialFile);

    /**
     * 批量删除材料文件关联
     * 
     * @param materialIds 需要删除的材料文件关联主键集合
     * @return 结果
     */
    public int deleteSysMaterialFileByMaterialIds(String materialIds);

    /**
     * 删除材料文件关联信息
     * 
     * @param materialId 材料文件关联主键
     * @return 结果
     */
    public int deleteSysMaterialFileByMaterialId(Long materialId);
}
