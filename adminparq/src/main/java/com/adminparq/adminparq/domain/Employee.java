package com.adminparq.adminparq.domain;

/*Objeto*/

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter /*obtener el valor de una propiedad de la clase y asi poder utilizar
dicho valor en diferentes metodos */
@Setter /*su funcion permite brindar acceso a propiedades especificas para poder asignar
un valor fuera de la clase */
@AllArgsConstructor /*genera un constructor para todos los atributos de la clase.*/
@NoArgsConstructor /*genera un constructor sin argumentos, uno vacío */
public class Employee {

    private Long id;

    private String name;

    private String user;

    private String password;

}
