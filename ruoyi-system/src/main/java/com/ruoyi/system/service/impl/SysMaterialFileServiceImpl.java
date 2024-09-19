package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysMaterialFileMapper;
import com.ruoyi.system.domain.SysMaterialFile;
import com.ruoyi.system.service.ISysMaterialFileService;
import com.ruoyi.common.core.text.Convert;

/**
 * 材料文件关联Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-09-19
 */
@Service
public class SysMaterialFileServiceImpl implements ISysMaterialFileService 
{
    @Autowired
    private SysMaterialFileMapper sysMaterialFileMapper;

    /**
     * 查询材料文件关联
     * 
     * @param materialId 材料文件关联主键
     * @return 材料文件关联
     */
    @Override
    public SysMaterialFile selectSysMaterialFileByMaterialId(Long materialId)
    {
        return sysMaterialFileMapper.selectSysMaterialFileByMaterialId(materialId);
    }

    /**
     * 查询材料文件关联列表
     * 
     * @param sysMaterialFile 材料文件关联
     * @return 材料文件关联
     */
    @Override
    public List<SysMaterialFile> selectSysMaterialFileList(SysMaterialFile sysMaterialFile)
    {
        return sysMaterialFileMapper.selectSysMaterialFileList(sysMaterialFile);
    }

    /**
     * 新增材料文件关联
     * 
     * @param sysMaterialFile 材料文件关联
     * @return 结果
     */
    @Override
    public int insertSysMaterialFile(SysMaterialFile sysMaterialFile)
    {
        return sysMaterialFileMapper.insertSysMaterialFile(sysMaterialFile);
    }

    /**
     * 修改材料文件关联
     * 
     * @param sysMaterialFile 材料文件关联
     * @return 结果
     */
    @Override
    public int updateSysMaterialFile(SysMaterialFile sysMaterialFile)
    {
        return sysMaterialFileMapper.updateSysMaterialFile(sysMaterialFile);
    }

    /**
     * 批量删除材料文件关联
     * 
     * @param materialIds 需要删除的材料文件关联主键
     * @return 结果
     */
    @Override
    public int deleteSysMaterialFileByMaterialIds(String materialIds)
    {
        return sysMaterialFileMapper.deleteSysMaterialFileByMaterialIds(Convert.toStrArray(materialIds));
    }

    /**
     * 删除材料文件关联信息
     * 
     * @param materialId 材料文件关联主键
     * @return 结果
     */
    @Override
    public int deleteSysMaterialFileByMaterialId(Long materialId)
    {
        return sysMaterialFileMapper.deleteSysMaterialFileByMaterialId(materialId);
    }
}
