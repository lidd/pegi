package com.youon.pegi.nj.infrastructure;

import com.youon.pegi.nj.domain.frame.NJResp;

/**
 * @author Li dong
 */

public interface BizHandler<T> {

    <R extends NJResp> R handle(T t);
}
