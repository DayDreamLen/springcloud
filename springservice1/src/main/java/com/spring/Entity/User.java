package com.spring.Entity;

import lombok.Data;

import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * @Auther: CQ02
 * @Date: 2018/10/12 16:00
 * @Description:
 */
@Data
public class User {
   private Long id;
   private String userName;
   private String password;
   private List<String> roles;
}
