package cn.nezha.common.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * NZFieldProperty注解处理器
 * 用于将NZFieldProperty注解信息转换为ExcelProperty和Schema注解相关信息
 */
public class NZFieldPropertyProcessor {

    /**
     * 提取字段的Excel属性信息
     * 
     * @param field 需要提取的字段
     * @return Excel属性信息Map
     */
    public static Map<String, Object> extractExcelProperty(Field field) {
        Map<String, Object> result = new HashMap<>();
        
        if (field.isAnnotationPresent(NZFieldProperty.class)) {
            NZFieldProperty annotation = field.getAnnotation(NZFieldProperty.class);
            
            result.put("value", annotation.value());
            result.put("order", annotation.order());
            result.put("ignore", annotation.ignore());
        }
        
        return result;
    }
    
    /**
     * 提取字段的Swagger属性信息
     * 
     * @param field 需要提取的字段
     * @return Swagger属性信息Map
     */
    public static Map<String, Object> extractSwaggerProperty(Field field) {
        Map<String, Object> result = new HashMap<>();
        
        if (field.isAnnotationPresent(NZFieldProperty.class)) {
            NZFieldProperty annotation = field.getAnnotation(NZFieldProperty.class);
            
            result.put("description", annotation.description());
            result.put("required", annotation.required());
            result.put("example", annotation.example());
            result.put("type", annotation.type());
            result.put("format", annotation.format());
        }
        
        return result;
    }
    
    /**
     * 检查字段是否有NZFieldProperty注解
     * 
     * @param field 需要检查的字段
     * @return 是否有NZFieldProperty注解
     */
    public static boolean hasNZFieldProperty(Field field) {
        return field.isAnnotationPresent(NZFieldProperty.class);
    }
} 