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
import com.ruoyi.system.domain.SysMaterial;
import com.ruoyi.system.service.ISysMaterialService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 材料信息Controller
 * 
 * @author ruoyi
 * @date 2024-09-14
 */
@Controller
@RequestMapping("/system/material")
public class SysMaterialController extends BaseController
{
    private String prefix = "system/material";

    @Autowired
    private ISysMaterialService sysMaterialService;

    @RequiresPermissions("system:material:view")
    @GetMapping()
    public String material()
    {
        return prefix + "/material";
    }

    /**
     * 查询材料信息列表
     */
    @RequiresPermissions("system:material:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysMaterial sysMaterial)
    {
        startPage();
        List<SysMaterial> list = sysMaterialService.selectSysMaterialList(sysMaterial);
        return getDataTable(list);
    }

    /**
     * 导出材料信息列表
     */
    @RequiresPermissions("system:material:export")
    @Log(title = "材料信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysMaterial sysMaterial)
    {
        List<SysMaterial> list = sysMaterialService.selectSysMaterialList(sysMaterial);
        ExcelUtil<SysMaterial> util = new ExcelUtil<SysMaterial>(SysMaterial.class);
        return util.exportExcel(list, "材料信息数据");
    }

    /**
     * 新增材料信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存材料信息
     */
    @RequiresPermissions("system:material:add")
    @Log(title = "材料信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysMaterial sysMaterial)
    {
        return toAjax(sysMaterialService.insertSysMaterial(sysMaterial));
    }

    /**
     * 修改材料信息
     */
    @RequiresPermissions("system:material:edit")
    @GetMapping("/edit/{materialId}")
    public String edit(@PathVariable("materialId") Long materialId, ModelMap mmap)
    {
        SysMaterial sysMaterial = sysMaterialService.selectSysMaterialByMaterialId(materialId);
        mmap.put("sysMaterial", sysMaterial);
        return prefix + "/edit";
    }

    /**
     * 修改保存材料信息
     */
    @RequiresPermissions("system:material:edit")
    @Log(title = "材料信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysMaterial sysMaterial)
    {
        return toAjax(sysMaterialService.updateSysMaterial(sysMaterial));
    }

    /**
     * 删除材料信息
     */
    @RequiresPermissions("system:material:remove")
    @Log(title = "材料信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysMaterialService.deleteSysMaterialByMaterialIds(ids));
    }
}
