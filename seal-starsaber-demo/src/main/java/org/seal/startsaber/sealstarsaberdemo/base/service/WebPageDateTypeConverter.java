package org.seal.startsaber.sealstarsaberdemo.base.service;

import org.seal.starsaber.arch.http.WebPage;

import java.util.List;

/**
 * @author seal
 * @version v1.0.0
 * @description
 * @createTime 2018-10-01 09:03:07
 */
@FunctionalInterface
public interface WebPageDateTypeConverter {

    <T, V> void convert(List<V> list, WebPage<T> webPage);
}
