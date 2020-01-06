package com.skycloud.service.order.config;

import tk.mybatis.mapper.genid.GenId;

/**
 * 简单全局自增ID
 * 生产环境不要使用
 *
 * @author
 */
public class SimpleGenId implements GenId<Long> {
    private Long time;
    private Integer seq;

    @Override
    public synchronized Long genId(String table, String column) {
        long current = System.currentTimeMillis();
        if (time == null || time != current) {
            time = current;
            seq = 1;
        } else if (current == time) {
            seq++;
        }
        return (time << 20) | seq;
    }
}
