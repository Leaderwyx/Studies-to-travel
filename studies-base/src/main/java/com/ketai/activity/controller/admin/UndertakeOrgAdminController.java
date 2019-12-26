package com.ketai.activity.controller.admin;

import com.ketai.activity.pojo.UndertakeOrg;
import com.ketai.activity.service.UndertakeOrgService;
import entity.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 研学承办机构(新增，修改，删除)相关操作
 *
 * @author Childe Liao
 * @since 2019/12/24
 */
@Api(tags = "研学承办机构(新增，修改，删除)相关操作")
@RestController
@RequestMapping("/admin/base/undertakeOrg")
public class UndertakeOrgAdminController {

    @Autowired
    private UndertakeOrgService undertakeOrgService;

    @PostMapping("/saveUndertakeOrgInfo")
    @ApiImplicitParam(paramType = "query", name = "undertakeOrg", value = "研学承办机构对象", dataType = "Object")
    public Result saveUndertakeOrgInfo(UndertakeOrg undertakeOrg) {
        boolean save = undertakeOrgService.save(undertakeOrg);
        return Result.ok().success(save);
    }

}
