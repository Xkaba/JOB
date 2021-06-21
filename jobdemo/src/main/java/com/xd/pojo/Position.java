package com.xd.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Position {
    private int pid;
    private int bid;
    private String positionname;
    private int salary;
    private Date start_time;
    private Date end_time;

}
