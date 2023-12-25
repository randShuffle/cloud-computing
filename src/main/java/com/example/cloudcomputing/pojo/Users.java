package com.example.cloudcomputing.pojo;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 * @author szc
 * finish
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "users")
public class Users {
    //@TableId(type = IdType.AUTO)
    public Integer id;
    public String name;
    public String passwd;
    public Long phone;
    public String role;
}
