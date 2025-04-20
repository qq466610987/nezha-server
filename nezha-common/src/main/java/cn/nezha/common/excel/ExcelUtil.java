package cn.nezha.common.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;

import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.List;

/**
 * Excel导入导出工具类
 * 支持处理使用NZFieldProperty注解的实体类
 */
public class ExcelUtil {
    
    /**
     * 导出Excel
     *
     * @param outputStream 输出流
     * @param dataList     导出数据集合
     * @param clazz        导出数据类型
     * @param <T>          泛型
     */
    public static <T> void exportExcel(OutputStream outputStream, List<T> dataList, Class<T> clazz) {
        ExcelWriterBuilder writerBuilder = EasyExcel.write(outputStream, clazz)
                .excelType(ExcelTypeEnum.XLSX)
                .autoCloseStream(true)
                .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy());
        
        // 设置sheet名称，默认为Sheet1
        writerBuilder.sheet("Sheet1").doWrite(dataList);
    }
    
    /**
     * 导出Excel（带Sheet名称）
     *
     * @param outputStream 输出流
     * @param dataList     导出数据集合
     * @param clazz        导出数据类型
     * @param sheetName    Sheet名称
     * @param <T>          泛型
     */
    public static <T> void exportExcel(OutputStream outputStream, List<T> dataList, Class<T> clazz, String sheetName) {
        ExcelWriterBuilder writerBuilder = EasyExcel.write(outputStream, clazz)
                .excelType(ExcelTypeEnum.XLSX)
                .autoCloseStream(true)
                .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy());
        
        writerBuilder.sheet(sheetName).doWrite(dataList);
    }
    
    /**
     * 导入Excel
     *
     * @param inputStream  输入流
     * @param clazz        导入数据类型
     * @param readListener 导入监听器
     * @param <T>          泛型
     */
    public static <T> void importExcel(InputStream inputStream, Class<T> clazz, ReadListener<T> readListener) {
        EasyExcel.read(inputStream, clazz, readListener)
                .excelType(ExcelTypeEnum.XLSX)
                .autoCloseStream(true)
                .sheet()
                .doRead();
    }
    
    /**
     * 导入Excel（指定Sheet索引）
     *
     * @param inputStream  输入流
     * @param clazz        导入数据类型
     * @param readListener 导入监听器
     * @param sheetIndex   Sheet索引
     * @param <T>          泛型
     */
    public static <T> void importExcel(InputStream inputStream, Class<T> clazz, ReadListener<T> readListener, int sheetIndex) {
        EasyExcel.read(inputStream, clazz, readListener)
                .excelType(ExcelTypeEnum.XLSX)
                .autoCloseStream(true)
                .sheet(sheetIndex)
                .doRead();
    }
}
