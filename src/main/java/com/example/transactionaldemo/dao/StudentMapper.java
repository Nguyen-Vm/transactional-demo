package com.example.transactionaldemo.dao;

import com.example.transactionaldemo.entity.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

/**
 * @author 阮威敏
 * @date 2023/7/19
 */
@Mapper
public interface StudentMapper {

    @Insert("INSERT INTO student (name) VALUES(#{name})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Student student);
}
