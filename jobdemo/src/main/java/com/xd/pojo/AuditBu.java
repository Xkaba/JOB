package com.xd.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuditBu {
    private int pid;
    private String positionname;
    private int salary;
    private Date start_time;
    private Date end_time;

    private int status;
    private int sid;

    private int bid;
    private String bussinessname;
    private String address;
    private String phone;
}
