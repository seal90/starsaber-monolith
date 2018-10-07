package org.seal.startsaber.sealstarsaberdemo.base.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.seal.starsaber.arch.http.WebPage;
import org.seal.starsaber.arch.service.StarSaberService;

import java.util.List;

/**
 * @author seal
 * @version v1.0.0
 * @description
 * @createTime 2018-10-01 09:03:07
 */
public abstract class BaseService extends StarSaberService {

    /**
     * 配置 Mybatis 分页
     * @param webPage
     */
    protected void startPage(WebPage webPage){
        PageHelper.startPage(webPage.getPageNum(), webPage.getPageSize());
    }

    /**
     * 配置 Mybatis 分页，不执行默认 count 语句
     * @param webPage
     */
    protected void startNoCountPage(WebPage webPage){
        PageHelper.startPage(webPage.getPageNum(), webPage.getPageSize(), false);
    }

    /**
     * 构造返回值
     * @param list
     * @param webPage
     * @param <T>
     * @return
     */
    protected <T> WebPage<List<T>> resultPage(List<T> list, WebPage webPage){
        Page<T> page = (Page)list;
        WebPage<List<T>> webPageList = new WebPage<>();
        webPageList.setData(list);
        webPageList.setTotal(page.getTotal());
        webPageList.setPageNum(webPage.getPageNum());
        webPageList.setPageSize(webPage.getPageSize());
        webPageList.setOrderBy(webPage.getOrderBy());
        return webPageList;
    }

    /**
     * 构造与传入值不同的返回值
     * @param list
     * @param webPage
     * @param <T>
     * @return
     */
    protected <T, V> WebPage<List<T>> resultPage(List<V> list, WebPage webPage,
                                                 WebPageDateTypeConverter converter){
        Page<V> page = (Page)list;
        WebPage<List<T>> webPageList = new WebPage<>();
        converter.convert(list, webPageList);
        webPageList.setTotal(page.getTotal());
        webPageList.setPageNum(webPage.getPageNum());
        webPageList.setPageSize(webPage.getPageSize());
        webPageList.setOrderBy(webPage.getOrderBy());
        return webPageList;
    }
}
