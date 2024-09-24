package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysFile;

/**
 * 文件信息Service接口
 * 
 * @author ruoyi
 * @date 2024-09-13
 */
public interface ISysFileService 
{
    /**
     * 查询文件信息
     * 
     * @param fileId 文件信息主键
     * @return 文件信息
     */
    public SysFile selectSysFileByFileId(Long fileId);

    /**
     * 查询文件信息列表
     * 
     * @param sysFile 文件信息
     * @return 文件信息集合
     */
    public List<SysFile> selectSysFileList(SysFile sysFile);

    /**
     * 新增文件信息
     * 
     * @param sysFile 文件信息
     * @return 结果
     */
    public int insertSysFile(SysFile sysFile);

    /**
     * 修改文件信息
     * 
     * @param sysFile 文件信息
     * @return 结果
     */
    public int updateSysFile(SysFile sysFile);

    /**
     * 批量删除文件信息
     * 
     * @param fileIds 需要删除的文件信息主键集合
     * @return 结果
     */
    public int deleteSysFileByFileIds(String fileIds);

    /**
     * 删除文件信息信息
     * 
     * @param fileId 文件信息主键
     * @return 结果
     */
    public int deleteSysFileByFileId(Long fileId);

    int batchInsertSysFile(List<SysFile> sysFileList);
}
