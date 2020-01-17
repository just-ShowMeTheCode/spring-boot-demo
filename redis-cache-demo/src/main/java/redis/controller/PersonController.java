package redis.controller;


import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import redis.model.Person;

/**
 * @author fumj
 * @projectName spring-boot-demo
 * @description: TODO
 * @date 2019/8/1910:53
 */
@RestController
@RequestMapping("/person")
public class PersonController {

    @PostMapping("/save")
    @Cacheable
    public ResponseEntity save(@RequestBody Person person){

        return new ResponseEntity("save success",HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Person person){

        return new ResponseEntity("save success",HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestParam Long personId){


        return new ResponseEntity("save success",HttpStatus.OK);
    }


    @PostMapping("/getById")
    public ResponseEntity get(@RequestParam Long personId){


        return new ResponseEntity("save success",HttpStatus.OK);
    }
}
