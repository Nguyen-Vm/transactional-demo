package com.example.transactionaldemo.service;

import com.example.transactionaldemo.dao.StudentMapper;
import com.example.transactionaldemo.entity.Student;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author 阮威敏
 * @date 2023/7/19
 */
@Service
public class StudentService {

    @Resource
    private StudentMapper studentMapper;

    @Transactional(rollbackFor = Exception.class, noRollbackFor = RuntimeException.class)
    public void insertTestNoRollbackFor() {
        Student student = new Student();
        student.setName("insertTestNoRollbackFor");
        studentMapper.insert(student);
        throw new RuntimeException();
    }

    @Transactional(rollbackFor = RuntimeException.class, noRollbackFor = Exception.class)
    public void insertTestRollbackFor() {
        Student student = new Student();
        student.setName("insertTestRollbackFor");
        studentMapper.insert(student);
        throw new RuntimeException();
    }

    @Transactional(rollbackFor = RuntimeException.class, noRollbackFor = Exception.class)
    public void insertTest() {
        Student student = new Student();
        student.setName("insertTest");
        studentMapper.insert(student);
        throw new NullPointerException();
    }
}
