package com.skypro.homeWorkList;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Service
public class EmployeeServis {

    private final List<Employee> employees=new ArrayList<>(10);
    public  void addWorker(String secondName,String firstname ) {
        if (employees.size() >= 10) {
            throw new EmployeeStorageFullException();
        }
        Employee employee = find(secondName, firstname);

        if (employee != null) {
            throw new EmployeeAlredyAddedException();
        }
        employees.add(new Employee(secondName,firstname));

    }
    public void removeWorker(String secondName,String firstname){
        if(find(secondName,firstname)==null){
            throw new EmployeeNotFoundException();
        }else {

            employees.remove(find(secondName,firstname));
        }
    }
    public String findWorker(String secondName,String firstname){
        if(find(secondName,firstname)==null){
            throw new EmployeeNotFoundException();
        }else {
            return secondName+firstname;
        }

    }
    public Employee find(String secondName,String firstname){
        for(Employee iter: employees){
            if(iter.getSecondName().equals(secondName)&&iter.getFirstName().equals(firstname)){
                return iter;
            }
        }
        return null;
    }
    public Collection<Employee> listWorker(){
        return employees;
    }
}