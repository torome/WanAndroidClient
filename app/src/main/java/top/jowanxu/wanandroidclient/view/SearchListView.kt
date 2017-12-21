package top.jowanxu.wanandroidclient.view

import top.jowanxu.wanandroidclient.bean.SearchListResponse

/**
 * 搜索View接口
 */
interface SearchListView {
    /**
     * get search result List after operation
     */
    fun getSearchListAfter()
    /**
     * get search result list success
     */
    fun getSearchListSuccess(result: SearchListResponse)
    /**
     * 获取搜索结果列表失败
     */
    fun getSearchListFailed(errorMessage: String?)
    /**
     * get search result list data size equal zero
     */
    fun getSearchListZero()
    /**
     * get search result list data less than 20
     */
    fun getSearchListSmall(result: SearchListResponse)

}