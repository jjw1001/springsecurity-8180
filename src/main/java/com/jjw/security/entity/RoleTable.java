package com.jjw.security.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author ange
 * @since 2020-11-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_role_table")
@ApiModel(value="RoleTable对象", description="")
public class RoleTable implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "role_id", type = IdType.AUTO)
    private String roleId;

    @ApiModelProperty(value = "角色ID")
    private String roleName;

    @ApiModelProperty(value = "描述")
    private String description;


}
