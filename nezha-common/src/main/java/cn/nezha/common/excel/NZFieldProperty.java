package cn.nezha.common.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.lang.annotation.*;

/**
 * 字段属性注解，整合FastExcel的ExcelProperty和Swagger的Schema注解功能
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface NZFieldProperty {
    
    /**
     * Excel属性设置
     */
    String[] value() default {};
    
    /**
     * Excel列顺序
     */
    int order() default Integer.MAX_VALUE;
    
    /**
     * 是否忽略该字段
     */
    boolean ignore() default false;
    
    /**
     * Swagger属性说明
     */
    String description() default "";
    
    /**
     * 是否必填
     */
    boolean required() default false;
    
    /**
     * 示例值
     */
    String example() default "";
    
    /**
     * 数据类型
     */
    String type() default "";
    
    /**
     * 格式
     */
    String format() default "";
}
