package len.android.h2push.demo

import android.os.Bundle
import len.android.basic.activity.BaseActivity
import len.android.network.BaseRsp
import len.android.network.HttpRequest
import len.android.network.RequestEntity
import len.tools.android.JsonUtils
import len.tools.android.Log

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        httpDemoPush()
//        httpDemo360()
    }

    private fun httpDemo360() {
        App.getInstance().initRetrofit360()
        var requestEntity: RequestEntity =
            RequestEntity.Builder("IPQuery/ipquery").addParams("ip", "115.159.152.210").build()
        object : HttpRequest<Ip360Rsp>(this, requestEntity) {

            override fun onSuccess(result: Ip360Rsp?) {
                super.onSuccess(result)
                Log.e(JsonUtils.toJson(result))
                showToast(result!!.data)
            }

            override fun onFail(result: BaseRsp?) {
                super.onFail(result)
                Log.e(JsonUtils.toJson(result))
                showToast(result!!.msg)
            }

        }.get()
    }

    private fun httpDemoPush() {
        App.getInstance().initRetrofitPush()
        var requestEntity: RequestEntity = RequestEntity.Builder("demo/").build()
        object : HttpRequest<BaseRsp>(this, requestEntity) {

            override fun onSuccess(result: BaseRsp?) {
                super.onSuccess(result)
                Log.e(JsonUtils.toJson(result))
            }

            override fun onFail(result: BaseRsp?) {
                super.onFail(result)
                Log.e(JsonUtils.toJson(result))
            }

        }.get()
    }
}
