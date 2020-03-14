package com.cloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author
 * @date 2020/3/12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account implements Serializable {
    private Long id;
    private Long userId;
    private Double total;
    private Double used;
    private Double residue;
}
