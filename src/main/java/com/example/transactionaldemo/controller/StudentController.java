package com.example.transactionaldemo.controller;

import com.example.transactionaldemo.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 阮威敏
 * @date 2023/7/19
 */
@RestController
public class StudentController {

    @Resource
    private StudentService studentService;

    @GetMapping("/insert")
    public void insert() {
        studentService.insertTestRollbackFor();
    }
}
