// Porta de entrada da aplicação, acesso apenas a service

package com.example.demo.controller.Math;

import com.example.demo.model.math.TestResult;
import com.example.demo.service.math.MathService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/math")

public class MathController {

    private final MathService mathService;


    @GetMapping("/{math}")
    public Double getTest (@PathVariable String math,
                              @RequestParam Double one,
                              @RequestParam Double two){
        return mathService.mathHandler(math, one, two);
    }

    @GetMapping("/math/all")
    public TestResult getTestEight (@RequestParam Double one,
                                   @RequestParam Double two){
        return mathService.testResultDois(one, two);
    }


/*   @GetMapping("/{age}")
    public TestModel getTest (@PathVariable Integer age,
                              @RequestParam String batata,
                              @RequestParam
                                  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                          LocalDate data) {
        return TestModel.builder()
                .nome(batata)
                .idade(age)
                .sim(data)
                .build();
    }

 */

//    @GetMapping("/sum")
//    public Double getTestTwo (@RequestParam Double one,
//                                  @RequestParam Double two) {
//        return testService.sumMate(one,two);
//    }
//
//    @GetMapping("/sub")
//    public Double getTestThree (@RequestParam Double one,
//                                @RequestParam Double two) {
//        return testService.subMate(one,two);
//    }
//
//    @GetMapping("/multi")
//    public Double getTestFour (@RequestParam Double one,
//                                 @RequestParam Double two) {
//        return testService.multiMate(one,two);
//    }
//
//    @GetMapping("/div")
//    public Double getTestFive (@RequestParam Double one,
//                                 @RequestParam Double two) {
//        return testService.divMate(one,two);
//    }
//
//    @GetMapping("/sqrt")
//    public Double getTestSix (@RequestParam Double one){
//        return testService.sqrtMate(one);
//    }
//
//    @GetMapping("/pow")
//    public Double getTestSeven (@RequestParam Double one,
//                                @RequestParam Double two){
//        return testService.powMate(one,two);
//    }

}
