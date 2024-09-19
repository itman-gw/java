package com.ruoyi.web.controller.system;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SysMaterialFile;
import com.ruoyi.system.service.ISysMaterialFileService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 材料文件关联Controller
 * 
 * @author ruoyi
 * @date 2024-09-19
 */
@Controller
@RequestMapping("/system/file")
public class SysMaterialFileController extends BaseController
{
    private String prefix = "system/file";

    @Autowired
    private ISysMaterialFileService sysMaterialFileService;

    @RequiresPermissions("system:file:view")
    @GetMapping()
    public String file()
    {
        return prefix + "/file";
    }

    /**
     * 查询材料文件关联列表
     */
    @RequiresPermissions("system:file:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysMaterialFile sysMaterialFile)
    {
        startPage();
        List<SysMaterialFile> list = sysMaterialFileService.selectSysMaterialFileList(sysMaterialFile);
        return getDataTable(list);
    }

    /**
     * 导出材料文件关联列表
     */
    @RequiresPermissions("system:file:export")
    @Log(title = "材料文件关联", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysMaterialFile sysMaterialFile)
    {
        List<SysMaterialFile> list = sysMaterialFileService.selectSysMaterialFileList(sysMaterialFile);
        ExcelUtil<SysMaterialFile> util = new ExcelUtil<SysMaterialFile>(SysMaterialFile.class);
        return util.exportExcel(list, "材料文件关联数据");
    }

    /**
     * 新增材料文件关联
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存材料文件关联
     */
    @RequiresPermissions("system:file:add")
    @Log(title = "材料文件关联", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysMaterialFile sysMaterialFile)
    {
        return toAjax(sysMaterialFileService.insertSysMaterialFile(sysMaterialFile));
    }

    /**
     * 修改材料文件关联
     */
    @RequiresPermissions("system:file:edit")
    @GetMapping("/edit/{materialId}")
    public String edit(@PathVariable("materialId") Long materialId, ModelMap mmap)
    {
        SysMaterialFile sysMaterialFile = sysMaterialFileService.selectSysMaterialFileByMaterialId(materialId);
        mmap.put("sysMaterialFile", sysMaterialFile);
        return prefix + "/edit";
    }

    /**
     * 修改保存材料文件关联
     */
    @RequiresPermissions("system:file:edit")
    @Log(title = "材料文件关联", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysMaterialFile sysMaterialFile)
    {
        return toAjax(sysMaterialFileService.updateSysMaterialFile(sysMaterialFile));
    }

    /**
     * 删除材料文件关联
     */
    @RequiresPermissions("system:file:remove")
    @Log(title = "材料文件关联", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysMaterialFileService.deleteSysMaterialFileByMaterialIds(ids));
    }
}
