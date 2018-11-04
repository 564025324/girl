package com.lijwen.girl.service;

import com.lijwen.girl.domail.Girl;
import com.lijwen.girl.exception.GirlException;
import com.lijwen.girl.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo() {
        Girl girlA = new Girl();
        girlA.setCupSize("B");
        girlA.setAge(25);
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("BA");
        girlB.setAge(31);
        girlRepository.save(girlB);
    }

    public void getAge(Integer id) throws Exception {
        Girl girl = girlRepository.getOne(id);
        Integer age = girl.getAge();
        if (age < 10) {
            throw new GirlException(100,"你还在上小学吧");
        } else if (age > 10 && age < 16) {
            throw new GirlException(101,"你可能在上初中");
        }
    }

}
