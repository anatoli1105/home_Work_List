package com.skypro.homeWorkList;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(path ="/emloyee")
public class Controller {


    private  final EmployeeServis servis;

    public Controller(EmployeeServis servis) {
        this.servis = servis;
    }

    @GetMapping("/add")
    public  void  addWorker(@RequestParam String secondName,@RequestParam String firstName){
        servis.addWorker(secondName, firstName);

    }
    @GetMapping(path ="/find")
    public  String findWorker(@RequestParam String secondName,@RequestParam String firstName){

        return (servis.findWorker(secondName,firstName));

    }
    @GetMapping(path ="/remove")
    public  void removeWorker(@RequestParam String secondName,@RequestParam String firstName) {

        servis.removeWorker(secondName, firstName);

    }
    @GetMapping(path = "/list")
    public Collection<Employee> listWorker(){
        return servis.listWorker();
    }



}
