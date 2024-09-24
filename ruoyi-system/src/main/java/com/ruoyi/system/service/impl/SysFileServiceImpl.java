package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysFileMapper;
import com.ruoyi.system.domain.SysFile;
import com.ruoyi.system.service.ISysFileService;
import com.ruoyi.common.core.text.Convert;

/**
 * 文件信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-09-13
 */
@Service
public class SysFileServiceImpl implements ISysFileService 
{
    @Autowired
    private SysFileMapper sysFileMapper;

    /**
     * 查询文件信息
     * 
     * @param fileId 文件信息主键
     * @return 文件信息
     */
    @Override
    public SysFile selectSysFileByFileId(Long fileId)
    {
        return sysFileMapper.selectSysFileByFileId(fileId);
    }

    /**
     * 查询文件信息列表
     * 
     * @param sysFile 文件信息
     * @return 文件信息
     */
    @Override
    public List<SysFile> selectSysFileList(SysFile sysFile)
    {
        return sysFileMapper.selectSysFileList(sysFile);
    }

    /**
     * 新增文件信息
     * 
     * @param sysFile 文件信息
     * @return 结果
     */
    @Override
    public int insertSysFile(SysFile sysFile)
    {
        sysFile.setCreateTime(DateUtils.getNowDate());
        sysFile.setUserId(ShiroUtils.getUserId());
        return sysFileMapper.insertSysFile(sysFile);
    }

    /**
     * 修改文件信息
     * 
     * @param sysFile 文件信息
     * @return 结果
     */
    @Override
    public int updateSysFile(SysFile sysFile)
    {
        sysFile.setUpdateTime(DateUtils.getNowDate());
        return sysFileMapper.updateSysFile(sysFile);
    }

    /**
     * 批量删除文件信息
     * 
     * @param fileIds 需要删除的文件信息主键
     * @return 结果
     */
    @Override
    public int deleteSysFileByFileIds(String fileIds)
    {
        return sysFileMapper.deleteSysFileByFileIds(Convert.toStrArray(fileIds));
    }

    /**
     * 删除文件信息信息
     * 
     * @param fileId 文件信息主键
     * @return 结果
     */
    @Override
    public int deleteSysFileByFileId(Long fileId)
    {
        return sysFileMapper.deleteSysFileByFileId(fileId);
    }

    @Override
    public int batchInsertSysFile(List<SysFile> sysFileList) {
        return sysFileMapper.batchInsertSysFile(sysFileList);
    }
}
