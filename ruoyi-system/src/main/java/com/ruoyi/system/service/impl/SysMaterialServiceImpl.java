package com.ruoyi.system.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.collection.CollectionUtil;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.system.domain.SysFile;
import com.ruoyi.system.domain.SysMaterialFile;
import com.ruoyi.system.mapper.SysFileMapper;
import com.ruoyi.system.mapper.SysMaterialFileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysMaterialMapper;
import com.ruoyi.system.domain.SysMaterial;
import com.ruoyi.system.service.ISysMaterialService;
import com.ruoyi.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-09-14
 */
@Service
public class SysMaterialServiceImpl implements ISysMaterialService 
{
    @Autowired
    private SysMaterialMapper sysMaterialMapper;
    @Autowired
    private SysMaterialFileMapper sysMaterialFileMapper;

    @Autowired
    private SysFileMapper  sysFileMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param materialId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public SysMaterial selectSysMaterialByMaterialId(Long materialId)
    {
        SysMaterial sysMaterial = sysMaterialMapper.selectSysMaterialByMaterialId(materialId);
        List<SysFile> fileList = sysFileMapper.selectSysFileListByMaterialId(materialId);
        List<Long> fileIds = fileList.stream().map(SysFile::getFileId).collect(Collectors.toList());
        sysMaterial.setFileList(fileList);
        sysMaterial.setFileIds(fileIds);
        return sysMaterial;
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param sysMaterial 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<SysMaterial> selectSysMaterialList(SysMaterial sysMaterial)
    {
        List<SysMaterial> list = sysMaterialMapper.selectSysMaterialList(sysMaterial);
        for(SysMaterial sysMater : list){
            List<SysFile> sysFiles = sysFileMapper.selectSysFileListByMaterialId(sysMater.getMaterialId());
            sysMater.setFileList(sysFiles);
        }
        return list;
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param sysMaterial 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertSysMaterial(SysMaterial sysMaterial)
    {
        sysMaterial.setCreateBy(ShiroUtils.getSysUser().getUserName());
        sysMaterial.setCreateTime(new Date());
        sysMaterial.setUserId(ShiroUtils.getUserId());
        sysMaterialMapper.insertSysMaterial(sysMaterial);

        List<SysMaterialFile> list = new ArrayList<>();
        List<Long> fileIds = sysMaterial.getFileIds();
        for (Long fileId : fileIds){
            SysMaterialFile sysMaterialFile = new SysMaterialFile();
            sysMaterialFile.setMaterialId(sysMaterial.getMaterialId());
            sysMaterialFile.setFileId(fileId);
            list.add(sysMaterialFile);
        }
        return sysMaterialFileMapper.batchInsertMaterialFile(list);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param sysMaterial 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateSysMaterial(SysMaterial sysMaterial)
    {
        sysMaterial.setUpdateBy(ShiroUtils.getSysUser().getUserName());
        sysMaterial.setUpdateTime(new Date());
        sysMaterialMapper.updateSysMaterial(sysMaterial);
        List<SysMaterialFile> list = new ArrayList<>();
        List<Long> fileIds = sysMaterial.getFileIds();
        //将原有的附件关联信息删除
        sysMaterialFileMapper.deleteSysMaterialFileByMaterialId(sysMaterial.getMaterialId());
        for (Long fileId : fileIds){
            SysMaterialFile sysMaterialFile = new SysMaterialFile();
            sysMaterialFile.setMaterialId(sysMaterial.getMaterialId());
            sysMaterialFile.setFileId(fileId);
            list.add(sysMaterialFile);
        }
        return sysMaterialFileMapper.batchInsertMaterialFile(list);

    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param materialIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSysMaterialByMaterialIds(String materialIds)
    {
        return sysMaterialMapper.deleteSysMaterialByMaterialIds(Convert.toStrArray(materialIds));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param materialId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSysMaterialByMaterialId(Long materialId)
    {
        return sysMaterialMapper.deleteSysMaterialByMaterialId(materialId);
    }
}
