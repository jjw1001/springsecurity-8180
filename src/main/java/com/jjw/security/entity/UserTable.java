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
@TableName("sys_user_table")
@ApiModel(value="UserTable对象", description="")
public class UserTable implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "user_id", type = IdType.AUTO)
    private String userId;

    @ApiModelProperty(value = "用户名称")
    private String userName;

    @ApiModelProperty(value = "用户密码-BCR算法加密")
    private String passWord;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "状态")
    private Integer state;


}
