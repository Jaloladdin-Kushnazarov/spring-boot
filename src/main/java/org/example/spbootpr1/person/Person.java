package org.example.spbootpr1.person;

import lombok.*;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private String fullName;
    private Integer age;

    private String personAdressCity;
    private String personAdressAppartement;

    private String personPassportSeril;
    private String personPassportNumber;
}
