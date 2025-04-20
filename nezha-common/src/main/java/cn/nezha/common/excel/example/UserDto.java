package cn.nezha.common.excel.example;

import cn.nezha.common.excel.NZFieldProperty;
import lombok.Data;

/**
 * 用户DTO示例类
 * 演示NZFieldProperty注解的使用
 */
@Data
public class UserDto {

    @NZFieldProperty(value = {"用户ID"}, order = 1, description = "用户唯一标识", example = "1001")
    private Long id;

    @NZFieldProperty(value = {"用户名"}, order = 2, description = "用户登录名", required = true, example = "admin")
    private String username;

    @NZFieldProperty(value = {"姓名"}, order = 3, description = "用户真实姓名", example = "张三")
    private String name;
    
    @NZFieldProperty(value = {"年龄"}, order = 4, description = "用户年龄", type = "integer", example = "25")
    private Integer age;
    
    @NZFieldProperty(value = {"邮箱"}, order = 5, description = "用户邮箱地址", format = "email", example = "example@example.com")
    private String email;
    
    @NZFieldProperty(ignore = true, description = "用户密码，导出时忽略")
    private String password;
} 