
/**
 * Campos de base de datos
 */

package com.adminparq.adminparq.infrastructure.db.springdata.dbo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Anotación JPA utilizada para indicar que la clase anotada es una clase de entidad JPA.
 */
@Entity

/**
 * Proporcionado por JPA para especificar más detalles sobre la tabla asociada a la clase.
 */
@Table(name = "employee")

/**
 * Getter y setter son anotaciones de Lombok que se utilizan para
 * generar métodos Getters y Setters para todos los campos automáticamente.
 * También puede usar la anotación @Data
 */
@Getter
@Setter

/**
 * Generar un constructor predeterminado sin argumentos para nuestra clase.
 */
@NoArgsConstructor

public class EmployeeEntity {

    /**
     * Se utiliza para vincular el campo anotado a la columna de clave principal.
     */
    @Id

    /**
     *   Define la estrategia de generación de claves primarias. IDENTIDAD
     *   significa que los valores de la clave principal se generarán mediante un campo de incremento automático.
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Basic(optional = false)

    /**
     * Es una anotación JPA que usamos para definir algunos detalles sobre la columna mapeada.
     */
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "user")
    private String user;

    @Column(name = "password")
    private String password;

}

