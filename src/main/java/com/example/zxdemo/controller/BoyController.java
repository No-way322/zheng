package com.example.zxdemo.controller;

import com.example.zxdemo.bean.Boy;
import com.example.zxdemo.service.BoyRepository;
import com.example.zxdemo.service.BoyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BoyController {
    @Autowired
    private BoyRepository boyRepository;

    @Autowired
    private BoyService boyService;

    /**
     * get查询
     * @return
     */
    @GetMapping(value = "/findBoy")
    public List<Boy> findAll(){
        return boyRepository.findAll();
    }

    @RequestMapping(value = "/find",method = RequestMethod.GET)
    public List<Boy> find(){
        return boyRepository.findAll();
    }

    /**
     * 添加一个用户
     */
    @PostMapping(value = "/addBoy")
    public Boy addBoy(@RequestParam("name") String name,@RequestParam("sex") String sex){
        Boy boy = new Boy();
        boy.setName(name);
        boy.setSex(sex);
        return boyRepository.save(boy);

    }

    /**
     * 根据id查找一个用户
     */
    @GetMapping(value = "/getBoy")
    public Optional<Boy> getBoy(@RequestParam("id") Integer id){
        return boyRepository.findById(id);
    }

    /**
     * 根据id查找一个用户
     */
    @GetMapping(value = "/findBoy/{id}")
    public Optional<Boy> findBoy(@PathVariable("id") Integer id){
        return boyRepository.findById(id);
    }

    /**
     * 根据id修改一个用户
     */
    @PostMapping(value = "/updateBoy")
    public Boy updateBoy(@RequestParam("id") Integer id,@RequestParam("name") String name,@RequestParam("sex") String sex){
        Boy boy = new Boy();
        boy.setId(id);
        boy.setSex(sex);
        boy.setName(name);
        return boyRepository.save(boy);
    }

    /**
     * 根据性别查询
     * @param sex
     * @return
     */
    @GetMapping(value = "/boys")
    public List<Boy> findBySex(@RequestParam("sex") String sex){
        return boyRepository.findBySex(sex);
    }


    /**
     * 添加多个
     */
    @GetMapping(value="/saveMore")
    public void saveMore(){
        boyService.saveMore();
    }

}
