package com.adminparq.adminparq.infrastructure.db.springdata.dbo;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employee")
@Getter
@Setter
@NoArgsConstructor
public class EmployeeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id",unique=true, nullable = false)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "user")
  private String user;

  @Column(name = "password")
  private String password;

}
