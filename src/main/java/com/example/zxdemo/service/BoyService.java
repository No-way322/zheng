package com.example.zxdemo.service;

import com.example.zxdemo.bean.Boy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class BoyService {
    @Autowired
    private BoyRepository boyRepository;

    @Transactional
    public void saveMore(){
        Boy a = new Boy();
        a.setName("henhe");
        a.setId(12);
        a.setSex("男");
        boyRepository.save(a);

        Boy b = new Boy();
        b.setName("hengeng");
        b.setId(13);
        b.setSex("sssssssssss");
        boyRepository.save(b);
    }
}
