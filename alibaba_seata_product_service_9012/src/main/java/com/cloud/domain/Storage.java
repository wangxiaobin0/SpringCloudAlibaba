package com.cloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author
 * @date 2020/3/12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Storage implements Serializable {
    private Long id;
    private Long productId;
    private Integer total;
    private Integer used;
    private Integer residue;
}
