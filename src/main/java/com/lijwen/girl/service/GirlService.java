package com.lijwen.girl.service;

import com.lijwen.girl.domail.Girl;
import com.lijwen.girl.enums.ResultEnum;
import com.lijwen.girl.exception.GirlException;
import com.lijwen.girl.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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

    public void getAge(Integer id) {
        Girl girl = girlRepository.getOne(id);
        Integer age = girl.getAge();
        if (age < 10) {
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        } else if (age > 10 && age < 16) {
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
    }

    /**
     * 通过Id查询一个女生的信息
     *
     * @param id
     * @return
     */
    public Girl findOne(Integer id) {
        Optional<Girl> girl = girlRepository.findById(id);

        return girl.get();
    }

}
