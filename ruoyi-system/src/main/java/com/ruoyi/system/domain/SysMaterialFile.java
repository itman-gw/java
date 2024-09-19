package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 材料文件关联对象 sys_material_file
 * 
 * @author ruoyi
 * @date 2024-09-19
 */
public class SysMaterialFile extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 材料ID */
    @Excel(name = "材料ID")
    private Long materialId;

    /** 文件ID */
    @Excel(name = "文件ID")
    private Long fileId;

    public void setMaterialId(Long materialId) 
    {
        this.materialId = materialId;
    }

    public Long getMaterialId() 
    {
        return materialId;
    }
    public void setFileId(Long fileId) 
    {
        this.fileId = fileId;
    }

    public Long getFileId() 
    {
        return fileId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("materialId", getMaterialId())
            .append("fileId", getFileId())
            .toString();
    }
}
