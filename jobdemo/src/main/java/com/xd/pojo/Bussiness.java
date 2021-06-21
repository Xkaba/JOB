package com.xd.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bussiness {

    private int bid;
    private String bussinessname;
    private String password;
    private String address;
    private String phone;

}
