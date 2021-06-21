package com.wyk.wisper.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author wuyongkng
 * @since 2021-06-17 10:48:23
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = -85455796533705616L;

    private Integer id;

    private String name;

    private String email;

    private String password;

}
