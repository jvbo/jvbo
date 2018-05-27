/*
 * UcMemberController.java 2018年4月12日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.practice.module.ucenter.controller;

import java.util.List;

import javax.validation.constraints.NotBlank;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.ResultCollectors;
import com.jvbo.springboot.practice.core.enums.ResponseStatusEnum;
import com.jvbo.springboot.practice.core.model.UcMember;
import com.jvbo.springboot.practice.core.model.UcMemberExample;
import com.jvbo.springboot.practice.core.service.IUcMemberService;
import com.jvbo.springboot.practice.framework.annotation.ControllerLog;
import com.jvbo.springboot.practice.framework.exception.ControllerException;
import com.jvbo.springboot.practice.framework.mybatis.page.DataGrid;
import com.jvbo.springboot.practice.framework.response.Response;
import com.jvbo.springboot.practice.framework.response.ResponseBuilder;
import com.jvbo.springboot.practice.framework.validator.LengthValidator;
import com.jvbo.springboot.practice.module.ucenter.vo.UcMemberVo;

@RestController
@RequestMapping("/ucenter/member")
public class UcMemberController {
    
    @Autowired
    private IUcMemberService ucMemberService;
    
    @ControllerLog("fuck you!!!!")
    @RequestMapping(value = "/datagridStartPage", method = RequestMethod.GET)
    public Response<DataGrid<UcMember>> datagridStartPage(
            @RequestParam(required = false, defaultValue = "1", value = "pageNum") int pageNum,
            @RequestParam(required = false, defaultValue = "10", value = "pageSize") int pageSize,
            @RequestParam(required = false, defaultValue = "gmt_created", value = "sort") String sort,
            @RequestParam(required = false, defaultValue = "desc", value = "order") String order) {
        return ResponseBuilder.create().defaultError(ResponseStatusEnum.ERR_LOAD.getCode(), "加载出错!").buildResponse(() -> {
            UcMemberExample ucMemberExample = new UcMemberExample();
            if (StringUtils.isNotBlank(sort)&& !StringUtils.isBlank(order)) {
                ucMemberExample.setOrderByClause(sort + " " + order);
            }
            return ucMemberService.selectByExampleForStartPageDatagrid(ucMemberExample, pageNum, pageSize);
        });
    }
    
    @RequestMapping(value = "/datagridOffset", method = RequestMethod.GET)
    public Response<DataGrid<UcMember>> datagridOffset(
            @RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
            @RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
            @RequestParam(required = false, value = "gmt_created") String sort,
            @RequestParam(required = false, value = "desc") String order) {
        return ResponseBuilder.create().defaultError(ResponseStatusEnum.ERR_LOAD.getCode(), "加载出错!").buildResponse(() -> {
            UcMemberExample ucMemberExample = new UcMemberExample();
            if (StringUtils.isNotBlank(sort)&& !StringUtils.isBlank(order)) {
                ucMemberExample.setOrderByClause(sort + " " + order);
            }
            return ucMemberService.selectByExampleForOffsetPageDatagrid(ucMemberExample, offset, limit);
        });
    }
    
    @RequestMapping(value = "/listStartPage", method = RequestMethod.GET)
    public Response<List<UcMember>> listStartPage(
            @RequestParam(required = false, defaultValue = "1", value = "pageNum") int pageNum,
            @RequestParam(required = false, defaultValue = "10", value = "pageSize") int pageSize,
            @RequestParam(required = false, defaultValue = "gmt_created", value = "sort") String sort,
            @RequestParam(required = false, defaultValue = "desc", value = "order") String order) {
        return ResponseBuilder.create().defaultError(ResponseStatusEnum.ERR_LOAD.getCode(), "加载出错!").buildResponse(() -> {
            UcMemberExample ucMemberExample = new UcMemberExample();
            if (StringUtils.isNotBlank(sort)&& !StringUtils.isBlank(order)) {
                ucMemberExample.setOrderByClause(sort + " " + order);
            }
            return ucMemberService.selectByExampleForStartPage(ucMemberExample, pageNum, pageSize);
        });
    }
    
    @RequestMapping(value = "/listOffset", method = RequestMethod.GET)
    public Response<List<UcMember>> listOffset(
            @RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
            @RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
            @RequestParam(required = false, value = "gmt_created") String sort,
            @RequestParam(required = false, value = "desc") String order) {
        return ResponseBuilder.create().defaultError(ResponseStatusEnum.ERR_LOAD.getCode(), "加载出错!").buildResponse(() -> {
            UcMemberExample ucMemberExample = new UcMemberExample();
            if (StringUtils.isNotBlank(sort)&& !StringUtils.isBlank(order)) {
                ucMemberExample.setOrderByClause(sort + " " + order);
            }
            return ucMemberService.selectByExampleForOffsetPage(ucMemberExample, offset, limit);
        });
    }
    
    @RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
    public Response<UcMember> find(@PathVariable("id") String id) {
        return ResponseBuilder.create().defaultError(ResponseStatusEnum.ERR_LOAD.getCode(), "加载出错!").buildResponse(() -> {
            return ucMemberService.selectByPrimaryKey(id);
        });
    }
    
    @ControllerLog("新建")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Response<Boolean> create(@Validated UcMemberVo ucMemberVo, BindingResult bindingResult) {
        return ResponseBuilder.create().defaultError(ResponseStatusEnum.ERR_CREATE.getCode(), "操作出错!").buildResponse(() -> {
            if(bindingResult.hasErrors())
                throw new ControllerException(ResponseStatusEnum.ERR_DATA_FORMAT.getCode(), bindingResult.getFieldError().getDefaultMessage());
            UcMember record = new UcMember();
            BeanUtils.copyProperties(ucMemberVo, record);
            return ucMemberService.insertSelective(record) > 0;
        });
    }
    
    @ControllerLog("修改")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public Response<Boolean> modify(@PathVariable("id") @NotBlank String id, UcMemberVo ucMemberVo) {
        return ResponseBuilder.create().defaultError(ResponseStatusEnum.ERR_UPDATE.getCode(), "操作出错!").buildResponse(() -> {
            ComplexResult result = FluentValidator.checkAll()
                    .on(ucMemberVo.getNickName(), new LengthValidator(1, 20, "昵称"))
                    .doValidate()
                    .result(ResultCollectors.toComplex());
            if (!result.isSuccess()) {

            }
            ucMemberVo.setMemberId(id);
            UcMember record = new UcMember();
            BeanUtils.copyProperties(ucMemberVo, record);
            return ucMemberService.updateByPrimaryKeySelective(record) > 0;
        });
    }
    
    @ControllerLog("删除")
    @RequestMapping(value = "/delete/{ids}", method = RequestMethod.POST)
    public Response<Boolean> delete(@PathVariable("ids") String ids) {
        return ResponseBuilder.create().defaultError(ResponseStatusEnum.ERR_DELETE.getCode(), "操作出错!").buildResponse(() -> {
            return ucMemberService.deleteByPrimaryKeys(ids) > 0;
        });
    }
    
    
}
