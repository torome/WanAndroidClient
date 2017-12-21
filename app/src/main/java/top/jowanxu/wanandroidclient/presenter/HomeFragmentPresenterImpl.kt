package top.jowanxu.wanandroidclient.presenter

import top.jowanxu.wanandroidclient.bean.HomeListResponse
import top.jowanxu.wanandroidclient.model.HomeModel
import top.jowanxu.wanandroidclient.model.HomeModelImpl
import top.jowanxu.wanandroidclient.view.HomeFragmentView

class HomeFragmentPresenterImpl(private val homeFragmentView: HomeFragmentView) : HomePresenter.OnHomeListListener {

    private val homeModel: HomeModel = HomeModelImpl()
    /**
     * get home list
     * @param page page
     */
    override fun getHomeList(page: Int) {
        homeModel.getHomeList(this, page)
    }

    /**
     * get home list success
     * @param result result
     */
    override fun getHomeListSuccess(result: HomeListResponse) {
        homeFragmentView.getHomeListAfter()
        // 列表总数
        val total = result.data.total
        if (total == 0) {
            homeFragmentView.getHomeListZero()
            return
        }
        // 当第一页小于一页总数时
        if (total < result.data.size) {
            homeFragmentView.getHomeListSmall(result)
            return
        }
        homeFragmentView.getHomeListSuccess(result)
    }

    /**
     * get home list failed
     * @param errorMessage error message
     */
    override fun getHomeListFailed(errorMessage: String?) {
        homeFragmentView.getHomeListAfter()
        homeFragmentView.getHomeListFailed(errorMessage)
    }

    /**
     * cancel request
     */
    fun cancelRequest() {
        homeModel.cancelHomeListRequest()
    }
}
