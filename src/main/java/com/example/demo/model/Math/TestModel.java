//Todos objetos existentes na aplicação, todos tem acesso

package com.example.demo.model.Math;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder


public class TestModel {

    private String nome;
    private Integer idade;
    private LocalDate sim;

}
