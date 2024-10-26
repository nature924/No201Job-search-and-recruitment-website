package cn.jia.service;

import cn.jia.common.ServerResponse;

/**
 * Created by matou on 2020/01/5.
 */
public interface CollectionService {
    ServerResponse show(int userId, int pageIndex, int pageSize);
    ServerResponse cancelCollection(int id);
}
